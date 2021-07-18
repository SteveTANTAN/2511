package unsw.loopmania;

/**
 * represents the main character in the backend of the game world
 */
public class Character extends MovingEntity {
    // TODO = potentially implement relationships between this class and other classes
    public Character(PathPosition position) {
        super(position);
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

    
}
