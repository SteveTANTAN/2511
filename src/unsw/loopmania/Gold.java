package unsw.loopmania;

/**
 * a basic form of building in the world
 */
public class Gold {
    
    private int CurrentGold;
    public Gold (int i) {
        this.CurrentGold = i;
    }


    public void setCurrentGold(int aim){
        this.CurrentGold = aim;
    } 
    public int getCurrentGold(){
        return this.CurrentGold;
    }
    
}
