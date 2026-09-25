import greenfoot.*;

public class Ground extends Mover
{
    public Ground(String imageName)
    {
        super(4);

        GreenfootImage img = new GreenfootImage(imageName);
        setImage(img);
    }
}
