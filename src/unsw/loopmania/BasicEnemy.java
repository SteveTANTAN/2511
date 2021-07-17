package unsw.loopmania;

import java.util.Random;


/**
 * a basic form of enemy in the world
 */
public class BasicEnemy extends MovingEntity {
    private int healthPoint;
    private int damageValue;
    private int supportRadius;
    private int battleRadius;
    private int goldDefeated;
    private int exp;

    // TODO = modify this, and add additional forms of enemy
    public BasicEnemy(PathPosition position) {
        super(position);
    }

    /**
     * move the enemy
     */
    public void move(){
        // TODO = modify this, since this implementation doesn't provide the expected enemy behaviour
        // this basic enemy moves in a random direction... 25% chance up or down, 50% chance not at all...
        int directionChoice = (new Random()).nextInt(2);
        if (directionChoice == 0){
            moveUpPath();
        }
        else if (directionChoice == 1){
            moveDownPath();
        }
    }

    public void setHealthPoint(int value){
        healthPoint = value;
    }


    public void setDamageValue(int value){
        damageValue = value;
    }

    public void setSupportRadius(int value){
        supportRadius = value;
    }

    public void setBattleRadius(int value){
        battleRadius = value;
    }

    public void setGoldDefeated(int value){
        goldDefeated = value;
    }

    public void setEXP(int value){
        exp = value;
    }

    public int getHealthPoint(){
        return healthPoint;
    }

    public int getDamageValue(){
        return damageValue;
    }

    public int getSupportRadius(){
        return supportRadius;
    }

    public int getBattleRadius(){
        return battleRadius;
    }

    public int getGoldDefeated(){
        return goldDefeated;
    }

    public int getEXP(){
        return exp;
    }
}
