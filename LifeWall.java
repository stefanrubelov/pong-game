import greenfoot.*;

public class LifeWall extends PowerUp 
{
    private boolean applied = false;

    public LifeWall() {
        GreenfootImage wallImage = new GreenfootImage(25, 20);
        wallImage.setColor(Color.GRAY);
        wallImage.fill();
        setImage(wallImage);
    }

    public void act() {
        moveDown();

        if(!applied){   
            checkForBallCollision();
        }
    }

    public void apply()
    {
        PongWorld world = (PongWorld) getWorld();
        
        setLocation(world.getWidth() / 2, world.getHeight());
        
        GreenfootImage image = getImage();  
        image.scale(world.getWidth(), 25);
        setImage(image);    
    }
}