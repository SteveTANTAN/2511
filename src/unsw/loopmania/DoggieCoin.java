package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

public class DoggieCoin extends Item{

    public DoggieCoin(SimpleIntegerProperty x, SimpleIntegerProperty y, int damageValue, int defenseValue, int price) {
        super(x, y, damageValue, defenseValue, price);
        setDamageValue(damageValue);
        setDefenseValue(defenseValue);
        setPrice(price);
    }
    
}
