package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

public class DoggieCoin extends Item implements Observer{

    /**
     * constructor of doggin coin
     * @param x             SimpleIntegerProperty
     * @param y             SimpleIntegerProperty
     * @param damageValue   damage value
     * @param defenseValue  defense value
     * @param price         price
     */
    public DoggieCoin(SimpleIntegerProperty x, SimpleIntegerProperty y, int damageValue, int defenseValue, int price) {
        super(x, y, damageValue, defenseValue, price);
        setDamageValue(damageValue);
        setDefenseValue(defenseValue);
        setPrice(price);
    }

    /**
     * update doggie coin price
     */
    @Override
    public void updatePrice(int price) {
        setPrice(price);
        System.out.println("The price of DoggieCoin changed!");
        System.out.println("DoggieCoin: " + getPrice() + ".");
    }
    

}
