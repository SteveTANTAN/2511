package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * represents a vampire castle card in the backend game world
 */
public class ZombiePitCard extends Card {
    public ZombiePitCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        String name = "ZOMBIEPIT";
        String description = "Character acquires more resources.";
        super.init(name, description);
    }    
}
