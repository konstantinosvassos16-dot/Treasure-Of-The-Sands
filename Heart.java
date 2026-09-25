import greenfoot.*;

public class Heart extends Actor
{
    private int heartNumber;

    public Heart(int number)
    {
        heartNumber = number;

        GreenfootImage img = new GreenfootImage("heartRed.png");
        img.scale(35, 35);
        setImage(img);
    }

    public void act()
    {
        updateHeart();
    }

    private void updateHeart()
    {
        PlatformWorld world = (PlatformWorld)getWorld();

        if (world.getLife() >= heartNumber)
        {
            GreenfootImage img = new GreenfootImage("heartRed.png");
            img.scale(35, 35);
            setImage(img);
        }
        else
        {
            GreenfootImage img = new GreenfootImage("heartBlack.png");
            img.scale(35, 35);
            setImage(img);
        }
    }
}
