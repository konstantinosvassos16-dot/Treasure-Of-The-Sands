import greenfoot.*;

public class Coin extends Reward
{
    private int frame = 0;
    private int counter = 0;
    private int delay = 5;

    public Coin()
    {
        GreenfootImage img = new GreenfootImage("coin0.png");
        img.scale(32, 32);
        setImage(img);
    }

    public void act()
    {
        move();
        animateCoin();
    }

    private void animateCoin()
    {
        counter++;

        if (counter >= delay)
        {
            counter = 0;
            frame++;

            if (frame > 5)
            {
                frame = 0;
            }

            GreenfootImage img = new GreenfootImage("coin" + frame + ".png");
            img.scale(32, 32);
            setImage(img);
        }
    }
}