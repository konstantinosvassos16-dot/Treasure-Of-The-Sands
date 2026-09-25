import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Clouds here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Clouds extends Mover
{
    public Clouds()
    {
        super(1);
        
        GreenfootImage img = new GreenfootImage("clouds.png");
        img.scale(900, 180);
        setImage(img);
    }
    
    public void act()
    {
        move();
        
        
        int width = getImage().getWidth();

        if (getX() <= -width / 2)
        {
            setLocation(getX() + width * 2, getY());
        }

        if (getX() >= width * 3 / 2)
        {
            setLocation(getX() - width * 2, getY());
        }
    }
}
