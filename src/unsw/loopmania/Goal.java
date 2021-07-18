package unsw.loopmania;

import java.util.ArrayList;

import org.json.JSONObject;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.CheckBox;

public class Goal {
    public String goalType;
    public int quantity;
    public JSONObject conditions;
    public Goal(JSONObject condition){
        this.conditions = condition;
    }


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
    public boolean goalCheck(int gold, int exp, int turns) {
        if (conditions == null) {
            return false;

        }

        if (conditions.length() == 1) {
            return goalCheckHelp(conditions.getString("goal"), conditions.getString("quantity"), gold, exp, turns)
        } else if (conditions.length() == 2) {
            String rela = conditions.getString("goal");

            boolean is_foound = false;
            String rela2 = null;
            String subgoal1 = null;
            int quantity1 = 0;
            int quantity2 = 0;
            String subgoal2= null;
            for (int i = 0; i <2; i++){
                JSONObject goalcondi = conditions.getJSONArray("subgoals").getJSONObject(i);
                if (goalcondi.getString(("goal").equals("AND") || goalcondi.getString("goal").equals("OR"))) {
                    is_foound = true;
                    rela2 = goalcondi.getString("goal");
                    subgoal1 = goalcondi.getJSONArray("subgoals").getJSONObject(0).getString("goal");
                    subgoal2 = goalcondi.getJSONArray("subgoals").getJSONObject(1).getString("goal");
                    quantity1 = goalcondi.getJSONArray("subgoals").getJSONObject(0).getString("quantity");
                    quantity2 = goalcondi.getJSONArray("subgoals").getJSONObject(1).getString("quantity");
                    break;
                }
            }

            if (!is_foound) {
                Sring goal1 = goalcondi.getJSONArray("subgoals").getJSONObject(0).getString("goal");
                Sring goal2 = goalcondi.getJSONArray("subgoals").getJSONObject(1).getString("goal");
                int q1 = goalcondi.getJSONArray("subgoals").getJSONObject(0).getString("quantity");
                int q2 = goalcondi.getJSONArray("subgoals").getJSONObject(1).getString("quantity");
                if (rela.equals("AND")) {
                    return goalCheckHelp(goal1, q1, gold, exp, turns)
                    && goalCheckHelp(goal2, q2, gold, exp, turns);
                }
                if (rela.equals("OR")) {
                    return goalCheckHelp(goal1, q1, gold, exp, turns)
                    || goalCheckHelp(goal2, q2, gold, exp, turns);
                }

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
                    if (!goalcondi.getString(("goal").equals("AND") && !goalcondi.getString("goal").equals("OR"))) {
                        goal = goalcondi.getString("goal");
                        goalq = goalcondi.getString("quantity");
                        
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