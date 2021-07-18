package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * represents an equipped or unequipped armour in the backend world
 */
public class Item extends StaticEntity {
    private int damageValue;
    private int defenseValue;
    private int price;

    public Item (SimpleIntegerProperty x, SimpleIntegerProperty y, int damageValue, int defenseValue, int price) {
        super(x, y);
        this.damageValue = damageValue;
        this.defenseValue = defenseValue;
        this.price = price;
    } 

    public int getDamageValue() {
        return this.damageValue;
    }

    public void setDamageValue(int damageValue) {
        this.damageValue = damageValue;
    }

    public int getDefenseValue() {
        return this.defenseValue;
    }

    public void setDefenseValue(int defenseValue) {
        this.defenseValue = defenseValue;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
