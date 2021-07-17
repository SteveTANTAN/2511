package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * represents a vampire castle card in the backend game world
 */
public class TrapCard extends Card {
    public TrapCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        String name = "TRAP";
        String description = "If the enemies would be damaged if they touch those instruments.";
        super.init(name, description);
    }    
}
