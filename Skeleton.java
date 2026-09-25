import greenfoot.*;

public class Skeleton extends AnimatedActor
{
    private String direction = "L";
    private int speed = 1;
    private int worldSpeed = 4;
    private int leftLimit;
    private int rightLimit;
    
    private int health;
    private boolean dead = false;
    
    public Skeleton(int left, int right, int enemyHealth)
    {
        leftLimit = left;
        rightLimit = right;
        health = enemyHealth;

        GreenfootImage img = new GreenfootImage("skeletonIdleL0.png");
        img.scale(64, 64);
        setImage(img);
    }

    public void act()
    {
        enemyMovingWithWorld();
        
        if (dead)
        {
            
            playDeathAnimation("die", direction, 7, 80, 80, true);
            return;
        }

        enemyMovement();
    }

    private void enemyMovingWithWorld()
    {
        Hero hero = (Hero)getWorld().getObjects(Hero.class).get(0);
        if (hero.isDead())
        {
            return;
        }

        if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() - worldSpeed, getY());

            leftLimit -= worldSpeed;
            rightLimit -= worldSpeed;
        }

        if (Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() + worldSpeed, getY());

            leftLimit += worldSpeed;
            rightLimit += worldSpeed;
        }
    }

    private void enemyMovement()
    {
        if (direction.equals("L"))
        {
            if (getX() - speed <= leftLimit)
            {
                setLocation(leftLimit, getY());
                direction = "R";
            }
            else
            {
                setLocation(getX() - speed, getY());
            }

            if (!getAnimationName().equals("skeletonRunL"))
            {
                changeAnimation("skeletonRunL");
            }

            animate(0, 7);
        }
        else
        {
            if (getX() + speed >= rightLimit)
            {
                setLocation(rightLimit, getY());
                direction = "L";
            }
            else
            {
                setLocation(getX() + speed, getY());
            }

            if (!getAnimationName().equals("skeletonRunR"))
            {
                changeAnimation("skeletonRunR");
            }

            animate(0, 7);
        }
    }
    
    public void skeletonDeath()
    {
        health--;
        if (health <= 0)
        {
            Greenfoot.playSound("skeletonDeath.mp3");
            dead = true;
            
            deathFrame = 0;
            deathCounter = 0;
            setLocation(getX(), getY() - 10);
        }
    }
    
    public boolean isDead()
    {
        return dead;
    }
}
