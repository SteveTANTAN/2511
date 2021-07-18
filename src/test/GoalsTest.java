package test;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.Gold;
import unsw.loopmania.EXP;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.javatuples.Pair;
import org.json.JSONObject;
import org.json.JSONTokener;

import javafx.beans.property.SimpleIntegerProperty;

import unsw.loopmania.Armour;
import unsw.loopmania.Character;
import unsw.loopmania.HealthPotion;
import unsw.loopmania.Helmet;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.PathPosition;

import unsw.loopmania.Stake;
import unsw.loopmania.Sword;
import unsw.loopmania.TheOneRing;
import unsw.loopmania.Goal;


public class GoalsTest {
    @Test
    public void Gold1(){
        Gold gold = new Gold(0);
        assertEquals(gold.getCurrentGold(), 0);
        gold.setCurrentGold(1);
        assertEquals(gold.getCurrentGold(), 1);

    }
    
    @Test
    public void EXP(){
        EXP gold = new EXP(0);
        assertEquals(gold.getCurrentEXP(), 0);
        gold.setCurrentEXP(1);
        assertEquals(gold.getCurrentEXP(), 1);
    }
    @Test
    public void goal_test(){
        // JSONObject jsonArray;
        // try {
        //     jsonArray = new JSONObject(new JSONTokener(new FileReader("goals.json")));
        //     Goal gold = new Goal(jsonArray);
        //     assertEquals(gold.goalCheckHelp("gold", 5, 1, 1, 1), false);
        //     assertEquals(gold.goalCheck(1, 1, 1), false);

        // } catch (FileNotFoundException e) {
        // // Do something with `e`
        // }
        // List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        // orderedPath.add(new Pair<Integer, Integer>(0,0));
        // PathPosition pathPosition = new PathPosition(0, orderedPath);
        // LoopManiaWorld world = new LoopManiaWorld(32, 21, orderedPath);
        // world.setGoalCondition(jsonArray);
        // Goal gold = new Goal(jsonArray);

        // Character character = new Character(gold);
        // assertEquals(world.goalCheck(), false);

        

        
    }
    @Test
    public void goalcheck (){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        PathPosition pathPosition = new PathPosition(0, orderedPath);
        LoopManiaWorld world = new LoopManiaWorld(32, 21, orderedPath);
        Character character = new Character(pathPosition);
        Stake stake = new Stake(new SimpleIntegerProperty(0) ,new SimpleIntegerProperty(0), 4, 0, 10);
        // check character without equip stake
        assertEquals(character.getAggressivity(), 4);
        assertEquals(character.getDefense(), 0);
        // check charcter after equip stake
        world.setCharacterEquipment(character, stake);
        assertEquals(character.getAggressivity(), 8);
        assertEquals(character.getDefense(), 0); 
        // check charcter equip a sword(new weapon)  
        Sword sword = new Sword(new SimpleIntegerProperty(0) ,new SimpleIntegerProperty(0), 6, 0, 10);
        world.setCharacterEquipment(character, sword);
        assertEquals(character.getAggressivity(), 10);
        assertEquals(character.getDefense(), 0); 
    }
}
