package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

public class AlliedSoldier extends StaticEntity{
    private int aggressivity;
    private int health;
    public AlliedSoldier(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.aggressivity = 5;
        this.health = 15;
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

}
