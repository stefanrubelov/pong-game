import greenfoot.*;

public class ComputerPaddle extends Paddle
{
    private int width = 100;
    private int height = 20;
    private int dx = 1;
    private static final double SPEED_PADDLE = 0.7;
    private double speed = 2;
    private double level = 1;
    private final int WORLD_TOP_START = 50;
    
    public ComputerPaddle(double level) {
        super();
        this.level = level;
        this.speed = level + SPEED_PADDLE;
        createImage();
    }

    /**
     * Act - do whatever the ComputerPaddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        checkBallPosition();
        //handleEdgeWrapping();
    }

    public void checkBallPosition(){
        Ball ball = (Ball)getWorld().getObjects(Ball.class).get(0);
        
        if(ball != null && ball.getY() <500){
            int ballX = ball.getX();
            int currentX = getX();
            
            //int randomOffset = Greenfoot.getRandomNumber(20) - 10;
            if (Math.abs(ballX - currentX) > speed) {
                if (ballX > currentX) {
                    setLocation(currentX + (int)speed , getY()); // Move paddle right
                } else {
                    setLocation(currentX - (int)speed , getY()); // Move paddle left
                }
            }  
        }
    }
    /**
     * Creates and sets an image for the paddle, the image will have the same dimensions as the paddles width and height.
     */
    private void createImage()
    {
       GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(Color.RED);
        image.fill();
        setImage(image);
    }
    /*
     * 
     private void handleEdgeWrapping() {
        World world = getWorld();
        int worldWidth = world.getWidth();
        int worldHeight = world.getHeight();
        int currentX = getX();

        if(getX() == getWorld().getWidth()-1) { 
            updatePaddleSize();
            createImage();
            setLocation(1, Number.getRandom(WORLD_TOP_START, (world.getHeight() - world.getHeight() / 4))); 
        }
        if(getX() == 0) { 
            updatePaddleSize();
            createImage();
            setLocation(world.getWidth()-1, Number.getRandom(WORLD_TOP_START, (world.getHeight() - world.getHeight() / 4))); 
        }

    }*/

    protected void addedToWorld(World world) {
        randomStart();
    }

    private void randomStart() {
        int reduceDistanceFromMiddle = 30;
        
        World world = getWorld();
        if (world == null) return;

        if (Greenfoot.getRandomNumber(2) == 0) {
            setLocation(0 - width / 2, Number.getRandom(WORLD_TOP_START, (world.getHeight() / 2) - reduceDistanceFromMiddle));
            dx = 1;
        } else {
            setLocation(world.getWidth() + width / 2, Number.getRandom(WORLD_TOP_START, (world.getHeight() / 2) - reduceDistanceFromMiddle));
            dx = -1;
        }
    }
    
    /*
     * 
    private void updatePaddleSize(){
        int randomWidth = Number.getRandom(50, 250);
        int randomHeight = Number.getRandom(10, 25);
        this.width = randomWidth;
        this.height = randomHeight;
    } */
}
