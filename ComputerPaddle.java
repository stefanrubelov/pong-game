import greenfoot.*;

public class ComputerPaddle extends Paddle
{
    private int width = 100;
    private int height = 20;
    private int dx = 1;
    private final int WORLD_TOP_START = 50;
    
    public ComputerPaddle() {
        createImage();
    }

    /**
     * Act - do whatever the ComputerPaddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        movePaddle();
        handleEdgeWrapping();
        setLocation(getX() + dx, getY());
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

    private void movePaddle() {
        setLocation(getX() + dx, getY());
    }

    private void handleEdgeWrapping() {
        World world = getWorld();
        int worldWidth = world.getWidth();
        int worldHeight = world.getHeight();
        int currentX = getX();

        if(getX() == getWorld().getWidth()-1) { 
            setLocation(1, Number.getRandom(WORLD_TOP_START, world.getHeight() / 2)); 
        }
        if(getX() == 0) { 
            setLocation(world.getWidth()-1, Number.getRandom(WORLD_TOP_START, world.getHeight() / 2)); 
        }

    }

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
}
