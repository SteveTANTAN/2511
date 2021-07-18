package unsw.loopmania;

/**
 * a basic form of building in the world
 */
public class EXP {
    public int CurrentEXP;
    public EXP(int i) {
        this.CurrentEXP = i;

    }

    public void setCurrentEXP(int aim){
        CurrentEXP = Math.min(aim, 1000);
    } 
    public int getCurrentEXP(){
        return this.CurrentEXP;
    }
}
