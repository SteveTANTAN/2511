package unsw.loopmania;


import org.json.JSONObject;

public class Goal {
    public JSONObject conditions;
    public LoopManiaWorld loopManiaWorld;
    public GoldGoal gold = new GoldGoal();
    public EXPGoal exp = new EXPGoal();
    public CyclesGoal turns = new CyclesGoal();
    public BossGoal bosses = new BossGoal();

    public Goal(JSONObject condition){

        this.conditions = condition;

    }

    public void setCurrentStatus (int gold, int exp, int turns,boolean bosses){
        this.gold.setGoal(gold);
        this.exp.setGoal(exp);
        this.turns.setGoal(turns);
        this.bosses.setGoal(bosses);
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
                return gold.getGoal() >= quantity;
            case "experience" :
                return exp.getGoal() >= quantity;
            case "cycles" :
                return turns.getGoal() >= quantity;
            case "bosses" :
                return bosses.getGoal();
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
        //goal_to_string();
        if (conditions == null) {
            return false;

        }

        //System.out.printf(conditions.toString(4));
        // if it's the only one level goal
        if (!conditions.has("subgoals")) {
            
            return goalCheckHelp(conditions.getString("goal"), conditions.getInt("quantity"));
        } else{
            // otherwise at least level2
            String rela = conditions.getString("goal");
            if (rela.equals("AND")) {
                AndGoal andgoal = new AndGoal(this.conditions);

                andgoal.setCurrentStatus(gold.getGoal(), exp.getGoal(), turns.getGoal(), bosses.getGoal());
                return andgoal.subgoalcheck();

            } else {
                OrGoal orgoal = new OrGoal(this.conditions);
                orgoal.setCurrentStatus(gold.getGoal(), exp.getGoal(), turns.getGoal(), bosses.getGoal());
                return orgoal.subgoalcheck();
            }


        }
    }
    

}