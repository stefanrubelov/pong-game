import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BuyPaddleWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BuyPaddleWorld extends World
{
    private GreenfootImage PaddleImage = new GreenfootImage("venus.jpg");
    public BuyPaddleWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 600, 1); 
        getBackground().drawImage(PaddleImage, 0, 0);
        //getBackground().drawImage(PaddleImage,getWidth(),getHeight());
        showText("PongCoins: " + PongCoinManager.getPongCoins(), 200, 52);
        addObject(new PaddleOption(10, "Brown Paddle","Brown"), 100, 200);
        addObject(new PaddleOption(20, "Silver Paddle", "Silver"), 100, 300);
        addObject(new PaddleOption(30, "Golden Paddle", "Golden"), 100, 400);
    }
    public void act(){
        if (Greenfoot.isKeyDown("enter")) {
            restartGame();
        }
    }
    private void restartGame() {
        String defaultPaddleColor = "Blue";
        Greenfoot.setWorld(new PongWorld(true, defaultPaddleColor));
    }
}
