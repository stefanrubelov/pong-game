import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerPaddle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerPaddle extends Paddle
{
    private int width;
    private int height;
    private int dx;
    private int move_step = 5;

    /**
     * Constructs a new paddle with the given dimensions.
     */
    public PlayerPaddle(int width, int height)
    {
        setImage("paddle1b.png");
    }

    /**
     * Act - do whatever the Paddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        changeDirection();
        //setLocation(getX() + dx, getY());
        // Check if the ball is intersecting the self-moving paddle
        if (checkIntersectionBalll()) {
            Balll ball = (Balll) getOneIntersectingObject(Balll.class);
            if (ball != null && ball.getY() < getY()) {
                // If the ball is above the paddle, make it bounce up
                ball.revertVertically();  // Invert vertical direction
            }
        }
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
    }
