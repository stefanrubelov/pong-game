import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ComputerPaddle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComputerPaddle extends Paddle
{
    private int width = 100;
    private int height = 20;
    private int dx = 1;

    public ComputerPaddle(){
        createImage();
    }

    /**
     * Act - do whatever the ComputerPaddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        changeDirection();
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

    private void changeDirection(){
        if(getX() + width/2 >= getWorld().getWidth() || getX() - width/2 <= 0) {
            dx = dx * -1;
        }

    }
}
