package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * a basic form of building in the world
 */
public class VillageBuilding extends Building {
    private int healAmount = 20;
    // DONE = add more types of building, and make sure buildings have effects on entities as required by the spec
    public VillageBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * use the function of the builidng
     */
    public void work(Character character){
        if(getX() == character.getX() && getY() == character.getY()){
            character.setHealth(character.getHealth()+healAmount);
        }
    }
}
