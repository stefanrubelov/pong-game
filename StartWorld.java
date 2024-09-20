import greenfoot.*;  // imports Greenfoot library

public class StartWorld extends World {
    private int timer = 0;
    private String selectedPaddleColor = "Blue";
    //private GreenfootGif PaddleImage = new GreenfootImage("PongBattle.gif");
    public StartWorld() 
    {
        super(400, 600, 1);
        //getBackground().drawImage(PaddleImage, 0, 0);
        addObject(new PongBattle(),getWidth()/2, getHeight()/2);
        /*GreenfootImage background = getBackground(); 
        background.setColor(Color.BLACK);
        background.fill();// Create a blank black background
        setPaintOrder(Title.class,Star.class);
        addObject(new Title(), getWidth()/2, getHeight()/2);*/
    }
    public void act() {
         timer++;
        
        if(timer ==300){
            transitionToPongWorld();
        }
        /* Add a new star at the center periodically
        if (Greenfoot.getRandomNumber(2) < 1) {  // Control star creation speed
            addObject(new Star(), getWidth() / 2, getHeight() / 2);  //Add star at the center
        }*/
        String key = Greenfoot.getKey();
        if (key != null && key.equals("enter"))
        {
            transitionToPongWorld();
        }
        
    }
    private void transitionToPongWorld() {
        Greenfoot.setWorld(new PongWorld(true, selectedPaddleColor));
    }
    
    // Method to update selected paddle color based on user choice
    public void setSelectedPaddleColor(String color) {
        this.selectedPaddleColor = color;
    }

}
