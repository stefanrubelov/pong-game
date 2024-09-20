import greenfoot.*;

public class GameOverWorld extends World 
{
    //private GreenfootImage gameOverImage = new GreenfootImage("Game-Over.png");
    private static final int GAME_OVER_DELAY = 900;
    private int gameOverCounter = 0;

    public GameOverWorld() 
    {
        super(400, 600, 1);
        //getBackground().drawImage(gameOverImage, getWidth()/2 - gameOverImage.getWidth()/2, getHeight()/2 - gameOverImage.getHeight()/2);
        addObject(new GameOverTitle(),getWidth()/2, getHeight()/2);
        addObject(new BuyPaddleButton(), 300, 500);
        GameSound.gameOver();
    }

    public void act() 
    {
        gameOverCounter++;
        showText("PongCoins: " + PongCoinManager.getPongCoins(), 80, 20);
        if (Greenfoot.isKeyDown("enter")) {
            restartGame();
        }

        if (gameOverCounter >= GAME_OVER_DELAY) {
            restartGame();
        }
    }

    // Method to restart the game
    private void restartGame() {
        String defaultPaddleColor = "Blue";
        Greenfoot.setWorld(new PongWorld(true, defaultPaddleColor));
    }
}

