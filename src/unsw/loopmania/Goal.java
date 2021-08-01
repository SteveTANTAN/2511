package unsw.loopmania;


import org.json.JSONObject;

public class Goal {
    public JSONObject conditions;
    public LoopManiaWorld loopManiaWorld;
    public int gold;
    public int exp;
    public int turns;
    public boolean bosses;

    public Goal(JSONObject condition){

        this.conditions = condition;

    }

    public void setCurrentStatus (int gold, int exp, int turns,boolean bosses){
        this.gold = gold;
        this.exp = exp;
        this.turns = turns;
        this.bosses = bosses;
    }
    public String goal_to_string(){        
        int loopNum = (Integer)conditions.getJSONArray("subgoals").getJSONObject(0).get("quantity");
        int goldAuount = (Integer)conditions.getJSONArray("subgoals").getJSONObject(1).getJSONArray("subgoals").getJSONObject(0).get("quantity");
        int expAmount = (Integer)conditions.getJSONArray("subgoals").getJSONObject(1).getJSONArray("subgoals").getJSONObject(1).get("quantity");
        return String.format("Winning Conditions:Looping reaches %d & Gold reaches %d & EXP reaches %d", loopNum,goldAuount,expAmount);
    }

    /**
     * checking if it meets the specifct condition
     * 
     * @param  String type, int quantity, int gold, int exp, int turns
     * @return Boolean
     */
    public boolean goalCheckHelp (String type, int quantity) {
        
        switch (type) {
            case "gold" :
                return gold >= quantity;
            case "experience" :
                return exp >= quantity;
            case "cycles" :
                return turns >= quantity;
            case "bosses" :
                return bosses;
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
    public boolean goalCheck() {


        //System.out.printf(conditions.toString(4));
        // if it's the only one level goal
        if (!conditions.has("subgoals")) {
            if ((conditions.getString("goal")).equals("bosses")){
                return goalCheckHelp("bosses", 0);
            }
            return goalCheckHelp(conditions.getString("goal"), conditions.getInt("quantity"));
            
        } else{
            // otherwise at least level2
            String rela = conditions.getString("goal");
            if (rela.equals("AND")) {
                AndGoal andgoal = new AndGoal(this.conditions);

                andgoal.setCurrentStatus(gold, exp, turns, bosses);
                return andgoal.subgoalcheck();

            } else {
                OrGoal orgoal = new OrGoal(this.conditions);
                orgoal.setCurrentStatus(gold, exp, turns, bosses);
                return orgoal.subgoalcheck();
            }


        }
    }
    

}