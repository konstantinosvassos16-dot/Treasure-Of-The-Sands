import greenfoot.*;  

public class AnimatedActor extends Actor
{
    private int frame = 0;   
    private String name = "";       
    private final String extension = ".png";     
    private int speed = 10;         
    private int speedCounter = 0;
    
    protected int deathFrame = 0;
    protected int deathCounter = 0;
    protected int deathDelay = 9;
    
    public void animate(int first, int last)
    {
        if (speedCounter >= speed)
        {
            speedCounter = 0;
            if (frame < first || frame >= last)
            {
                frame = first;
            }
            else
            {
                frame++;
            }
            
            GreenfootImage img = new GreenfootImage(name + frame + extension);
            img.scale(64, 64);  
            setImage(img);
        }
        else
        {
            speedCounter++;
        }
    }
    
    public void changeAnimation(String newName)
    {
        if (!name.equals(newName))
        {
            name = newName;
            frame = 0;
            speedCounter = speed;
        }
    }
    
    public String getAnimationName()
    {
        return this.name;
    }
    
    public int getFrame()
    {
        return this.frame;
    }
        
    public String getExtension()
    {
        return extension;
    }
    
    public void playDeathAnimation(String animationName, String direction, int lastFrame, int width, int height, boolean removeAfterDeath)
    {
        GreenfootImage img = new GreenfootImage(animationName + direction + deathFrame + ".png");
        
        img.scale(width, height);
        setImage(img);
        
        deathCounter++;

        if (deathCounter >= deathDelay)
        {
            deathCounter = 0;
            deathFrame++;
        }
        
        if (deathFrame > lastFrame)
        {
            if (removeAfterDeath)
            {
                getWorld().removeObject(this);
            }
            else
            {
                deathFrame = lastFrame;
            }
        }
    }
}
