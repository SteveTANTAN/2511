package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * represents an equipped or unequipped helmet in the backend world
 */
public class Helmet extends Equipment {
    public Helmet(SimpleIntegerProperty x, SimpleIntegerProperty y, int damageValue, int defenseValue, int price) {
        super(x, y, 0, 1, 20);
    }

}  
