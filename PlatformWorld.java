import greenfoot.*;  

public abstract class PlatformWorld extends World
{
    private Score score;
    private int life = 3;
    private boolean chestOpening = false;

    private int levelTextCounter = 120;
    
    public PlatformWorld()
    {    
        super(800, 570, 1, false);
        score = new Score();
    }
    
    public Score getScore()
    {
        return score;
    }
    
    public int getLife()
    {
        return life;
    }
    
    public void loseLife()
    {
        life--;
        
        if (life <= 0)
        {
            Greenfoot.playSound("deathsound.mp3");
        }
    }
    
    public int getRequiredCoins()
    {
        return 0;
    }
    
    public abstract void restartLevel();
    
    public boolean isChestOpening()
    {
        return chestOpening;
    }
    
    public void setChestOpening(boolean chestOpening)
    {
        this.chestOpening = chestOpening;
    }

    public void showLevelText(String text)
    {
        if (levelTextCounter > 0)
        {
            showText(text, getWidth()/2, 80);
            levelTextCounter--;
        }
        else
        {
            showText("", getWidth()/2, 80);
        }
    }
}
