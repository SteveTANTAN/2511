package unsw.loopmania;


import org.json.JSONObject;

public class BossGoal {
    public boolean check;
    public void setGoal(boolean a){
        this.check = a;
    }
    public boolean getGoal(){
        return this.check;
    }
}