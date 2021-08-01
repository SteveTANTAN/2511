package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

public class Anduril extends Item {
    /**
     * constructor of anduril
     * @param x             SimpleIntegerProperty
     * @param y             SimpleIntegerProperty
     * @param damageValue   damage value
     * @param defenseValue  defense value
     * @param price         price
     */
    public Anduril(SimpleIntegerProperty x, SimpleIntegerProperty y, int damageValue, int defenseValue, int price) {
        super(x, y, damageValue, defenseValue, price);
        setDamageValue(damageValue);
        setDefenseValue(defenseValue);
        setPrice(price);
    }
    
}
