import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackgroundEffect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackgroundEffect extends Actor
{
    public BackgroundEffect(){
        GreenfootImage image = new GreenfootImage(3,3);
        image.setColor(Color.YELLOW);
        image.fillOval(0, 0, 3, 3);
        setImage(image);
    }
    public void act()
    {   
    turn(10);
    }
}
