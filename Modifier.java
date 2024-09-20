import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Modifier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Modifier extends Actor
{
    /**
     * Act - do whatever the Modifier wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveDown();
    }

    protected void moveDown() {
        setLocation(getX(), getY() + 2);
        //PongWorld world = (PongWorld) getWorld();
        //if (getY() >= world.getHeight() - 1) {
            //if (world != null){
                //   world.removeObject(this);
            //}
        //}
    }

    protected void checkForBallCollision() {
        Ball ball = (Ball) getOneIntersectingObject(Ball.class);

        if (ball != null) {
            ball.revertVertically();
            getWorld().removeObject(this);
        }
    }

    public abstract void apply();

}
