import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Smoke extends Actor
{
    private GreenfootImage image;
    private int fade;
    public Smoke (){
        GreenfootImage img = getImage();
        img.setTransparency(200);
        setImage(img);
        image = getImage();
        fade = Greenfoot.getRandomNumber (4)+1;
        if(fade==4){
            fade=2;
        }
    }
    
    public void act()
    {
        shrink();
    }
    private void shrink(){
        if( getImage().getWidth()<10){
            getWorld().removeObject(this);
        }
        else{
        GreenfootImage img = new GreenfootImage ( image);
        img.scale(getImage().getWidth()-fade, getImage().getHeight()-fade);
        img.setTransparency (getImage().getTransparency() - (fade*5));
        setImage(img);
        }
    }
}
