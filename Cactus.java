import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cactus extends Mover
{
    private int health = 2;
    
    public Cactus()
    {
        super(4);

        GreenfootImage img = new GreenfootImage("cactus.png");
        img.scale(65, 100);

        setImage(img);
    }

    public void act()
    {
        move();
    }
    
    public void takeDamage()
    {
        health--;
        
        if (health <= 0)
        {
            Greenfoot.playSound("breakCactus.mp3");
            getWorld().addObject(new Coin(), getX(), getY() - 40);
            getWorld().removeObject(this);
        }
    }
}
