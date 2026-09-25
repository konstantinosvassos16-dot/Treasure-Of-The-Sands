import greenfoot.*;

public class Level2 extends PlatformWorld
{
    private int requiredCoins = 18;

    public Level2()
    {
        super();

        setBackground("sky2.png");

        Sun sun = new Sun();
        addObject(sun, 700, 100);


       //Platform1
        addObject(new Platform("shroomBrownAltLeft.png"), 300, 390);
        addObject(new Platform("shroomBrownAltMid.png"), 364, 390);
        addObject(new Platform("shroomBrownAltMidAlt.png"), 428, 390);
        addObject(new Platform("shroomBrownAltRight.png"), 492, 390);

        //Platform2
        addObject(new Platform("shroomBrownAltSpotsLeft.png"), 620, 350);
        addObject(new Platform("shroomBrownAltSpotsMid.png"), 684, 350);
        addObject(new Platform("shroomBrownAltSpotsMidAlt.png"), 748, 350);
        addObject(new Platform("shroomBrownAltSpotsRight.png"), 812, 350);
        addObject(new Cactus(), 684, 280);
        addObject(new Cactus(), 748, 280);

        // Platform3
        addObject(new Platform("shroomRedAltLeft.png"), 950, 300);
        addObject(new Platform("shroomRedAltMid.png"), 1014, 300);
        addObject(new Platform("shroomRedAltMidAlt.png"), 1078, 300);
        addObject(new Platform("shroomRedAltRight.png"), 1142, 300);
        addObject(new Skeleton(950, 1142, 2), 1014, 235);

        // Platform4
        addObject(new Platform("shroomTanLeft.png"), 1280, 250);
        addObject(new Platform("shroomTanMid.png"), 1344, 250);
        addObject(new Platform("shroomTanRight.png"), 1408, 250);
        addObject(new Cactus(), 1344, 180);
        addObject(new Cactus(), 1408, 180);

        // Platform5
        addObject(new Platform("shroomBrownSpotsLeft.png"), 1540, 200);
        addObject(new Platform("shroomBrownSpotsMid.png"), 1604, 200);
        addObject(new Platform("shroomBrownSpotsMidAlt.png"), 1668, 200);
        addObject(new Platform("shroomBrownSpotsRight.png"), 1732, 200);
        addObject(new Cactus(), 1604, 130);
        addObject(new Cactus(), 1668, 130);

        // Platform6
        addObject(new Platform("shroomRedLeft.png"), 1870, 230);
        addObject(new Platform("shroomRedMid.png"), 1934, 230);
        addObject(new Platform("shroomRedRight.png"), 1998, 230);
        addObject(new Skeleton(1870, 1998, 2), 1934, 165);

        // Platform7
        addObject(new Platform("shroomTanAltLeft.png"), 2130, 290);
        addObject(new Platform("shroomTanAltMid.png"), 2194, 290);
        addObject(new Platform("shroomTanAltRight.png"), 2258, 290);
        addObject(new Cactus(), 2194, 220);

        // Platform8
        addObject(new Platform("shroomBrownAltLeft.png"), 2390, 340);
        addObject(new Platform("shroomBrownAltMid.png"), 2454, 340);
        addObject(new Platform("shroomBrownAltMidAlt.png"), 2518, 340);
        addObject(new Platform("shroomBrownAltRight.png"), 2582, 340);
        addObject(new Cactus(), 2454, 270);
        addObject(new Cactus(), 2518, 270);

        // Platform9
        addObject(new Platform("shroomRedAltLeft.png"), 2720, 390);
        addObject(new Platform("shroomRedAltMid.png"), 2784, 390);
        addObject(new Platform("shroomRedAltRight.png"), 2848, 390);
        addObject(new Skeleton(2720, 2848, 2), 2784, 325);

        // Platform10
        addObject(new Platform("shroomBrownAltLeft.png"), 2980, 420);
        addObject(new Platform("shroomBrownAltMid.png"), 3044, 420);
        addObject(new Platform("shroomBrownAltMidAlt.png"), 3108, 420);
        addObject(new Platform("shroomBrownAltMid.png"), 3172, 420);
        addObject(new Platform("shroomBrownAltRight.png"), 3236, 420);
        addObject(new Cactus(), 3044, 350);
        addObject(new Cactus(), 3108, 350);
        addObject(new Cactus(), 3172, 350);

        // Platform11
        addObject(new Platform("shroomTanLeft.png"), 3370, 380);
        addObject(new Platform("shroomTanMid.png"), 3434, 380);
        addObject(new Platform("shroomTanRight.png"), 3498, 380);
        addObject(new Cactus(), 3434, 310);
        addObject(new Cactus(), 3498, 310);

        // Platform12
        addObject(new Platform("shroomBrownSpotsLeft.png"), 3630, 420);
        addObject(new Platform("shroomBrownSpotsMid.png"), 3694, 420);
        addObject(new Platform("shroomBrownSpotsMidAlt.png"), 3758, 420);
        addObject(new Platform("shroomBrownSpotsMid.png"), 3822, 420);
        addObject(new Platform("shroomBrownSpotsRight.png"), 3886, 420);
        addObject(new Cactus(), 3694, 350);
        addObject(new Cactus(), 3758, 350);
        addObject(new Cactus(), 3822, 350);
        addObject(new Cactus(), 3886, 350);

        addObject(new Platform("shroomTanLeft.png"), 4030, 405);

        addObject(new Platform("shroomTanMid.png"), 4130, 375);

        addObject(new Platform("shroomTanMid.png"), 4230, 345);

        addObject(new Platform("shroomTanRight.png"), 4330, 315);

        // Platform final
        addObject(new Platform("shroomBrownAltLeft.png"), 4480, 385);
        addObject(new Platform("shroomBrownAltMid.png"), 4544, 385);
        addObject(new Platform("shroomBrownAltMidAlt.png"), 4608, 385);
        addObject(new Platform("shroomBrownAltMid.png"), 4672, 385);
        addObject(new Platform("shroomBrownAltRight.png"), 4736, 385);
        addObject(new Treasure(), 4608, 322);
        
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
        showLevelText("LEVEL 2");
    }

    public int getRequiredCoins()
    {
        return requiredCoins;
    }

    public void restartLevel()
    {
        Greenfoot.setWorld(new Level2());
    }
}
