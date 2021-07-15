package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * represents a vampire castle card in the backend game world
 */
public class VampireCastleCard extends Card {
    public VampireCastleCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        String name = "VAMPIRECASTLE";
        String description = "Character acquires more resources.";
        super.init(name, description);
    }    
}
