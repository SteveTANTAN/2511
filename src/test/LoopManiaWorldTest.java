package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;


import org.javatuples.Pair;
import org.junit.Test;

import unsw.loopmania.BarrackBuilding;
import unsw.loopmania.BarrackCard;
import unsw.loopmania.BasicEnemy;
import unsw.loopmania.Building;
import unsw.loopmania.CARDS_TYPE;
import unsw.loopmania.Card;
import unsw.loopmania.Character;
import unsw.loopmania.Doggie;
import unsw.loopmania.ElanMuske;
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
    public void KillEnemyTest(){
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
        Slug s = new Slug(null);
        List<BasicEnemy> enemy = new ArrayList<>();
        world.getEnemies().add(s);
        world.killEnemy(s);
        assertEquals(enemy.size(), 0);
    }

    @Test
    public void fightElanMuskeTest(){
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
        PathPosition Pp = new PathPosition(0, orderedPath);
        LoopManiaWorld world = new LoopManiaWorld(4, 4, orderedPath);
        ElanMuske e = new ElanMuske(Pp);
        Character c = new Character(Pp);
        world.setCharacter(c);
        world.getEnemies().add(e);
        while (world.getencounterElanMuskeNum() == 0) {
            world.fight();
        }
        assertEquals(world.getencounterElanMuskeNum(), 1);
    }

    @Test
    public void fightDoggieTest(){
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
        PathPosition Pp = new PathPosition(0, orderedPath);
        LoopManiaWorld world = new LoopManiaWorld(4, 4, orderedPath);
        Doggie e = new Doggie(Pp);
        Character c = new Character(Pp);
        world.setCharacter(c);
        world.getEnemies().add(e);
        world.fight();
        assertEquals(world.getencounterDoggieNum(), 1);
        PathPosition p = new PathPosition(5, orderedPath);
        Doggie s = new Doggie(p);
        world.getEnemies().add(s);
        world.fight();
        assertEquals(world.getencounterDoggieNum(), 1);
    }

    @Test
    public void fightSlugTest(){
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
        PathPosition Pp = new PathPosition(2, orderedPath);
        LoopManiaWorld world = new LoopManiaWorld(4, 4, orderedPath);
        Slug e = new Slug(Pp);
        Character c = new Character(Pp);
        world.setCharacter(c);
        world.getEnemies().add(e);
        world.fight();
        assertEquals(world.getencounterSlugsNum(), 1);
        PathPosition p = new PathPosition(5, orderedPath);
        Zombie s = new Zombie(p, null);
        world.getEnemies().add(s);
        world.fight();
        assertEquals(world.getencounterSlugsNum(), 1);
        Vampire v = new Vampire(p, null);
        world.getEnemies().add(v);
        world.fight();
        assertEquals(world.getencounterVampiresNum(), 1);
    }

    @Test
    public void fightZombieTest(){
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
        PathPosition Pp = new PathPosition(0, orderedPath);
        LoopManiaWorld world = new LoopManiaWorld(4, 4, orderedPath);
        Zombie e = new Zombie(Pp, null);
        Character c = new Character(Pp);
        world.setCharacter(c);
        world.getEnemies().add(e);
        world.fight();
        assertEquals(world.getEncounterZombiesNum(), 1);
        PathPosition p = new PathPosition(5, orderedPath);
        Zombie s = new Zombie(p, null);
        world.getEnemies().add(s);
        world.fight();
        assertEquals(world.getEncounterZombiesNum(), 1);
    }

    @Test
    public void fightVampireTest(){
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
        PathPosition Pp = new PathPosition(0, orderedPath);
        LoopManiaWorld world = new LoopManiaWorld(4, 4, orderedPath);
        Vampire e = new Vampire(Pp, null);
        Character c = new Character(Pp);
        world.setCharacter(c);
        world.getEnemies().add(e);
        world.fight();
        assertEquals(world.getencounterVampiresNum(), 1);
        PathPosition p = new PathPosition(5, orderedPath);
        Vampire s = new Vampire(p, null);
        world.getEnemies().add(s);
        world.fight();
        assertEquals(world.getencounterVampiresNum(), 1);
    }

    @Test
    public void battleTest1(){
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
        PathPosition Pp = new PathPosition(0, orderedPath);
        LoopManiaWorld world = new LoopManiaWorld(4, 4, orderedPath);
        Slug e = new Slug(Pp);
        Character c = new Character(Pp);
        world.setCharacter(c);
        world.getEnemies().add(e);
        world.fight();
        world.runBattles();
        assertEquals(world.getEnemies().size(), 0);
        assertEquals(world.getSlugsNum(), 1);
    }

    @Test
    public void battleTest2(){
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
        PathPosition Pp = new PathPosition(0, orderedPath);
        LoopManiaWorld world = new LoopManiaWorld(4, 4, orderedPath);
        Zombie e = new Zombie(Pp, null);
        Character c = new Character(Pp);
        world.setCharacter(c);
        world.getEnemies().add(e);
        world.fight();
        world.runBattles();
        assertEquals(world.getEnemies().size(), 0);
        assertEquals(world.getZombiesNum(), 1);
    }

    @Test
    public void battleTest3(){
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
        PathPosition Pp = new PathPosition(0, orderedPath);
        LoopManiaWorld world = new LoopManiaWorld(4, 4, orderedPath);
        Vampire e = new Vampire(Pp, null);
        Character c = new Character(Pp);
        c.setDefense(10);
        world.setCharacter(c);
        world.getEnemies().add(e);
        world.fight();
        world.runBattles();
        assertEquals(world.getEnemies().size(), 0);
        assertEquals(world.getVampiresNum(), 1);
    }

    @Test
    public void battleTest4(){
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
        PathPosition Pp = new PathPosition(0, orderedPath);
        LoopManiaWorld world = new LoopManiaWorld(4, 4, orderedPath);
        Doggie e = new Doggie(Pp);
        Character c = new Character(Pp);
        c.setDefense(20);
        world.setCharacter(c);
        world.getEnemies().add(e);
        world.fight();
        world.runBattles();
        assertEquals(world.getEnemies().size(), 0);
        assertEquals(world.getDoggiesNum(), 1);
    }

    @Test
    public void battleTest5(){
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
        PathPosition Pp = new PathPosition(0, orderedPath);
        LoopManiaWorld world = new LoopManiaWorld(4, 4, orderedPath);
        ElanMuske e = new ElanMuske(Pp);
        Character c = new Character(Pp);
        c.setDefense(25);
        c.setAggressivity(100);
        world.setCharacter(c);
        world.getEnemies().add(e);
        while (world.getencounterElanMuskeNum() == 0) {
            world.runBattles();
        }
        assertEquals(world.getEnemies().size(), 0);
        assertEquals(world.getElanMuskeNum(), 1);
    }

}
