import greenfoot.*;

public class Number extends Helper
{
    public static int getRandom(int from, int to){
        if (from > to) {
            throw new IllegalArgumentException("'from' should be less than or equal to 'to'");
        }
        return from + Greenfoot.getRandomNumber(to - from + 1);
    }
}
