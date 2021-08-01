package unsw.loopmania;

import org.json.JSONArray;
import org.json.JSONObject;
public class OrGoal extends Goal{
    public JSONArray goals;

    public OrGoal(JSONObject condition) {
        super(condition);
        this.goals = conditions.getJSONArray("subgoals");
        //TODO Auto-generated constructor stub
    }

    public boolean subgoalcheck() {
        Goal goal1 = new Goal(goals.getJSONObject(0));
        Goal goal2 = new Goal(goals.getJSONObject(1));
        goal1.setCurrentStatus(gold.getGoal(), exp.getGoal(), turns.getGoal(), bosses.getGoal());
        goal2.setCurrentStatus(gold.getGoal(), exp.getGoal(), turns.getGoal(), bosses.getGoal());


        return goal1.goalCheck() || goal2.goalCheck();
    }

}