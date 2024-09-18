import greenfoot.*;

public class Balll extends SmoothMover
{
    private static final int BALL_SIZE = 25;
    private static final int BOUNCE_DEVIANCE_MAX = 5;
    private static final int STARTING_ANGLE_WIDTH = 90;
    private static final int DELAY_TIME = 100;
    private double speed;
    private int hitCounter = 0;
    private static final int HITS_FOR_SPEED_INCREASE = 10;
    private static final double SPEED_INCREMENT = 0.7;

    private boolean hasBouncedHorizontally;
    private boolean hasBouncedVertically;
    private int delay;
    private int smokeDelayCounter = 0;
    //private int smokeDelayTime = 4;
    //private boolean touchingPaddle = false;

    private Label scoreLabel;
    private int levelNumber = 1;
    private boolean hasTouchedPaddle = false;

    /**
     * Contructs the ball and sets it in motion!
     */
    public Balll()
    {
        createImage();
        init();
    }

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
            checkComputerPaddleHit();
            checkBounceOffWalls();
            checkBounceOffCeiling();
            checkRestart();
            updateLevel();
        }
    }    

    private void move(){
        move(speed);
    }

    private void makeSmoke()
    {
        smokeDelayCounter++;
        if (smokeDelayCounter >= Greenfoot.getRandomNumber(8)) {
            Smoke smoke = new Smoke();
            getWorld().addObject(smoke, getX(), getY());

            smokeDelayCounter = 0;
        }
    }

    public void addedToWorld(World world)
    {
        displayLevel();
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
        } else {
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
                GameSound.pew();
            }
        } else {
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

    private void displayLevel()
    {
        scoreLabel = new Label("Level " + levelNumber, 40); 
        
        getWorld().addObject(scoreLabel, 314, 26);  
    }

    private void updateLevel()
    {
        World world = getWorld();
        if (scoreLabel != null)
        {
            world.removeObject(scoreLabel);
        }

        scoreLabel = new Label("Level " + levelNumber, 40);

        world.addObject(scoreLabel, 314, 26); 

    }

    public void checkPaddleHit() {
        if (isTouching(Paddle.class)) {
            PlayerPaddle paddle = (PlayerPaddle) getOneIntersectingObject(PlayerPaddle.class);

            if (paddle != null && !hasTouchedPaddle) {
                revertVertically();
                hasTouchedPaddle = true;
                hitCounter++;

                if (hitCounter >= HITS_FOR_SPEED_INCREASE) {
                    speed += SPEED_INCREMENT;
                    levelNumber++;
                    hitCounter = 0;
                }
                GameSound.buh();
                setLocation(getX(), getY() - 5);
            }
        } else if (hasTouchedPaddle) {
            hasTouchedPaddle = false;
        }
    }

    private void checkComputerPaddleHit() 
    {
        if (isTouching(ComputerPaddle.class)) {
            ComputerPaddle paddle = (ComputerPaddle) getOneIntersectingObject(ComputerPaddle.class);

            if (paddle != null) {
                int ballY = getY();
                int ballX = getX();
                int paddleTopY = paddle.getY() - paddle.getImage().getHeight() / 2;
                int paddleBottomY = paddle.getY() + paddle.getImage().getHeight() / 2;
                int paddleLeftX = paddle.getX() - paddle.getImage().getWidth() / 2;
                int paddleRightX = paddle.getX() + paddle.getImage().getWidth() / 2;

                if (ballY >= paddleBottomY && ballX >= paddleLeftX && ballX <= paddleRightX) {
                    revertVertically();
                    setLocation(getX(), getY() + 5);
                } else if (ballY < paddleTopY && ballX >= paddleLeftX && ballX <= paddleRightX) {
                    return;
                }
            }
        } else {
            hasTouchedPaddle = false;
        }
    }

}