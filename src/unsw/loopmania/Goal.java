package unsw.loopmania;

import java.util.ArrayList;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.CheckBox;

public class Goal extends {
    public String goalType;
    public int quantity;
    public Goal(String type, int q){
        this.goalType = type;
        this.quantity = q;
    }
    public String getGoalType() {
        return goalType;
    }
    public int getQuantity() {
        return quantity;
    }


    public ArrayList goalCondition;
    // "goal-condition": {"goal": "experience", "quantity": 123456 },
    
    public void setGoalCondition(ArrayList goalCondition) {
        this.goalCondition = goalCondition;
    }
    
    public ArrayList getGoalCondition() {
        return goalCondition;
    }
}