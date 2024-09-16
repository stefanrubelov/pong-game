import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

public class PongWorld extends World
{
    public PongWorld(boolean gameStarted) 
    {
        super(400, 600, 1);
        
        if (gameStarted) {
            GreenfootImage background = getBackground(); 
            background.setColor(Color.BLACK);
            background.fill();
            setPaintOrder(Balll.class,Smoke.class);
            addObject (new Balll(), getWidth()/2, getHeight()/2);
            addObject(new PlayerPaddle(100,20),getWidth()/2, 550);
            addObject(new ComputerPaddle(), 0, 0);
        } else {
            Greenfoot.setWorld(new StartWorld());
        }
        
        
    }
}
//*private void paintStars(int numberStars)
//{
//  for(int i=0;i<numberStars;i++)
//{
//  GreenfootImage background = getBackground();
//int x = Greenfoot.getRandomNumber(getWidth());
//int y = Greenfoot.getRandomNumber(getHeight());
//int size = 3;

//background.setColor(Color.YELLOW);
//background.fillOval(x, y, size, size);
 