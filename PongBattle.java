import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PongBattle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PongBattle extends Actor
{
    GifImage pbGif = new GifImage("PongBattle.gif");
    public void act()
    {
        setImage( pbGif.getCurrentImage());
    }
}
