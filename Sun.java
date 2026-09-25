import greenfoot.*;

public class Sun extends Mover
{
    private int counter = 0;
    
    public Sun()
    {
        super(1);

        GreenfootImage img = new GreenfootImage("sun.png");
        img.scale(140, 140);
        setImage(img);
    }

     public void act()
    {
        counter++;

        if (counter >= 4)
        {
            move();
            counter = 0;
        }
    }
}