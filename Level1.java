import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level1 extends PlatformWorld
{
    private int requiredCoins = 12;
   
    public Level1()
    {
        super();

        setBackground("sky1.png");
        
        Clouds clouds1 = new Clouds();
        addObject(clouds1, 450, 100);

        Clouds clouds2 = new Clouds();
        addObject(clouds2, 1350, 100);
        
        // Platform 1
        addObject(new Platform("shroomBrownAltLeft.png"), 300, 390);
        addObject(new Platform("shroomBrownAltMid.png"), 364, 390);
        addObject(new Platform("shroomBrownAltMidAlt.png"), 428, 390);
        addObject(new Platform("shroomBrownAltRight.png"), 492, 390);
        addObject(new Cactus(), 748, 350);

        // Platform 2
        addObject(new Platform("shroomBrownAltSpotsLeft.png"), 620, 420);
        addObject(new Platform("shroomBrownAltSpotsMid.png"), 684, 420);
        addObject(new Platform("shroomBrownAltSpotsMidAlt.png"), 748, 420);
        addObject(new Platform("shroomBrownAltSpotsRight.png"), 812, 420);

        // Platform 3
        addObject(new Platform("shroomRedAltLeft.png"), 950, 380);
        addObject(new Platform("shroomRedAltMid.png"), 1014, 380);
        addObject(new Platform("shroomRedAltMidAlt.png"), 1078, 380);
        addObject(new Platform("shroomRedAltRight.png"), 1142, 380);

        // Platform 4
        addObject(new Platform("shroomTanLeft.png"), 1280, 350);
        addObject(new Platform("shroomTanMid.png"), 1344, 350);
        addObject(new Platform("shroomTanRight.png"), 1408, 350);
        addObject(new Cactus(), 1344, 280);

        // Platform 5
        addObject(new Platform("shroomBrownSpotsLeft.png"), 1540, 400);
        addObject(new Platform("shroomBrownSpotsMid.png"), 1604, 400);
        addObject(new Platform("shroomBrownSpotsMidAlt.png"), 1668, 400);
        addObject(new Platform("shroomBrownSpotsRight.png"), 1732, 400);
        addObject(new Cactus(), 1604, 330);
        addObject(new Cactus(), 1668, 330);
        
        // Platform 6
        addObject(new Platform("shroomRedLeft.png"), 1870, 370);
        addObject(new Platform("shroomRedMid.png"), 1934, 370);
        addObject(new Platform("shroomRedRight.png"), 1998, 370);

        // Platform 7
        addObject(new Platform("shroomTanAltLeft.png"), 2130, 420);
        addObject(new Platform("shroomTanAltMid.png"), 2194, 420);
        addObject(new Platform("shroomTanAltRight.png"), 2258, 420);
        addObject(new Cactus(), 2194, 350);

        // Platform 8
        addObject(new Platform("shroomBrownAltLeft.png"), 2390, 380);
        addObject(new Platform("shroomBrownAltMid.png"), 2454, 380);
        addObject(new Platform("shroomBrownAltMidAlt.png"), 2518, 380);
        addObject(new Platform("shroomBrownAltRight.png"), 2582, 380);
        addObject(new Cactus(), 2454, 310);
        addObject(new Cactus(), 2518, 310);

        // Platform 9
        addObject(new Platform("shroomRedAltLeft.png"), 2720, 350);
        addObject(new Platform("shroomRedAltMid.png"), 2784, 350);
        addObject(new Platform("shroomRedAltRight.png"), 2848, 350);
        addObject(new Skeleton(2720, 2848, 2), 2784, 285);

        // Platform 10
        addObject(new Platform("shroomBrownAltLeft.png"), 2980, 410);
        addObject(new Platform("shroomBrownAltMid.png"), 3044, 410);
        addObject(new Platform("shroomBrownAltMidAlt.png"), 3108, 410);
        addObject(new Platform("shroomBrownAltMid.png"), 3172, 410);
        addObject(new Platform("shroomBrownAltRight.png"), 3236, 410);
        addObject(new Cactus(), 3108, 340);

        // Platform 11
        addObject(new Platform("shroomTanLeft.png"), 3370, 375);
        addObject(new Platform("shroomTanMid.png"), 3434, 375);
        addObject(new Platform("shroomTanRight.png"), 3498, 375);
        addObject(new Cactus(), 3434, 305);
        addObject(new Cactus(), 3504, 305);
        
        // Platform 12
        addObject(new Platform("shroomBrownSpotsLeft.png"), 3630, 420);
        addObject(new Platform("shroomBrownSpotsMid.png"), 3694, 420);
        addObject(new Platform("shroomBrownSpotsMidAlt.png"), 3758, 420);
        addObject(new Platform("shroomBrownSpotsRight.png"), 3822, 420);
        addObject(new Cactus(), 3694, 350);
        addObject(new Cactus(), 3758, 350);

        // Platform 13 - final 
        addObject(new Platform("shroomBrownAltLeft.png"), 3960, 385);
        addObject(new Platform("shroomBrownAltMid.png"), 4024, 385);
        addObject(new Platform("shroomBrownAltMidAlt.png"), 4088, 385);
        addObject(new Platform("shroomBrownAltMid.png"), 4152, 385);
        addObject(new Platform("shroomBrownAltRight.png"), 4216, 385);
        addObject(new Treasure(), 4088, 322);

        addObject(new Hero(), 400, 300);
      
        addObject(new Foreground("foreground.png"), 400, 525);
        addObject(new Foreground("foreground.png"), 1200, 525);
        
        addObject(getScore(), 105, 45);
        
        addObject(new Heart(1), 650, 45);
        addObject(new Heart(2), 700, 45);
        addObject(new Heart(3), 750, 45);
    }
    
    public void act()
    {
        showLevelText("LEVEL 1");
    }
    
    public int getRequiredCoins()
    {
        return requiredCoins;
    }
    
    public void restartLevel()
    {
        Greenfoot.setWorld(new Level1());
    }
}
