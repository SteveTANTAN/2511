package unsw.loopmania;

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
    public Character(PathPosition position) {
        super(position);
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAggressivity() {
        return this.aggressivity;
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
    
    public void addSoldier(AlliedSoldier s) {
        soldiers.add(s);
    }

    public List<AlliedSoldier> getSoldiers() {
        return soldiers;
    }

    public Item getWeapon() {
        return this.weapon;
    }

    public void setWeapon(Equipment weapon) {
        this.weapon = weapon;
    }

}