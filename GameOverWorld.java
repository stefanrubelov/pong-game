import greenfoot.*;

public class GameOverWorld extends World {
    private GreenfootImage gameOverImage = new GreenfootImage("game-over.png"); // Your game over image
    private static final int GAME_OVER_DELAY = 300; // Delay before automatic restart (in act cycles)
    private int gameOverCounter = 0;

    public GameOverWorld() {
        super(600, 400, 1); // Set the dimensions of your game over screen

        // Set the background to the game-over image
        getBackground().drawImage(gameOverImage, getWidth()/2 - gameOverImage.getWidth()/2, getHeight()/2 - gameOverImage.getHeight()/2);

        // Play the game-over sound
        Greenfoot.playSound("game-over-sound.mp3"); // Add your game-over sound file here
    }

    public void act() {
        gameOverCounter++;

        // Restart the game if "enter" is pressed
        if (Greenfoot.isKeyDown("enter")) {
            restartGame();
        }

        // Automatically restart after a certain delay if no key press is detected
        if (gameOverCounter >= GAME_OVER_DELAY) {
            restartGame();
        }
    }

    // Method to restart the game
    private void restartGame() {
        Greenfoot.setWorld(new PongWorld(true));
    }
}

