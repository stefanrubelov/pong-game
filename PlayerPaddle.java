import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerPaddle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerPaddle extends Paddle
{
    private int width = 100;
    private int height = 20;
    private int dx;
    private int move_step = 5;

    /**
     * Constructs a new paddle with the given dimensions.
     */
    public PlayerPaddle(int width, int height)
    {
        createImage();
    }

    /**
     * Act - do whatever the Paddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        changeDirection();
        checkForModifier();
    }    

    private void changeDirection()
    {
        checkIfAtHorizontalEdge();

        if(Greenfoot.isKeyDown("right")){
            move(move_step);
        }

        if(Greenfoot.isKeyDown("left")){
            move(-move_step);
        }
    }

    private void createImage()
    {
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(Color.WHITE);
        image.fill();
        setImage(image);
    }

    private void checkForModifier() {
        if (isTouching(Modifier.class)) {
            Modifier modifier = (Modifier) getOneIntersectingObject(Modifier.class);

            if (modifier != null) {
                modifier.apply();
            }
        }
    }
}
