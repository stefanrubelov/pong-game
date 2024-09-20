import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverTitle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverTitle extends Actor
{
    GifImage goGif = new GifImage("GameOver.gif");
    public void act()
    {
        setImage( goGif.getCurrentImage());
    }
}
