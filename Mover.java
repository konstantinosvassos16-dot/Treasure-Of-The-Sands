import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Mover extends Actor
{
    private int speed = 7;
    
    public Mover()
    {
        speed = 7;
    }

    public Mover(int anySpeed)    
    {        
         speed = anySpeed;    
    }
    
    public void move()     
    {
        Hero hero = (Hero)getWorld().getObjects(Hero.class).get(0);
        if (hero.isDead())
        {
            return;
        }
        
        PlatformWorld world = (PlatformWorld)getWorld();
        if (world.isChestOpening())
        {
            return;
        }
        checkKeys();    
    } 
    
    private void checkKeys()    
    {        
        if (Greenfoot.isKeyDown("right"))        
        {            
            setLocation(getX() - speed, getY());                   
        }   
        
        if (Greenfoot.isKeyDown("left"))        
        {            
            setLocation(getX() + speed, getY());       
        }    
    }
}
