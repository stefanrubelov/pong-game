import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Title extends Actor
{
    private int pongX, battleX;
    private final int speed = 5;
    
    public Title(){
        pongX = -180;
        battleX = 500;
        setImage(new GreenfootImage(1,1));
        //ongImage = new GreenfootImage("Pong", 50, Color.YELLOW, new Color(0, 0, 0, 70));
        //battleImage = new GreenfootImage("Battle", 50, Color.YELLOW, new Color(0, 0, 0, 70));
    }
    public void act()
    {
        GreenfootImage image = new GreenfootImage(getWorld().getWidth(),40);
        image.setColor(new Color(0,0,0,0));
        image.fill();
        image.setFont(new Font("Comic Sans MS",true, false, 40));
        image.setColor(Color.WHITE);
        image.drawString("Pong", pongX, 30);
        image.drawString("Battle", battleX, 30);
        
        setImage( image);
        
         // Move the words toward the center
        pongX += speed;  // Move "Pong" to the right
        battleX -= speed;  // Move "Battle" to the left
        if (pongX >= getWorld().getWidth() / 2 - 90) {
            pongX = getWorld().getWidth() / 2 - 90;
        }
        if (battleX <= getWorld().getWidth() / 2 + 10) {
            battleX = getWorld().getWidth() / 2 + 10;  // Center "Battle"
        }
    }
}
