import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

public class PongWorld extends World {
    private int modifierSpawnCounter;
    private int spawnInterval;
    private boolean spawned = false;

    public PongWorld(boolean gameStarted) {
        super(400, 600, 1);

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
        } else {
            Greenfoot.setWorld(new StartWorld());
        }
    }

    private void paintStars(int numberStars) {
        for (int i = 0; i < numberStars; i++) {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(new BackgroundEffect(), x, y);
        }
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
