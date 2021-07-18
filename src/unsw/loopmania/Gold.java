package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * a basic form of building in the world
 */
public class Gold {
    
    private int CurrentGold = 0;


    public void setCurrentGold(int aim){
        this.CurrentGold = aim;
    } 
    public int getCurrentGold(){
        return this.CurrentGold;
    }
    
}
