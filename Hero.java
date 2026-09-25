import greenfoot.*;  

public class Hero extends AnimatedActor
{
    private int vSpeed = 0;
    private int acceleration = 1;
    private final int jumpHeight = -13;
    private boolean spacePressed = false;
    
    private boolean attacking = false;
    private boolean attackPressed = false;
    private int attackFrame = 0;
    private int attackCounter = 0;
    private int attackDelay = 4;
    private String direction = "R";
    
    private boolean dead = false;
    private boolean hasHitObject = false;
    private int damageCooldown = 0;
    
    private boolean gameOver = false;

    public Hero()
    {
        GreenfootImage img = new GreenfootImage("heroIdle0R.png");
        img.scale(64, 64);
        setImage(img);
    }

    public void act()
    {
        if (gameOver)
        {
            getWorld().showText("GAME OVER - PRESS R TO RESTART", getWorld().getWidth()/2, getWorld().getHeight()/2);
            
            if (Greenfoot.isKeyDown("r"))
            {
                PlatformWorld world = (PlatformWorld)getWorld();
                world.restartLevel();
            }
            return;
        }
        
        if (dead)
        {
            playDeathAnimation("deadHero", direction, 8, 64, 64, false);
            if (deathFrame >= 8)
            {
                gameOver = true;
            }
            return;
        }
        
        checkKeys();
        attack();
        checkFalling();
        collectCoin();
        checkEnemyCollision();
        checkFallDeath();
    }

    private void checkKeys()
    {
        if (gameOver || dead)
        {
            return;
        }
        
        if (!onGround())
        {
            GreenfootImage img;

            if (vSpeed < 0)
            {
                if (direction.equals("L"))
                {
                    img = new GreenfootImage("heroJumpUpLeft.png");
                }
                else
                {
                    img = new GreenfootImage("heroJumpUpRight.png");
                }
            }
            else
            {
                if (direction.equals("L"))
                {
                    img = new GreenfootImage("heroJumpFallLeft.png");
                }
                else
                {
                    img = new GreenfootImage("heroJumpFallRight.png");
                }
            }

            img.scale(64, 64);
            setImage(img);
            return;
        }

        if (Greenfoot.isKeyDown("right"))
        {
            direction = "R";

            if (!getAnimationName().equals("heroRunR"))
            {
                changeAnimation("heroRunR");
            }

            animate(0, 9);
        }
        else if (Greenfoot.isKeyDown("left"))
        {
            direction = "L";

            if (!getAnimationName().equals("heroRunL"))
            {
                changeAnimation("heroRunL");
            }

            animate(0, 9);
        }
        else
        {
            GreenfootImage img;

            if (direction.equals("L"))
            {
                img = new GreenfootImage("heroIdle0L.png");
            }
            else
            {
                img = new GreenfootImage("heroIdle0R.png");
            }

            img.scale(64, 64);
            setImage(img);
        }

        if (Greenfoot.isKeyDown("space") && onGround() && !spacePressed)
        {
            vSpeed = jumpHeight;
            fall();
            spacePressed = true;
        }

        if (!Greenfoot.isKeyDown("space"))
        {
            spacePressed = false;
        }
    }

    private void fall()
    {
        setLocation(getX(), getY() + vSpeed);
        vSpeed = vSpeed + acceleration;
    }

    private boolean onGround()
    {
        Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2, Ground.class);
        return under != null;
    }

    private void checkFalling()
    {
        if (!onGround())
        {
            fall();
        }
        else
        {
            moveToGround();
            vSpeed = 0;
        }
    }

    private void moveToGround()
    {
        Actor ground = getOneObjectAtOffset(0, getImage().getHeight()/2, Ground.class);

        if (ground != null)
        {
            int newY = ground.getY() - ground.getImage().getHeight()/2 - getImage().getHeight()/2 + 9;
            setLocation(getX(), newY);
        }
    }

    private void attack()
    {
        if (Greenfoot.isKeyDown("f") && !attackPressed && !attacking)
        {
            Greenfoot.playSound("attack.mp3");
            attacking = true;
            attackPressed = true;

            attackFrame = 0;
            attackCounter = 0;
        }

        if (!Greenfoot.isKeyDown("f"))
        {
            attackPressed = false;
        }

        if (attacking)
        {
            GreenfootImage img = new GreenfootImage("heroSlash" + direction + attackFrame + ".png");
            img.scale(64, 64);
            setImage(img);
            
            hitObject();

            attackCounter++;

            if (attackCounter >= attackDelay)
            {
                attackCounter = 0;
                attackFrame++;
            }

            if (attackFrame > 7)
            {
                attacking = false;
                attackFrame = 0;
                hasHitObject = false;
            }
        }
    }
    
    private void hitObject()
    {
        int range = 28;

        if (direction.equals("L"))
        {
            range = -range;
        }

        Cactus cactus = (Cactus)getOneObjectAtOffset(range, 0, Cactus.class);

        if (cactus != null && !hasHitObject)
        {
            cactus.takeDamage();
            hasHitObject = true;
        }

        Skeleton skeleton = (Skeleton)getOneObjectAtOffset(range, 0, Skeleton.class);

        if (skeleton != null && !hasHitObject)
        {
            skeleton.skeletonDeath();
            hasHitObject = true;
        }
    }
    
    private void collectCoin()
    {
        Coin coin = (Coin)getOneIntersectingObject(Coin.class);

        if (coin != null)
        {
            Greenfoot.playSound("collectCoins.mp3");

            PlatformWorld world = (PlatformWorld)getWorld();
            world.getScore().addScore(1);

            getWorld().removeObject(coin);
        }
    }
    
    private void checkEnemyCollision()
    {
        if (damageCooldown > 0)
        {
            damageCooldown--;
        }

        Skeleton skeleton;

        if (direction.equals("R"))
        {
            skeleton = (Skeleton)getOneObjectAtOffset(5, -10, Skeleton.class);
        }
        else
        {
            skeleton = (Skeleton)getOneObjectAtOffset(-5, -10, Skeleton.class);
        }
        
        if (skeleton != null && damageCooldown == 0 && !skeleton.isDead() && !attacking)
        {
            PlatformWorld world = (PlatformWorld)getWorld();
            
            if (world.getLife() > 1)
            {    
                Greenfoot.playSound("hurt.mp3");
                world.loseLife();
                damageCooldown = 170;
            }
            else
            {
                world.loseLife();
                dead = true;
                deathFrame = 0;
                deathCounter = 0;
            }
        }
    }
    
    private void checkFallDeath()
    {
        if (getY() > 500)
        {
            Greenfoot.playSound("fallingScream.mp3");

            getWorld().showText("GAME OVER", getWorld().getWidth()/2, getWorld().getHeight()/2);
            dead = true;
            gameOver = true;
        }
    }
    
    public boolean isDead()
    {
        return dead;
    }
}