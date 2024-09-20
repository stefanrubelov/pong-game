import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BuyPaddleButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BuyPaddleButton extends Actor
{
    public BuyPaddleButton() {
        setImage(new GreenfootImage("Buy Paddle", 24, Color.WHITE, Color.BLACK));
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new BuyPaddleWorld());
        }
    }
}
