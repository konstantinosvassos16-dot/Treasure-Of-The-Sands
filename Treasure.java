import greenfoot.*;

public class Treasure extends Mover
{
    private boolean opening = false;
    private boolean gameFinished = false;

    private int frame = 0;
    private int counter = 0;
    private int delay = 6;
    private boolean playedLockedSound = false;

    public Treasure()
    {
        super(4);

        GreenfootImage img = new GreenfootImage("treasure0.png");
        img.scale(65, 65);
        setImage(img);
    }

    public void act()
    {
        if (gameFinished)
        {
            finishedMessage();
            return;
        }
        getWorld().showText("", getWorld().getWidth()/2, 120);
        move();
        checkChest();
        animateChest();
    }

    private void checkChest()
    {
        Hero hero = (Hero)getOneIntersectingObject(Hero.class);
        
        if (hero != null && !opening)
        {
            PlatformWorld world = (PlatformWorld)getWorld();
            
            if (world.getScore().getPoints() >= world.getRequiredCoins())
            {
                opening = true;
                world.setChestOpening(true);
                Greenfoot.playSound("treasureOpen.mp3");
            }
            else
            {
                if (!playedLockedSound)
                {
                    Greenfoot.playSound("lockedChest.mp3");
                    playedLockedSound = true;
                }
                
                getWorld().showText("COLLECT ALL COINS FIRST!", getWorld().getWidth()/2, 120);
            }
        }
        else
        {
            playedLockedSound = false;
        }
    }

    public void animateChest()
    {
        if (opening)
        {
            if (counter >= delay)
            {
                counter = 0;

                GreenfootImage img = new GreenfootImage("treasure" + frame + ".png");
                img.scale(80, 80);
                setImage(img);

                frame++;

                if (frame > 6)
                {
                    frame = 6;

                    if (getWorld() instanceof Level1)
                    {
                        getWorld().showText(
                            "LEVEL COMPLETE!",
                            getWorld().getWidth()/2,
                            getWorld().getHeight()/2
                        );

                        Greenfoot.setWorld(new Level2());
                    }
                    else if (getWorld() instanceof Level2)
                    {
                        Greenfoot.playSound("win.wav");
                        gameFinished = true;
                    }
                }
            }
            else
            {
                counter++;
            }
        }
    }
    
    private void finishedMessage()
    {
        getWorld().showText("CONGRATULATIONS! YOU WIN!", getWorld().getWidth()/2, getWorld().getHeight()/2);

        getWorld().showText("PRESS M FOR MAIN MENU", getWorld().getWidth()/2, getWorld().getHeight()/2 + 50);

        if (Greenfoot.isKeyDown("m"))
        {
            Greenfoot.setWorld(new Menu());
        }
    }

}