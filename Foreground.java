import greenfoot.*;  

public class Foreground extends Mover
{
    public Foreground(String imageName)
    {
        super(2);

        GreenfootImage img = new GreenfootImage(imageName);

        img.scale(800, 100);

        setImage(img);
    }

    public void act()
    {
        move();

        int width = getImage().getWidth();

        if (getX() <= -width / 2)
        {
            setLocation(getX() + width * 2 - 6, getY());
        }

        if (getX() >= width * 3 / 2)
        {
            setLocation(getX() - width * 2 + 6, getY());
        }
    }
}
