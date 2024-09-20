import greenfoot.*;

/**
 * Write a description of class Paddle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Paddle extends Actor
{

    public boolean checkIntersectionBalll() {
        Ball ball = (Ball) getOneIntersectingObject(Ball.class);
        return ball != null;
    }

    public void checkIfAtHorizontalEdge() 
    {
        int x = getX();
        int y = getY();

        int worldWidth = getWorld().getWidth();

        int halfWidth = getImage().getWidth() / 2;

        if (x - halfWidth < 0) {
            setLocation(halfWidth, y);
        }
        
        if (x + halfWidth > worldWidth) {
            setLocation(worldWidth - halfWidth, y);
        }
    }
}