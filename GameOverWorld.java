import greenfoot.*;

public class GameOverWorld extends World 
{
    private GreenfootImage gameOverImage = new GreenfootImage("game-over.png");
    private static final int GAME_OVER_DELAY = 300;
    private int gameOverCounter = 0;

    public GameOverWorld() 
    {
        super(400, 600, 1);
        GreenfootImage background = getBackground(); 
        background.setColor(Color.BLACK);
        background.fill();
        getBackground().drawImage(gameOverImage, getWidth()/2 - gameOverImage.getWidth()/2, getHeight()/2 - gameOverImage.getHeight()/2);

        GameSound.gameOver();
    }

    public void act() 
    {
        gameOverCounter++;

        if (Greenfoot.isKeyDown("enter")) {
            restartGame();
        }

        if (gameOverCounter >= GAME_OVER_DELAY) {
            restartGame();
        }
    }

    // Method to restart the game
    private void restartGame() {
        Greenfoot.setWorld(new PongWorld(true));
    }
}

