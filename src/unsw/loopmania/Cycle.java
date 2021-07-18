package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * a basic form of building in the world
 */
public class Cycle {
    public int CurrentCycle = 0;

    public void setCurrentCycle(int aim){
        CurrentCycle = aim;
    } 
    public int getCurrentCycle(void){
        return CurrentCycle;
    }
}
