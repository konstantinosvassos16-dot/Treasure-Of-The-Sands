import greenfoot.*;
import greenfoot.*;
import greenfoot.Color;

public class Menu extends World
{
    private int counter = 0;
    private boolean visible = true;
    private static GreenfootSound music = new GreenfootSound("backgroundMusic.mp3");
    
    public Menu()
    {    
        super(800, 570, 1);

        music.setVolume(23);
        music.playLoop();
        GreenfootImage bg = new GreenfootImage("backgroundMenu.png");
        bg.scale(800, 570);
        setBackground(bg);

        showText("TREASURE OF THE SANDS", 400, 130);

        showText("MOVE: LEFT / RIGHT", 400, 240);
        showText("JUMP: SPACE", 400, 280);
        showText("ATTACK: F", 400, 320);

        showText("SLASH CACTUS TO COLLECT COINS!", 400, 390);
        showText("PRESS ENTER TO PLAY", 400, 500);
    }

    public void act()
    {
        counter++;
        
        if (counter >= 35)
        {
            counter = 0;
            
            visible = !visible;
            
            if (visible)
            {
                showText("PRESS ENTER TO PLAY", 400, 500);
            }
            else
            {
                showText("", 400, 500);
            }
        }
        
        if (Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new Level1());
        }
    }
}
