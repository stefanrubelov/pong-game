import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PaddleOption extends Actor
{
    private int price;
    private String paddleName;
    private String paddleColor;
    
    public PaddleOption(int price, String paddleName, String paddleColor){
        this.price = price;
        this.paddleName = paddleName;
        this.paddleColor = paddleColor;
        setImage(new GreenfootImage(paddleName + " - " + price + " coins", 20, Color.WHITE, Color.BLACK));
    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            if (PongCoinManager.getPongCoins() >= price) {
                PongCoinManager.useCoins(price);
                Greenfoot.setWorld(new PongWorld(true, paddleColor)); // Start a new game with the new paddle
                // You can also add code to switch paddle here
            }
        }
    }
}
