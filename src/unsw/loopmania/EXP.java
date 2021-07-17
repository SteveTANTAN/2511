package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * a basic form of building in the world
 */
public class EXP {
    public int CurrentEXP = 0;

    public void setCurrentEXP(int aim){
        CurrentEXP = aim;
    } 
    public int getCurrentEXP(void){
        return this.CurrentEXP;
    }
}
