package unsw.loopmania;

import java.util.ArrayList;

import org.json.JSONObject;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.CheckBox;

public class Goal {

    public JSONObject conditions;
    public Goal(JSONObject condition){
        this.conditions = condition;
    }

    /**
     * checking if it meets the specifct condition
     * 
     * @param  String type, int quantity, int gold, int exp, int turns
     * @return Boolean
     */
    public boolean goalCheckHelp (String type, int quantity, int gold, int exp, int turns) {
        switch (type) {
            case "gold" :
                return gold >= quantity;
            case "experience" :
                return exp >= quantity;
            case "cycles" :
                return turns >= quantity;
            default:
                break;
        }
        return false;
    }
    /**
     * checking if it meets the specifct condition for more conflicts version
     * 
     * @param  int gold, int exp, int turns
     * @return Boolean
     */
    public boolean goalCheck(int gold, int exp, int turns) {
        if (conditions == null) {
            return false;

        }

        //System.out.printf(conditions.toString(4));
        // if it's the only one level goal
        if (!conditions.has("subgoals")) {
            // System.out.printf(conditions.getString("quantity"));
            
            return goalCheckHelp(conditions.getString("goal"), conditions.getInt("quantity"), gold, exp, turns);
        } else{
            // otherwise at least level2
            String rela = conditions.getString("goal");

            boolean is_foound = false;
            String rela2 = null;
            String subgoal1 = null;
            int quantity1 = 0;
            int quantity2 = 0;
            String subgoal2= null;
            // check if it has OR/AND goal in the 2nd level
            for (int i = 0; i <2; i++){
                JSONObject goalcondi = conditions.getJSONArray("subgoals").getJSONObject(i);
                if (goalcondi.has("subgoals")) {
                    is_foound = true;
                    rela2 = goalcondi.getString("goal");
                    subgoal1 = goalcondi.getJSONArray("subgoals").getJSONObject(0).getString("goal");
                    subgoal2 = goalcondi.getJSONArray("subgoals").getJSONObject(1).getString("goal");
                    quantity1 = goalcondi.getJSONArray("subgoals").getJSONObject(0).getInt("quantity");
                    quantity2 = goalcondi.getJSONArray("subgoals").getJSONObject(1).getInt("quantity");
                    break;
                }
            }
            // if it doesn't have just doing the normal level2 goals
            if (!is_foound) {
                String goal1 = conditions.getJSONArray("subgoals").getJSONObject(0).getString("goal");
                String goal2 = conditions.getJSONArray("subgoals").getJSONObject(1).getString("goal");
                int q1 = conditions.getJSONArray("subgoals").getJSONObject(0).getInt("quantity");
                int q2 = conditions.getJSONArray("subgoals").getJSONObject(1).getInt("quantity");
                if (rela.equals("AND")) {
                    return goalCheckHelp(goal1, q1, gold, exp, turns)
                    && goalCheckHelp(goal2, q2, gold, exp, turns);
                }
                if (rela.equals("OR")) {
                    return goalCheckHelp(goal1, q1, gold, exp, turns)
                    || goalCheckHelp(goal2, q2, gold, exp, turns);
                }
            // otherwise doing conflict version
            } else if (is_foound) {
                boolean check_sub = false;
                if (rela2.equals("AND")) {
                    check_sub = goalCheckHelp(subgoal1, quantity1, gold, exp, turns)
                    && goalCheckHelp(subgoal2, quantity2, gold, exp, turns);
                } else if (rela2.equals("OR")) {
                    check_sub = goalCheckHelp(subgoal1, quantity1, gold, exp, turns)
                    || goalCheckHelp(subgoal2, quantity2, gold, exp, turns);
                }
                String goal=null;
                int goalq = 0;
                for(int i = 0; i <2; i++) {
                    JSONObject goalcondi = conditions.getJSONArray("subgoals").getJSONObject(i);
                    if (!goalcondi.getString("goal").equals("AND") && !goalcondi.getString("goal").equals("OR")) {
                        goal = goalcondi.getString("goal");
                        goalq = goalcondi.getInt("quantity");
                        
                    }

                }
                if (rela.equals("AND")) {
                    return goalCheckHelp(goal, goalq, gold, exp, turns)
                    && check_sub;
                } else if (rela.equals("OR")) {
                    return goalCheckHelp(goal, goalq, gold, exp, turns)
                    || check_sub;
                }


            }   
            
        }
        return false;
    }

}