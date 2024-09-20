import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PoingCoinManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PongCoinManager extends Actor
{
    private static int pongCoins = 0;
    public void act()
    {
        addCoin();
        getPongCoins();
    }
    public static void addCoin(){
        pongCoins++;
    }
    public static int getPongCoins(){
        return pongCoins;
    }
    public static void useCoins(int amount){
        if(pongCoins >= amount){
            pongCoins -= amount;
        }
    }
}
