import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Paddle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Paddle extends Actor
{
    // Method to check if the paddle is intersecting a Balll object
    public boolean checkIntersectionBalll() {
        Balll ball = (Balll) getOneIntersectingObject(Balll.class);
        return ball != null; // Returns true if the ball is intersecting, false otherwise
    }
    public void checkIfAtHorizontalEdge() {
        // Get the actor's position
        int x = getX();
        int y = getY();

        // Get the world size
        int worldWidth = getWorld().getWidth();
        

        // Get the half width and height of the actor for boundary checking
        int halfWidth = getImage().getWidth() / 2;
    
        // Check if the actor is too close to the edges and adjust its position
        if (x - halfWidth < 0) {
            setLocation(halfWidth, y);  // Left edge
        }
        if (x + halfWidth > worldWidth) {
            setLocation(worldWidth - halfWidth, y);  // Right edge
        }
       
    }

}