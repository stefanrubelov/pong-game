import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Title extends Actor
{
    GreenfootImage pongImage;
    GreenfootImage battleImage;
    int pongX = -100;
    int battleX = 420;
    int yPosition = 300;
    
    public Title(){
        GreenfootImage blankImage = new GreenfootImage(1, 1);
        setImage(blankImage);
        
        pongImage = new GreenfootImage("Pong", 50, Color.YELLOW, new Color(0, 0, 0, 70));
        battleImage = new GreenfootImage("Battle", 50, Color.YELLOW, new Color(0, 0, 0, 70));
    }
    public void act()
    {
        if (pongX < 100) {
            pongX += (100 - pongX)/10;
            //pongX += 5;
        }
        if (battleX >200){
            battleX -= (battleX - 200)/10;
            //battleX -= 5;
        }
        //getWorld().getBackground().clear();
        getWorld().getBackground().drawImage(pongImage, pongX, yPosition);
        getWorld().getBackground().drawImage(battleImage, battleX, yPosition);
    }
}
