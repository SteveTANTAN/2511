package unsw.loopmania;

import java.util.ArrayList;
import java.util.List;

/**
 * represents the main character in the backend of the game world
 */
public class Character extends MovingEntity {
    // TODO = potentially implement relationships between this class and other classes
    private int health;
    private int aggressivity;
    private int defense;
    private int gold;
    private int EXP;
    private boolean attackEnhance;
    private List<AlliedSoldier> soldiers;
    private Item weapon;

    public Character(PathPosition position) {
        super(position);
        setHealth(100);
        setAggressivity(4);
        setEXP(1000);
        soldiers = new ArrayList<>();
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = Math.min(health, 100);
    }

    public int getAggressivity() {
        if(attackEnhance){
            return 2 * aggressivity;
        }
        return aggressivity;
    }

    public void setAggressivity(int aggressivity) {
        this.aggressivity = aggressivity;
    }

    public int getDefense() {
        return this.defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
    private int gold;
    private int EXP;
    public int getEXP() {
        return EXP;
    }
    public void setEXP(int eXP) {
        EXP = eXP;
    }
    public int getGold() {
        return gold;
    }
    public void setGold(int gold) {
        this.gold = gold;
    }

    
    public void setGold(int gold){
        this.gold = gold;
    }

    public int getGold(){
        return gold;
    }

    public void setEXP(int EXP){
        this.EXP = Math.min(EXP, 1000);
    }

    public int getEXP(){
        return EXP;
    }

    public void setAttackEnhance(Boolean enhance){
        attackEnhance = enhance;
    }

    public boolean isAttackEnhance(){
        return attackEnhance;
    }

    public void addSoldier(AlliedSoldier s) {
        soldiers.add(s);
    }

    public List<AlliedSoldier> getSoldiers() {
        return soldiers;
    }

    public Item getWeapon() {
        return this.weapon;
    }

    // public void setWeapon(Equipment weapon) {
    //     this.weapon = weapon;
    // }

}