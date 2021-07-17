package unsw.loopmania;

import java.util.Random;


/**
 * a basic form of enemy in the world
 */
public class BasicEnemy extends MovingEntity {
    //private int healthPoint;
    //private int damageValue;
    //private int supportRadius;
    //private int battleRadius;
    private int goldDefeated;
    private int exp;

    // TODO = modify this, and add additional forms of enemy
    private String name;
    private int aggressivity;
    private int health;
    private int attackRange;
    private int supportRange;
    private int tranceTurn;
    public BasicEnemy(PathPosition position, int aggressivity, int health, int attackRange, int supportRange, String name) {
        super(position);
        this.name = name;
        this.aggressivity = aggressivity;
        this.health = health;
        this.attackRange = attackRange;
        this.supportRange = supportRange;
        this.tranceTurn = 0;
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

    public int getAggressivity() {
        return this.aggressivity;
    }

    public void setAggressivity(int aggressivity) {
        this.aggressivity = aggressivity;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackRange() {
        return this.attackRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public int getSupportRange() {
        return this.supportRange;
    }

    public void setSupportRange(int supportRange) {
        this.supportRange = supportRange;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTranceTurn() {
        return this.tranceTurn;
    }

    public void setTranceTurn(int tranceTurn) {
        this.tranceTurn = tranceTurn;
    }
/*
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
*/
    public void setGoldDefeated(int value){
        goldDefeated = value;
    }

    public void setEXP(int value){
        exp = value;
    }
/*
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
*/
    public int getGoldDefeated(){
        return goldDefeated;
    }

    public int getEXP(){
        return exp;
    }
}
