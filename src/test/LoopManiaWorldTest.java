package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;


import org.javatuples.Pair;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import unsw.loopmania.BarrackBuilding;
import unsw.loopmania.BarrackCard;
import unsw.loopmania.BasicEnemy;
import unsw.loopmania.Building;
import unsw.loopmania.CARDS_TYPE;
import unsw.loopmania.Card;
import unsw.loopmania.Character;
import unsw.loopmania.Goal;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Slug;
import unsw.loopmania.Vampire;
import unsw.loopmania.VampireCastleBuilding;
import unsw.loopmania.VampireCastleCard;
import unsw.loopmania.VillageBuilding;
import unsw.loopmania.Zombie;

public class LoopManiaWorldTest {
    @Test
    public void loadCardTest(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        orderedPath.add(new Pair<Integer, Integer>(1,0));
        orderedPath.add(new Pair<Integer, Integer>(2,0));
        orderedPath.add(new Pair<Integer, Integer>(3,0));
        orderedPath.add(new Pair<Integer, Integer>(3,1));
        orderedPath.add(new Pair<Integer, Integer>(3,2));
        orderedPath.add(new Pair<Integer, Integer>(3,3));
        orderedPath.add(new Pair<Integer, Integer>(2,3));
        orderedPath.add(new Pair<Integer, Integer>(1,3));
        orderedPath.add(new Pair<Integer, Integer>(0,3));
        orderedPath.add(new Pair<Integer, Integer>(0,2));
        orderedPath.add(new Pair<Integer, Integer>(0,1));
        LoopManiaWorld world = new LoopManiaWorld(4, 4, orderedPath);
        
        Card card = world.loadCard(CARDS_TYPE.BARRACK);
        assertEquals(card instanceof BarrackCard, true);

        card = world.loadCard(CARDS_TYPE.VAMPIRECASTLE);
        assertEquals(card instanceof VampireCastleCard, true);
    }

    @Test
    public void convertCardToBuildingByCoordinates(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        orderedPath.add(new Pair<Integer, Integer>(1,0));
        orderedPath.add(new Pair<Integer, Integer>(2,0));
        orderedPath.add(new Pair<Integer, Integer>(3,0));
        orderedPath.add(new Pair<Integer, Integer>(3,1));
        orderedPath.add(new Pair<Integer, Integer>(3,2));
        orderedPath.add(new Pair<Integer, Integer>(3,3));
        orderedPath.add(new Pair<Integer, Integer>(2,3));
        orderedPath.add(new Pair<Integer, Integer>(1,3));
        orderedPath.add(new Pair<Integer, Integer>(0,3));
        orderedPath.add(new Pair<Integer, Integer>(0,2));
        orderedPath.add(new Pair<Integer, Integer>(0,1));
        LoopManiaWorld world = new LoopManiaWorld(4, 4, orderedPath);
        
        world.loadCard(CARDS_TYPE.BARRACK);
        world.loadCard(CARDS_TYPE.VAMPIRECASTLE);
        world.loadCard(CARDS_TYPE.VILLAGE);

        Building building = world.convertCardToBuildingByCoordinates(0,0,0,2);
        assertEquals(building instanceof BarrackBuilding, true);

        building = world.convertCardToBuildingByCoordinates(0,0,1,1);
        assertEquals(building instanceof VampireCastleBuilding, true);

        building = world.convertCardToBuildingByCoordinates(0,0,1,3);
        assertEquals(building instanceof VillageBuilding, true);
    }

    @Test
    public void buildingFunctionTest(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        orderedPath.add(new Pair<Integer, Integer>(1,0));
        orderedPath.add(new Pair<Integer, Integer>(2,0));
        orderedPath.add(new Pair<Integer, Integer>(3,0));
        orderedPath.add(new Pair<Integer, Integer>(3,1));
        orderedPath.add(new Pair<Integer, Integer>(3,2));
        orderedPath.add(new Pair<Integer, Integer>(3,3));
        orderedPath.add(new Pair<Integer, Integer>(2,3));
        orderedPath.add(new Pair<Integer, Integer>(1,3));
        orderedPath.add(new Pair<Integer, Integer>(0,3));
        orderedPath.add(new Pair<Integer, Integer>(0,2));
        orderedPath.add(new Pair<Integer, Integer>(0,1));
        LoopManiaWorld world = new LoopManiaWorld(4, 4, orderedPath);
        world.loadCard(CARDS_TYPE.TRAP);
        world.loadCard(CARDS_TYPE.TOWER);
        world.loadCard(CARDS_TYPE.VILLAGE);

        world.convertCardToBuildingByCoordinates(0,0,2,0);
        world.convertCardToBuildingByCoordinates(0,0,2,1);
        world.convertCardToBuildingByCoordinates(0,0,1,3);
        
        world.spawnAZombie(2,1,null);

        int currentPositionInPath = 8;
        PathPosition pathPosition = new PathPosition(currentPositionInPath, orderedPath);
        Character character = new Character(pathPosition);
        character.setHealth(40);
        world.setCharacter(character);
        List<BasicEnemy> deadEnemies = world.buildingFunction();
        assertEquals(character.getHealth(), 60);
        assertEquals(deadEnemies.size(), 1);
    }

    @Test
    public void checkAdjacentPathTest(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        orderedPath.add(new Pair<Integer, Integer>(1,0));
        orderedPath.add(new Pair<Integer, Integer>(2,0));
        orderedPath.add(new Pair<Integer, Integer>(3,0));
        orderedPath.add(new Pair<Integer, Integer>(3,1));
        orderedPath.add(new Pair<Integer, Integer>(3,2));
        orderedPath.add(new Pair<Integer, Integer>(3,3));
        orderedPath.add(new Pair<Integer, Integer>(2,3));
        orderedPath.add(new Pair<Integer, Integer>(1,3));
        orderedPath.add(new Pair<Integer, Integer>(0,3));
        orderedPath.add(new Pair<Integer, Integer>(0,2));
        orderedPath.add(new Pair<Integer, Integer>(0,1));
        LoopManiaWorld world = new LoopManiaWorld(4, 4, orderedPath);

        assertEquals(world.checkAdjacentPath(1, 2), true);
        assertEquals(world.checkAdjacentPath(2, 2), true);
        assertEquals(world.checkAdjacentPath(0, 1), false);
        assertEquals(world.checkAdjacentPath(1, 2), true);
    }

    @Test
    public void spawnEnemiesByBuilding(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        orderedPath.add(new Pair<Integer, Integer>(1,0));
        orderedPath.add(new Pair<Integer, Integer>(2,0));
        orderedPath.add(new Pair<Integer, Integer>(3,0));
        orderedPath.add(new Pair<Integer, Integer>(3,1));
        orderedPath.add(new Pair<Integer, Integer>(3,2));
        orderedPath.add(new Pair<Integer, Integer>(3,3));
        orderedPath.add(new Pair<Integer, Integer>(2,3));
        orderedPath.add(new Pair<Integer, Integer>(1,3));
        orderedPath.add(new Pair<Integer, Integer>(0,3));
        orderedPath.add(new Pair<Integer, Integer>(0,2));
        orderedPath.add(new Pair<Integer, Integer>(0,1));
        LoopManiaWorld world = new LoopManiaWorld(4, 4, orderedPath);

        world.loadCard(CARDS_TYPE.ZOMBIEPIT);
        world.loadCard(CARDS_TYPE.VAMPIRECASTLE);

        world.convertCardToBuildingByCoordinates(0,0,1,2);
        world.convertCardToBuildingByCoordinates(0,0,2,2);

        List<BasicEnemy> retLis = world.spawnEnemiesByBuilding();
        assertEquals(retLis.size(), 2);
        retLis = world.spawnEnemiesByBuilding();
        assertEquals(retLis.size(), 1);
        retLis = world.spawnEnemiesByBuilding();
        assertEquals(retLis.size(), 1);
        retLis = world.spawnEnemiesByBuilding();
        assertEquals(retLis.size(), 1);
        retLis = world.spawnEnemiesByBuilding();
        assertEquals(retLis.size(), 1);
        retLis = world.spawnEnemiesByBuilding();
        assertEquals(retLis.size(), 2);
    }

    @Test
    public void checkInPathTest(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        orderedPath.add(new Pair<Integer, Integer>(1,0));
        orderedPath.add(new Pair<Integer, Integer>(2,0));
        orderedPath.add(new Pair<Integer, Integer>(3,0));
        orderedPath.add(new Pair<Integer, Integer>(3,1));
        orderedPath.add(new Pair<Integer, Integer>(3,2));
        orderedPath.add(new Pair<Integer, Integer>(3,3));
        orderedPath.add(new Pair<Integer, Integer>(2,3));
        orderedPath.add(new Pair<Integer, Integer>(1,3));
        orderedPath.add(new Pair<Integer, Integer>(0,3));
        orderedPath.add(new Pair<Integer, Integer>(0,2));
        orderedPath.add(new Pair<Integer, Integer>(0,1));
        LoopManiaWorld world = new LoopManiaWorld(4, 4, orderedPath);

        assertEquals(world.checkInPath(1, 2), false);
        assertEquals(world.checkInPath(2, 2), false);
        assertEquals(world.checkInPath(2, 3), true);
        assertEquals(world.checkInPath(0, 2), true);
    }

    @Test
    public void removeCardTest(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        orderedPath.add(new Pair<Integer, Integer>(1,0));
        orderedPath.add(new Pair<Integer, Integer>(2,0));
        orderedPath.add(new Pair<Integer, Integer>(3,0));
        orderedPath.add(new Pair<Integer, Integer>(3,1));
        orderedPath.add(new Pair<Integer, Integer>(3,2));
        orderedPath.add(new Pair<Integer, Integer>(3,3));
        orderedPath.add(new Pair<Integer, Integer>(2,3));
        orderedPath.add(new Pair<Integer, Integer>(1,3));
        orderedPath.add(new Pair<Integer, Integer>(0,3));
        orderedPath.add(new Pair<Integer, Integer>(0,2));
        orderedPath.add(new Pair<Integer, Integer>(0,1));
        LoopManiaWorld world = new LoopManiaWorld(4, 4, orderedPath);
        
        Card card1 = world.loadCard(CARDS_TYPE.TRAP);
        Card card2 = world.loadCard(CARDS_TYPE.TOWER);
        world.loadCard(CARDS_TYPE.VILLAGE);

        world.removeCard(2);
        assertEquals(world.getLastCardEntity(), card2);

        world.removeCard(1);
        assertEquals(world.getLastCardEntity(), card1);

        world.removeCard(0);
        assertEquals(world.getLastCardEntity(), null);
    }

    @Test
    public void getLastCardEntityTest(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        orderedPath.add(new Pair<Integer, Integer>(1,0));
        orderedPath.add(new Pair<Integer, Integer>(2,0));
        orderedPath.add(new Pair<Integer, Integer>(3,0));
        orderedPath.add(new Pair<Integer, Integer>(3,1));
        orderedPath.add(new Pair<Integer, Integer>(3,2));
        orderedPath.add(new Pair<Integer, Integer>(3,3));
        orderedPath.add(new Pair<Integer, Integer>(2,3));
        orderedPath.add(new Pair<Integer, Integer>(1,3));
        orderedPath.add(new Pair<Integer, Integer>(0,3));
        orderedPath.add(new Pair<Integer, Integer>(0,2));
        orderedPath.add(new Pair<Integer, Integer>(0,1));
        LoopManiaWorld world = new LoopManiaWorld(4, 4, orderedPath);
        
        Card card = world.loadCard(CARDS_TYPE.TRAP);
        assertEquals(world.getLastCardEntity(), card);
        card = world.loadCard(CARDS_TYPE.TOWER);
        assertEquals(world.getLastCardEntity(), card);
        card = world.loadCard(CARDS_TYPE.VILLAGE);
        assertEquals(world.getLastCardEntity(), card);
    }

    @Test
    public void battleDetails1Test(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        orderedPath.add(new Pair<Integer, Integer>(1,0));
        orderedPath.add(new Pair<Integer, Integer>(2,0));
        orderedPath.add(new Pair<Integer, Integer>(3,0));
        orderedPath.add(new Pair<Integer, Integer>(3,1));
        orderedPath.add(new Pair<Integer, Integer>(3,2));
        orderedPath.add(new Pair<Integer, Integer>(3,3));
        orderedPath.add(new Pair<Integer, Integer>(2,3));
        orderedPath.add(new Pair<Integer, Integer>(1,3));
        orderedPath.add(new Pair<Integer, Integer>(0,3));
        orderedPath.add(new Pair<Integer, Integer>(0,2));
        orderedPath.add(new Pair<Integer, Integer>(0,1));
        LoopManiaWorld world = new LoopManiaWorld(4, 4, orderedPath);
        int currentPositionInPath = 2;
        PathPosition pathPosition = new PathPosition(currentPositionInPath, orderedPath);
        Character character = new Character(pathPosition);
        character.setHealth(100);
        world.setCharacter(character);

        currentPositionInPath = 3;
        pathPosition = new PathPosition(currentPositionInPath, orderedPath);
        Slug slug = new Slug(pathPosition);
        List<BasicEnemy> enemies = world.getEnemies();
        enemies.add(slug);

        int healthPt = world.getCharacter().getHealth();
        world.runBattles();
        int lossBlood = Math.max(healthPt-world.getCharacter().getHealth(), 0);

        int slugsNum = world.getencounterSlugsNum();
        int zombiesNum = world.getEncounterZombiesNum();
        int vampiresNum = world.getencounterVampiresNum();

        assertFalse(world.getIsDead());
        assertEquals(slugsNum, 1);
        assertEquals(zombiesNum, 0);
        assertEquals(vampiresNum, 0);
        assertEquals(lossBlood, 12);
    }
    @Test
    public void battleDetails2Test(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        orderedPath.add(new Pair<Integer, Integer>(1,0));
        orderedPath.add(new Pair<Integer, Integer>(2,0));
        orderedPath.add(new Pair<Integer, Integer>(3,0));
        orderedPath.add(new Pair<Integer, Integer>(3,1));
        orderedPath.add(new Pair<Integer, Integer>(3,2));
        orderedPath.add(new Pair<Integer, Integer>(3,3));
        orderedPath.add(new Pair<Integer, Integer>(2,3));
        orderedPath.add(new Pair<Integer, Integer>(1,3));
        orderedPath.add(new Pair<Integer, Integer>(0,3));
        orderedPath.add(new Pair<Integer, Integer>(0,2));
        orderedPath.add(new Pair<Integer, Integer>(0,1));
        LoopManiaWorld world = new LoopManiaWorld(4, 4, orderedPath);
        int currentPositionInPath = 2;
        PathPosition pathPosition = new PathPosition(currentPositionInPath, orderedPath);
        Character character = new Character(pathPosition);
        character.setHealth(100);
        world.setCharacter(character);


        // set goal
        JSONObject json = new JSONObject();
        json.put("goal","AND");
        JSONArray jsonArray = new JSONArray();
        JSONObject tmp = new JSONObject();
        tmp.put("goal","cycles");
        tmp.put("quantity",10);
        jsonArray.put(tmp);
        tmp = new JSONObject();
        tmp.put("goal","OR");
        JSONArray jsonArray1 = new JSONArray();
        JSONObject tmp1 = new JSONObject();
        tmp1.put("goal","experience");
        tmp1.put("quantity",200);
        jsonArray1.put(tmp1);
        tmp1 = new JSONObject();
        tmp1.put("goal","gold");
        tmp1.put("quantity",200);
        jsonArray1.put(tmp1);
        tmp.put("subgoals",jsonArray1);
        jsonArray.put(tmp);
        json.put("subgoals",jsonArray);
        world.setGoalCondition(new Goal(json));
        
        // ad enemies
        currentPositionInPath = 3;
        pathPosition = new PathPosition(currentPositionInPath, orderedPath);
        Slug slug = new Slug(pathPosition);
        List<BasicEnemy> enemies = world.getEnemies();
        enemies.add(slug);

        currentPositionInPath = 1;
        Zombie zombie = new Zombie(pathPosition,null);
        enemies.add(zombie);

        // check
        int healthPt = world.getCharacter().getHealth();
        world.runBattles();
        int lossBlood = Math.max(healthPt-world.getCharacter().getHealth(), 0);

        int slugsNum = world.getencounterSlugsNum();
        int zombiesNum = world.getEncounterZombiesNum();
        int vampiresNum = world.getencounterVampiresNum();

        assertFalse(world.getIsDead());
        assertEquals(slugsNum, 1);
        assertEquals(zombiesNum, 1);
        assertEquals(vampiresNum, 0);
        assertEquals(lossBlood, 76);
    }
    @Test
    public void battleDetails3Test(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        orderedPath.add(new Pair<Integer, Integer>(1,0));
        orderedPath.add(new Pair<Integer, Integer>(2,0));
        orderedPath.add(new Pair<Integer, Integer>(3,0));
        orderedPath.add(new Pair<Integer, Integer>(3,1));
        orderedPath.add(new Pair<Integer, Integer>(3,2));
        orderedPath.add(new Pair<Integer, Integer>(3,3));
        orderedPath.add(new Pair<Integer, Integer>(2,3));
        orderedPath.add(new Pair<Integer, Integer>(1,3));
        orderedPath.add(new Pair<Integer, Integer>(0,3));
        orderedPath.add(new Pair<Integer, Integer>(0,2));
        orderedPath.add(new Pair<Integer, Integer>(0,1));
        LoopManiaWorld world = new LoopManiaWorld(4, 4, orderedPath);
        int currentPositionInPath = 2;
        PathPosition pathPosition = new PathPosition(currentPositionInPath, orderedPath);
        Character character = new Character(pathPosition);
        character.setHealth(100);
        world.setCharacter(character);

        // set goal
        JSONObject json = new JSONObject();
        json.put("goal","AND");
        JSONArray jsonArray = new JSONArray();
        JSONObject tmp = new JSONObject();
        tmp.put("goal","cycles");
        tmp.put("quantity",10);
        jsonArray.put(tmp);
        tmp = new JSONObject();
        tmp.put("goal","OR");
        JSONArray jsonArray1 = new JSONArray();
        JSONObject tmp1 = new JSONObject();
        tmp1.put("goal","experience");
        tmp1.put("quantity",200);
        jsonArray1.put(tmp1);
        tmp1 = new JSONObject();
        tmp1.put("goal","gold");
        tmp1.put("quantity",200);
        jsonArray1.put(tmp1);
        tmp.put("subgoals",jsonArray1);
        jsonArray.put(tmp);
        json.put("subgoals",jsonArray);
        world.setGoalCondition(new Goal(json));
        
        // add enemies
        currentPositionInPath = 3;
        pathPosition = new PathPosition(currentPositionInPath, orderedPath);
        Slug slug = new Slug(pathPosition);
        List<BasicEnemy> enemies = world.getEnemies();
        enemies.add(slug);

        currentPositionInPath = 1;
        Vampire vampire = new Vampire(pathPosition,null);
        enemies.add(vampire);

        // check
        int healthPt = world.getCharacter().getHealth();
        world.runBattles();
        int lossBlood = Math.max(healthPt-world.getCharacter().getHealth(), 0);

        int slugsNum = world.getencounterSlugsNum();
        int zombiesNum = world.getEncounterZombiesNum();
        int vampiresNum = world.getencounterVampiresNum();

        assertTrue(world.getIsDead());
        assertEquals(slugsNum, 1);
        assertEquals(zombiesNum, 0);
        assertEquals(vampiresNum, 1);
        assertEquals(lossBlood, 100);
    }
}
