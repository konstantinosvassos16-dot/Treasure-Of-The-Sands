import greenfoot.*;

public class Platform extends Ground
{
    public Platform(String imageName)
    {
        super(imageName);
    }
    
    public void act()
    {
        move();
    }
}
