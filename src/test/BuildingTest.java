package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import javafx.beans.property.SimpleIntegerProperty;
import org.javatuples.Pair;
import unsw.loopmania.BarrackBuilding;
import unsw.loopmania.BasicEnemy;
import unsw.loopmania.CampfireBuilding;
import unsw.loopmania.Character;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Slug;
import unsw.loopmania.TowerBuilding;
import unsw.loopmania.TrapBuilding;
import unsw.loopmania.VampireCastleBuilding;
import unsw.loopmania.VillageBuilding;
import unsw.loopmania.ZombiePitBuilding;

public class BuildingTest{
    @Test
    public void TowerBuildingTest(){
        TowerBuilding building = new TowerBuilding(new SimpleIntegerProperty(2), new SimpleIntegerProperty(1));
        assertEquals(building.getX(), 2);
        assertEquals(building.getY(), 1);

        List<BasicEnemy> enemies = new ArrayList<>();
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

        int currentPositionInPath = 2;
        PathPosition pathPosition = new PathPosition(currentPositionInPath, orderedPath);
        Slug slug = new Slug(pathPosition);
        enemies.add(slug);

        currentPositionInPath = 6;
        pathPosition = new PathPosition(currentPositionInPath, orderedPath);
        slug = new Slug(pathPosition);
        enemies.add(slug);

        List<BasicEnemy> deadEnemies = building.work(enemies);
        assertEquals(deadEnemies.size(), 1);
        assertEquals(deadEnemies.get(0), enemies.get(0));
    }

    @Test
    public void ZombiePitBuildingTest(){
        ZombiePitBuilding building = new ZombiePitBuilding(new SimpleIntegerProperty(2), new SimpleIntegerProperty(2));
        assertEquals(building.getX(), 2);
        assertEquals(building.getY(), 2);

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
        List<BasicEnemy> enemies = building.spawnZombie(world);
        assertEquals(enemies.size(), 1);
    }

    @Test
    public void VampireCastleBuildingTest(){
        VampireCastleBuilding building = new VampireCastleBuilding(new SimpleIntegerProperty(2), new SimpleIntegerProperty(2));
        assertEquals(building.getX(), 2);
        assertEquals(building.getY(), 2);

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
        List<BasicEnemy> enemies = building.spawnVampires(world);
        assertEquals(enemies.size(), 1);
        enemies = building.spawnVampires(world);
        assertEquals(enemies.size(), 0);
        enemies = building.spawnVampires(world);
        assertEquals(enemies.size(), 0);
        enemies = building.spawnVampires(world);
        assertEquals(enemies.size(), 0);
        enemies = building.spawnVampires(world);
        assertEquals(enemies.size(), 0);
        enemies = building.spawnVampires(world);
        assertEquals(enemies.size(), 1);
    }

    @Test
    public void BarrackBuildingTest(){
        BarrackBuilding building = new BarrackBuilding(new SimpleIntegerProperty(3), new SimpleIntegerProperty(1));
        assertEquals(building.getX(), 3);
        assertEquals(building.getY(), 1);

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

        int currentPositionInPath = 4;
        PathPosition pathPosition = new PathPosition(currentPositionInPath, orderedPath);
        Character character = new Character(pathPosition);
        building.work(character);
        assertEquals(character.getSoldiers().size(), 1);

        currentPositionInPath = 5;
        pathPosition = new PathPosition(currentPositionInPath, orderedPath);
        character = new Character(pathPosition);
        building.work(character);
        assertEquals(character.getSoldiers().size(), 0);
    }

    @Test
    public void VillageBuildingTest(){
        VillageBuilding building = new VillageBuilding(new SimpleIntegerProperty(0), new SimpleIntegerProperty(1));
        assertEquals(building.getX(), 0);
        assertEquals(building.getY(), 1);

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

        int currentPositionInPath = 10;
        PathPosition pathPosition = new PathPosition(currentPositionInPath, orderedPath);
        Character character = new Character(pathPosition);
        character.setHealth(40);
        assertEquals(character.getHealth(), 40);
        building.work(character);
        assertEquals(character.getHealth(), 40);

        currentPositionInPath = 11;
        pathPosition = new PathPosition(currentPositionInPath, orderedPath);
        character = new Character(pathPosition);
        character.setHealth(52);
        assertEquals(character.getHealth(), 52);
        building.work(character);
        assertEquals(character.getHealth(), 72);
    }

    @Test
    public void TrapBuildingTest(){
        TrapBuilding building = new TrapBuilding(new SimpleIntegerProperty(0), new SimpleIntegerProperty(3));
        assertEquals(building.getX(), 0);
        assertEquals(building.getY(), 3);

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

        List<BasicEnemy> enemies = new ArrayList<>();
        int currentPositionInPath = 9;
        PathPosition pathPosition = new PathPosition(currentPositionInPath, orderedPath);
        Slug slug = new Slug(pathPosition);
        slug.setHealth(10);
        enemies.add(slug);

        currentPositionInPath = 9;
        pathPosition = new PathPosition(currentPositionInPath, orderedPath);
        slug = new Slug(pathPosition);
        slug.setHealth(22);
        enemies.add(slug);

        List<BasicEnemy> deadEnemies = building.work(enemies);
        assertEquals(deadEnemies.size(), 1);
        assertEquals(enemies.get(1).getHealth(), 10);
    }

    @Test
    public void CampfireBuildingTest(){
        CampfireBuilding building = new CampfireBuilding(new SimpleIntegerProperty(2), new SimpleIntegerProperty(2));
        assertEquals(building.getX(), 2);
        assertEquals(building.getY(), 2);

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

        int currentPositionInPath = 5;
        PathPosition pathPosition = new PathPosition(currentPositionInPath, orderedPath);
        Character character = new Character(pathPosition);
        assertEquals(building.work(character), true);

        currentPositionInPath = 1;
        pathPosition = new PathPosition(currentPositionInPath, orderedPath);
        character = new Character(pathPosition);
        assertEquals(building.work(character), false);
    }
}