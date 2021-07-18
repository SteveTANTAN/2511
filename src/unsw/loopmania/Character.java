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
    private List<AlliedSoldier> soldiers;
    private Item weapon;
    private Item armour;
    private Item shield;
    private Item theOneRing;
    private Gold gold;
    private EXP EXP;
    private boolean attackEnhance;

    public Character(PathPosition position) {
        super(position);
        Gold gold = new Gold();
        EXP = new EXP(0);
        setHealth(100);
        setAggressivity(4);
        soldiers = new ArrayList<AlliedSoldier>();
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

    public int getEXP() {
        return EXP.getCurrentEXP();
    }

    
    public Item getArmour() {
        return this.armour;
    }

    public void setArmour(Item armour) {
        this.armour = armour;
    }

    public Item getShield() {
        return this.shield;
    }

    public void setShield(Item shield) {
        this.shield = shield;
    }

    public void setGold(int gold){
        this.gold.setCurrentGold(gold);
    }

    public int getGold(){
        return gold.getCurrentGold();
    }

    public void setEXP(int EXP){
        this.EXP.setCurrentEXP(EXP);
        
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

    public void setWeapon(Item weapon) {
        this.weapon = weapon;
    }

    public Item getTheOneRing() {
        return this.theOneRing;
    }

    public void setTheOneRing(Item ring) {
        this.theOneRing = ring;
    }

}
