import greenfoot.*;
/**
 * Write a description of class Number here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Number  
{
    public static int getRandom(int from, int to){
        if (from > to) {
            throw new IllegalArgumentException("'from' should be less than or equal to 'to'");
        }
        return from + Greenfoot.getRandomNumber(to - from + 1);
    }
}
