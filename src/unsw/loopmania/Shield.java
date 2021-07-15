package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * represents an equipped or unequipped shield in the backend world
 */
public class Shield extends Equipment {
    public Shield(SimpleIntegerProperty x, SimpleIntegerProperty y, int damageValue, int defenseValue, int price) {
        super(x, y, 0, 1, 20);
    }

}  
