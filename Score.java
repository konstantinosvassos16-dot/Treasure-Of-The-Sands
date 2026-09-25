import greenfoot.*;
import greenfoot.Color;

public class Score extends Actor
{
    private int points = 0;

    public Score()
    {
        updateScore();
    }

    public void act()
    {
        updateScore();
    }

    public void addScore(int newPoints)
    {
        points += newPoints;
        updateScore();
    }

    public int getPoints()
    {
        return points;
    }

    private void updateScore()
    {
        GreenfootImage scoreImage = new GreenfootImage(180, 70);
        
        GreenfootImage coin = new GreenfootImage("coin0.png");
        coin.scale(48, 48);
        
        scoreImage.drawImage(coin, 0, 10);

        GreenfootImage text = new GreenfootImage("x " + points, 38, Color.WHITE, new Color(0,0,0,0));
        
        scoreImage.drawImage(text, 60, 12);
        setImage(scoreImage);
    }
}