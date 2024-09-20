import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

public class PongWorld extends World
{
    private String startingPaddleColor;
    private int level = 1;
    private int modifierSpawnCounter;
    private int spawnInterval;
    private boolean spawned = false;
    
    public PongWorld(boolean gameStarted, String paddleColor) 
    {
        super(400, 600, 1);
        this.startingPaddleColor = paddleColor;

        if (gameStarted) {
            GreenfootImage background = getBackground(); 
            background.setColor(Color.BLACK);
            background.fill();

            paintStars(250);
            
            setPaintOrder(Ball.class, Smoke.class);
            addObject(new Ball(), getWidth() / 2, getHeight() / 2);
            addObject(new PlayerPaddle(100, 20), getWidth() / 2, 550);
            addObject(new ComputerPaddle(), 0, 0);

            spawnInterval = Number.getRandom(1000, 2000);
            initializeStartingPaddle();
        
            
            showText("PongCoins: " + PongCoinManager.getPongCoins(), 80, 20);

        } else {
            Greenfoot.setWorld(new StartWorld());
        }
    }

    private void initializeStartingPaddle() {
        Color paddleColor;
        switch (startingPaddleColor) {
            case "Brown":
                paddleColor = new Color(139, 69, 19);
                break;
            case "Silver":
                paddleColor = new Color(192, 192, 192);
                break;
            case "Golden":
                paddleColor = new Color(255, 215, 0);
                break;
            default:
                paddleColor = Color.BLUE; // Default color
        }
        addObject(new PlayerPaddle(paddleColor, 100, 20), getWidth() / 2, getHeight() - 50);
    }
    public void act(){
        showText("PongCoins: " + PongCoinManager.getPongCoins(), 80, 20);
    }
    private void paintStars(int numberStars)
    {
        for(int i=0;i<numberStars;i++)
        {
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());
        addObject (new BackgroundEffect(), x, y);

    }

    public void act() {

        modifierSpawnCounter++;
        if (modifierSpawnCounter >= spawnInterval) {
            if(!spawned){
                spawnModifier();
                spawned = true;
            }
            modifierSpawnCounter = 0;
            spawnInterval = Greenfoot.getRandomNumber(101) + 100;
        }

    }

    private void spawnModifier() {
        Modifier lifeWall = new LifeWall();
        int x = Greenfoot.getRandomNumber(getWidth());
        addObject(lifeWall, x, 0);
    }
}
