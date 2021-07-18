package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * a basic form of building in the world
 */
public class Gold {
    
    public int CurrentGold = 0;

    public void setCurrentGold(int aim){
        CurrentGold = aim;
    } 
    public int getCurrentGold(void){
        return this.CurrentGold;
    }
    
}
