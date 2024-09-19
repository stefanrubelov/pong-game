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
            
            paintStars(250);
            
            setPaintOrder(Ball.class,Smoke.class);
            addObject (new Ball(), getWidth()/2, getHeight()/2);
            addObject(new PlayerPaddle(100,20),getWidth()/2, 550);
            addObject(new ComputerPaddle(), 0, 0);
        } else {
            Greenfoot.setWorld(new StartWorld());
        }
    }
    private void paintStars(int numberStars)
    {
        for(int i=0;i<numberStars;i++)
        {
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());
        addObject (new BackgroundEffect(), x, y);
    }
    }
}