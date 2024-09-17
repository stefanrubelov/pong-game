import greenfoot.*;

public class Balll extends SmoothMover
{
    private static final int BALL_SIZE = 25;
    private static final int BOUNCE_DEVIANCE_MAX = 5;
    private static final int STARTING_ANGLE_WIDTH = 90;
    private static final int DELAY_TIME = 100;
    private int speed;
    private int hitCounter = 0;
    private static final int HITS_FOR_SPEED_INCREASE = 10;
    private static final int SPEED_INCREMENT = 1;

    private boolean hasBouncedHorizontally;
    private boolean hasBouncedVertically;
    private int delay;
    private int smokeDelayCounter = 0;
    //private int smokeDelayTime = 4;
    //private boolean touchingPaddle = false;

    /**
     * Contructs the ball and sets it in motion!
     */
    public Balll()
    {
        createImage();
        init();
    }

    /*public void checkComputerPaddle(){
        Actor computerPaddle = getOneIntersectingObject(ComputerPaddle.class);
    
    if (computerPaddle != null) {
        // Ensure the computer paddle is in the world before accessing it
        if (computerPaddle.getWorld() != null) {
            if (getY() < computerPaddle.getY()) {
                // Ball is hitting from below - bounce back
                revertVertically();  // Invert the vertical movement
            }
        }
        }
    }*/

   /* private void addSmokeDelay(){
        smokeDelayCounter++;
        if (smokeDelayCounter >= smokeDelayTime) {
            // Spawn smoke at the current location of the ball
            Smoke smoke = new Smoke();
            getWorld().addObject(smoke, getX(), getY());

            // Reset the counter to keep the delay consistent
            smokeDelayCounter = 0;
        }
    }

    /**
     * Creates and sets an image of a black ball to this actor.
     */
    private void createImage()
    {
        GreenfootImage ballImage = new GreenfootImage(BALL_SIZE,BALL_SIZE);
        ballImage.setColor(Color.YELLOW);
        ballImage.fillOval(0, 0, BALL_SIZE, BALL_SIZE);
        setImage(ballImage);
    }

    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (delay > 0)
        {
            delay--;
        }
        else
        {
            move();
            makeSmoke();
            checkPaddleHit();
            //checkComputerPaddle();
            checkBounceOffWalls();
            checkBounceOffCeiling();
            checkRestart();
        }
    }    
    private void move(){
        move(speed);
    }

    private void makeSmoke()
    {
        smokeDelayCounter++;
        if (smokeDelayCounter >= Greenfoot.getRandomNumber(8)) {
            // Spawn smoke at the current location of the ball
            Smoke smoke = new Smoke();
            getWorld().addObject(smoke, getX(), getY());

            // Reset the counter to keep the delay consistent
            smokeDelayCounter = 0;
        }
    }

    /**
     * Returns true if the ball is touching one of the side walls.
     */
    private boolean isTouchingSides()
    {
        return (getX() <= BALL_SIZE/2 || getX() >= getWorld().getWidth() - BALL_SIZE/2);
    }

    /**
     * Returns true if the ball is touching the ceiling.
     */
    private boolean isTouchingCeiling()
    {
        return (getY() <= BALL_SIZE/2);
    }

    /**
     * Returns true if the ball is touching the floor.
     */
    private boolean isTouchingFloor()
    { 
        return (getY() >= getWorld().getHeight() - BALL_SIZE/2);
    }

    /**
     * Check to see if the ball should bounce off one of the walls.
     * If touching one of the walls, the ball is bouncing off.
     */
    private void checkBounceOffWalls()
    {
        if (isTouchingSides())
        {
            if (! hasBouncedHorizontally)
            {
                revertHorizontally();
            }
        }
        else
        {
            hasBouncedHorizontally = false;
        }
    }

    /**
     * Check to see if the ball should bounce off the ceiling.
     * If touching the ceiling the ball is bouncing off.
     */
    private void checkBounceOffCeiling()
    {
        if (isTouchingCeiling())
        {
            if (! hasBouncedVertically)
            {
                revertVertically();
                Greenfoot.playSound("Pew.mp3");
            }
        }
        else
        {
            hasBouncedVertically = false;
        }
    }
         public void gameOver(){
    Greenfoot.setWorld(new GameOverWorld());
    }
    /**
     * Check to see if the ball should be restarted.
     * If touching the floor the ball is restarted in initial position and speed.
     */
    private void checkRestart()
    {
        if (isTouchingFloor())
        {
            gameOver();
        }
    }

    /**
     * Bounces the ball back from a vertical surface.
     */
    private void revertHorizontally()
    {
        int randomness = Greenfoot.getRandomNumber(BOUNCE_DEVIANCE_MAX)- BOUNCE_DEVIANCE_MAX / 2;
        setRotation((180 - getRotation()+ randomness + 360) % 360);
        hasBouncedHorizontally = true;
    }

    /**
     * Bounces the bal back from a horizontal surface.
     */
    public void revertVertically()
    {
        int randomness = Greenfoot.getRandomNumber(BOUNCE_DEVIANCE_MAX)- BOUNCE_DEVIANCE_MAX / 2;
        setRotation((360 - getRotation()+ randomness + 360) % 360);
        hasBouncedVertically = true;
    }

    /**
     * Initialize the ball settings.
     */
    private void init()
    {
        speed = 2;
        delay = DELAY_TIME;
        hasBouncedHorizontally = false;
        hasBouncedVertically = false;
        setRotation(Greenfoot.getRandomNumber(STARTING_ANGLE_WIDTH)+STARTING_ANGLE_WIDTH/2);
    }
    public void checkPaddleHit() {
        // Assuming Paddle is the parent class of both paddles
        if(isTouching(Paddle.class)){
        Paddle paddle = (Paddle) getOneIntersectingObject(Paddle.class);
        
        if (paddle != null) {
            revertVertically(); // Bounce the ball
            Greenfoot.playSound("Buh.mp3");
            hitCounter++;

            // Increase the speed every 10 hits
            if (hitCounter >= HITS_FOR_SPEED_INCREASE) {
                speed += SPEED_INCREMENT; // Increase the speed
                hitCounter = 0; // Reset the counter after speed increase
            }
            
            setLocation(getX(), getY()-5);
        }
    }else{
        //hasTouchedPaddle = false;
    }
    }
}