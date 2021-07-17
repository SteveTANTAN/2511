package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * a basic form of building in the world
 */
public class BarrackBuilding extends Building {
    // TODO = add more types of building, and make sure buildings have effects on entities as required by the spec
    public BarrackBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }
}
