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

    /**
     * set current status 
     * @param gold
     * @param exp
     * @param turns
     * @param bosses
     */
    public void setCurrentStatus (int gold, int exp, int turns,boolean bosses){
        this.gold.setGoal(gold);
        this.exp.setGoal(exp);
        this.turns.setGoal(turns);
        this.bosses.setGoal(bosses);
    }

    /**
     * print all goals in string form
     * @return goal in string form
     */
    public String goal_to_string(){        
        String fronted = conditions.toString();
        fronted = fronted.replace("{", "");
        fronted = fronted.replace("}", "");
        fronted = fronted.replace("\"","");
        fronted = fronted.replace("[","(");
        fronted = fronted.replace("]",")");
        fronted = fronted.replace("quantity","");
        fronted = fronted.replace("goal:","");
        fronted = fronted.replace("subgoals:","");
        fronted = fronted.replace(",","");
        fronted = fronted.replace("AND"," AND ");
        fronted = fronted.replace("OR"," OR ");
        fronted = "WINING CONDITIONS: "+ fronted;

        return fronted;

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