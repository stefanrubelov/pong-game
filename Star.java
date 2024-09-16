import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Star here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Star extends Actor
{
    private int speed;  // Speed of the star's outward movement
    private int transparency;  // Used to fade out the star

    public Star() {
        // Initialize star properties
        speed = Greenfoot.getRandomNumber(36) + 1;  // Random speed (1 to 3)
        transparency = 255;  // Fully visible at the start

        // Set the star image (a small white dot)
        GreenfootImage img = new GreenfootImage(15, 15);
        img.setColor(Color.WHITE);
        img.fillOval(0, 0, 10, 10);
        setImage(img);
    }

    public void act() {
        moveOutward();
        fadeAndRemove();
    }

    private void moveOutward() {
        // Move the star outward by a small random angle
        int angle = Greenfoot.getRandomNumber(360);  // Random direction in degrees
        setRotation(angle);  // Rotate to that direction
        move(speed);  // Move the star
    }

    private void fadeAndRemove() {
        // Gradually reduce transparency (fade out)
        if (transparency > 2) {
            transparency -= Greenfoot.getRandomNumber(2);
            getImage().setTransparency(transparency);
        } else {
            // Remove the star from the world when it becomes fully transparent
            getWorld().removeObject(this);
        }
    }
}
