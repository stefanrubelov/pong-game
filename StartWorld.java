import greenfoot.*;  // imports Greenfoot library

public class StartWorld extends World {
    private int timer = 0;
    public StartWorld() 
    {
        super(400, 600, 1);  // Set world size (600x400 pixels)
        GreenfootImage background = getBackground(); 
        background.setColor(Color.BLACK);
        background.fill();// Create a blank black background
    }
    public void act() {
         timer++;
        
        if(timer ==300){
            Greenfoot.setWorld(new PongWorld(true));
        }
        // Add a new star at the center periodically
        if (Greenfoot.getRandomNumber(2) < 1) {  // Control star creation speed
            addObject(new Star(), getWidth() / 2, getHeight() / 2);  // Add star at the center
        }
        String key = Greenfoot.getKey();
        if (key != null && key.equals("enter"))
        {
            Greenfoot.setWorld(new PongWorld(true));
        }
        
    }
}
