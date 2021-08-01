package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.AlliedSoldier;
import unsw.loopmania.BasicEnemy;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Shield;
import unsw.loopmania.Slug;
import unsw.loopmania.Vampire;
import unsw.loopmania.Zombie;
import unsw.loopmania.Character;
import unsw.loopmania.Doggie;
import unsw.loopmania.ElanMuske;

import org.javatuples.Pair;

public class BasicEnemyTest {
    @Test
    public void enemyTest1(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Slug e = new Slug(Pp);
        assertEquals(e.getAggressivity(), 4);
        e.setAggressivity(1);
        assertEquals(e.getAggressivity(), 1);
    }

    @Test
    public void enemyTest2(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Slug e = new Slug(Pp);
        assertEquals(e.getHealth(), 12);
        e.setHealth(1);
        assertEquals(e.getHealth(), 1);
    }

    @Test
    public void enemyTest3(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Slug e = new Slug(Pp);
    
        assertEquals(e.getAttackRange(), 1);
        e.setAttackRange(2);
        assertEquals(e.getAttackRange(), 2);
    }

    @Test
    public void enemyTest4(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Slug e = new Slug(Pp);
        
        assertEquals(e.getSupportRange(), 1);
        e.setSupportRange(2);
        assertEquals(e.getSupportRange(), 2);
    }

    @Test
    public void enemyTest5(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Slug e = new Slug(Pp);
        assertEquals(e.getName(), "Slug");
        e.setName("Steve");
        assertEquals(e.getName(), "Steve");
    }

    @Test
    public void enemyTest6(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Slug e = new Slug(Pp);
        assertEquals(e.getGoldDefeated(), 1);
        e.setGoldDefeated(2);
        assertEquals(e.getGoldDefeated(), 2);
    }

    @Test
    public void enemyTest7(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Slug e = new Slug(Pp);
        assertEquals(e.getEXP(), 20);
        e.setEXP(1);
        assertEquals(e.getEXP(), 1);
    }

    @Test
    public void enemyTest8(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Slug e = new Slug(Pp);
        assertEquals(e.getLevel(), "Monster");
        e.setLevel("Boss");
        assertEquals(e.getLevel(), "Boss");
    }

    @Test
    public void SlugAttackTest(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character c = new Character(Pp);
        Slug e = new Slug(Pp);
        e.attack(c, trancedEnemies, enemies, e);
        assertEquals(c.getHealth(), 96);
    }

    @Test
    public void zombieTest1(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Zombie e = new Zombie(Pp,null);
        assertEquals(e.getAggressivity(), 8);
        e.setAggressivity(1);
        assertEquals(e.getAggressivity(), 1);
    }

    @Test
    public void zombieTest2(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Zombie e = new Zombie(Pp,null);
        assertEquals(e.getHealth(), 18);
        e.setHealth(1);
        assertEquals(e.getHealth(), 1);
    }

    @Test
    public void zombieTest3(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Zombie e = new Zombie(Pp,null);
    
        assertEquals(e.getAttackRange(), 2);
        e.setAttackRange(1);
        assertEquals(e.getAttackRange(), 1);
    }

    @Test
    public void zombieTest4(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Zombie e = new Zombie(Pp,null);
        
        assertEquals(e.getSupportRange(), 0);
        e.setSupportRange(2);
        assertEquals(e.getSupportRange(), 2);
    }

    @Test
    public void zombieTest5(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Zombie e = new Zombie(Pp,null);
        assertEquals(e.getName(), "Zombie");
        e.setName("Jeffery");
        assertEquals(e.getName(), "Jeffery");
    }

    @Test
    public void zombieTest6(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Zombie e = new Zombie(Pp,null);
        assertEquals(e.getGoldDefeated(), 3);
        e.setGoldDefeated(2);
        assertEquals(e.getGoldDefeated(), 2);
    }

    @Test
    public void zombieTest7(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Zombie e = new Zombie(Pp,null);
        assertEquals(e.getEXP(), 40);
        e.setEXP(1);
        assertEquals(e.getEXP(), 1);
    }

    @Test
    public void ZombieAttackTest1(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character c = new Character(Pp);
        Zombie e = new Zombie(Pp, null);
        e.attack(c, trancedEnemies, enemies, e);
        assertEquals(c.getHealth(), 92);
    }

    @Test
    public void ZombieAttackTest2(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character c = new Character(Pp);
        Zombie e = new Zombie(Pp, null);
        while (e.getIntefactors().isEmpty()) {
            e.attack(c, trancedEnemies, enemies, e);
            AlliedSoldier s = new AlliedSoldier(null, null);
            c.addSoldier(s);
        }
        assertTrue(!e.getIntefactors().isEmpty());
        Character s = new Character(Pp);
        e.attack(s, trancedEnemies, enemies, e);
        assertEquals(s.getHealth(), 84);
    }


    @Test
    public void vampireTest1(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Vampire e = new Vampire(Pp,null);
        assertEquals(e.getAggressivity(), 15);
        e.setAggressivity(1);
        assertEquals(e.getAggressivity(), 1);
    }

    @Test
    public void vampireTest2(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Vampire e = new Vampire(Pp,null);
        assertEquals(e.getHealth(), 32);
        e.setHealth(1);
        assertEquals(e.getHealth(), 1);
    }

    @Test
    public void vampireTest3(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Vampire e = new Vampire(Pp,null);;
    
        assertEquals(e.getAttackRange(), 2);
        e.setAttackRange(1);
        assertEquals(e.getAttackRange(), 1);
    }

    @Test
    public void vampireTest4(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Vampire e = new Vampire(Pp,null);
        
        assertEquals(e.getSupportRange(), 2);
        e.setSupportRange(1);
        assertEquals(e.getSupportRange(), 1);
    }

    @Test
    public void vampireTest5(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Vampire e = new Vampire(Pp,null);
        assertEquals(e.getName(), "Vampire");
        e.setName("Victor");
        assertEquals(e.getName(), "Victor");
    }

    @Test
    public void vampireTest6(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Vampire e = new Vampire(Pp,null);
        assertEquals(e.getGoldDefeated(), 5);
        e.setGoldDefeated(2);
        assertEquals(e.getGoldDefeated(), 2);
    }

    @Test
    public void vampireTest7(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Vampire e = new Vampire(Pp,null);
        assertEquals(e.getEXP(), 60);
        e.setEXP(1);
        assertEquals(e.getEXP(), 1);
    }

    @Test
    public void VampireAttackTest1(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character c = new Character(Pp);
        Vampire e = new Vampire(Pp, null);
        e.attack(c, trancedEnemies, enemies, e);
        while (c.getHealth() != 85) {
            c.setHealth(100);
            e.attack(c, trancedEnemies, enemies, e);
        }
        assertEquals(c.getHealth(), 85);
    }

    @Test
    public void VampireAttackTest2(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character c = new Character(Pp);
        Vampire e = new Vampire(Pp, null);
        e.attack(c, trancedEnemies, enemies, e);
        while (c.getHealth() == 85) {
            c.setHealth(100);
            e.attack(c, trancedEnemies, enemies, e);
        }
        assertNotEquals(c.getHealth(), 85);
    }

    @Test
    public void VampireAttackTest3(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character c = new Character(Pp);
        Vampire e = new Vampire(Pp, null);
        e.attack(c, trancedEnemies, enemies, e);
        while (c.getHealth() == 85) {
            c.setHealth(100);
            e.attack(c, trancedEnemies, enemies, e);
        }
        assertNotEquals(c.getHealth(), 85);
    }

    @Test
    public void VampireAttackTest4(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character c = new Character(Pp);
        Shield s = new Shield(null, null, 0, 0, 0);
        c.setShield(s);
        Vampire e = new Vampire(Pp, null);
        e.attack(c, trancedEnemies, enemies, e);
        while (c.getHealth() != 85) {
            c.setHealth(100);
            e.attack(c, trancedEnemies, enemies, e);
        }
        assertEquals(c.getHealth(), 85);
    }

    @Test
    public void VampireAttackTest5(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character c = new Character(Pp);
        Vampire e = new Vampire(Pp, null);
        Shield s = new Shield(null, null, 0, 0, 0);
        c.setShield(s);
        e.attack(c, trancedEnemies, enemies, e);
        while (c.getHealth() == 85) {
            c.setHealth(100);
            e.attack(c, trancedEnemies, enemies, e);
        }
        assertNotEquals(c.getHealth(), 85);
    }

    @Test
    public void alliedSoldierTest1(){
        AlliedSoldier soldier = new AlliedSoldier(new SimpleIntegerProperty(1),new SimpleIntegerProperty(1));
        assertEquals(soldier.getAggressivity(), 5);
    }

    @Test
    public void alliedSoldierTest2(){
        AlliedSoldier soldier = new AlliedSoldier(new SimpleIntegerProperty(1),new SimpleIntegerProperty(1));
        assertEquals(soldier.getHealth(), 15);
    }

    @Test
    public void alliedSoldierTest3(){
        AlliedSoldier soldier = new AlliedSoldier(new SimpleIntegerProperty(1),new SimpleIntegerProperty(1));
        soldier.setAggressivity(1);
        assertEquals(soldier.getAggressivity(), 1);
    }

    @Test
    public void alliedSoldierTest4(){
        AlliedSoldier soldier = new AlliedSoldier(new SimpleIntegerProperty(1),new SimpleIntegerProperty(1));
        soldier.setHealth(1);
        assertEquals(soldier.getHealth(), 1);
    }

    @Test
    public void DoggieTest1(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Doggie e = new Doggie(Pp);
        assertEquals(e.getAggressivity(), 21);
        e.setAggressivity(1);
        assertEquals(e.getAggressivity(), 1);
    }

    @Test
    public void DoggieTest2(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Doggie e = new Doggie(Pp);
        assertEquals(e.getHealth(), 30);
        e.setHealth(1);
        assertEquals(e.getHealth(), 1);
    }

    @Test
    public void DoggieTest3(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Doggie e = new Doggie(Pp);
    
        assertEquals(e.getAttackRange(), 1);
        e.setAttackRange(2);
        assertEquals(e.getAttackRange(), 2);
    }

    @Test
    public void DoggieTest4(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Doggie e = new Doggie(Pp);
        
        assertEquals(e.getSupportRange(), 1);
        e.setSupportRange(2);
        assertEquals(e.getSupportRange(), 2);
    }

    @Test
    public void DoggieTest5(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Doggie e = new Doggie(Pp);
        assertEquals(e.getName(), "Doggie");
        e.setName("Jeffery");
        assertEquals(e.getName(), "Jeffery");
    }

    @Test
    public void DoggieTest6(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Doggie e = new Doggie(Pp);
        assertEquals(e.getGoldDefeated(), 10);
        e.setGoldDefeated(2);
        assertEquals(e.getGoldDefeated(), 2);
    }

    @Test
    public void DoggieTest7(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Doggie e = new Doggie(Pp);
        assertEquals(e.getEXP(), 80);
        e.setEXP(1);
        assertEquals(e.getEXP(), 1);
    }

    @Test
    public void DoggieAttackTest1(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Doggie e = new Doggie(Pp);
        Character c = new Character(Pp);
        while (!c.getStupor()) {
            c.setHealth(100);
            e.attack(c, trancedEnemies, enemies, e);
        }
        assertTrue(c.getStupor());
    }

    @Test
    public void DoggieAttackTest2(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Doggie e = new Doggie(Pp);
        Character c = new Character(Pp);
        e.attack(c, trancedEnemies, enemies, e);
        while (c.getStupor()) {
            c.setHealth(100);
            e.attack(c, trancedEnemies, enemies, e);
        }
        assertEquals(c.getHealth(), 79);
    }

    @Test
    public void ElanMuskeTest1(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        ElanMuske e = new ElanMuske(Pp);
        assertEquals(e.getAggressivity(), 27);
        e.setAggressivity(1);
        assertEquals(e.getAggressivity(), 1);
    }

    @Test
    public void ElanMuskeTest2(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        ElanMuske e = new ElanMuske(Pp);
        assertEquals(e.getHealth(), 40);
        e.setHealth(1);
        assertEquals(e.getHealth(), 1);
    }

    @Test
    public void ElanMuskeTest3(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        ElanMuske e = new ElanMuske(Pp);
    
        assertEquals(e.getAttackRange(), 1);
        e.setAttackRange(2);
        assertEquals(e.getAttackRange(), 2);
    }

    @Test
    public void ElanMuskeTest4(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        ElanMuske e = new ElanMuske(Pp);
        
        assertEquals(e.getSupportRange(), 1);
        e.setSupportRange(2);
        assertEquals(e.getSupportRange(), 2);
    }

    @Test
    public void ElanMuskeTest5(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        ElanMuske e = new ElanMuske(Pp);
        assertEquals(e.getName(), "Elan Muske");
        e.setName("Jeffery");
        assertEquals(e.getName(), "Jeffery");
    }

    @Test
    public void ElanMuskeTest6(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        ElanMuske e = new ElanMuske(Pp);
        assertEquals(e.getGoldDefeated(), 20);
        e.setGoldDefeated(2);
        assertEquals(e.getGoldDefeated(), 2);
    }

    @Test
    public void ElanMuskeTest7(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        ElanMuske e = new ElanMuske(Pp);
        assertEquals(e.getEXP(), 100);
        e.setEXP(1);
        assertEquals(e.getEXP(), 1);
    }

    @Test
    public void ElanMuskeAttackTest1(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        ElanMuske e = new ElanMuske(Pp);
        Character c = new Character(Pp);
        enemies.add(e);
        e.attack(c, trancedEnemies, enemies, e);

        assertEquals(c.getHealth(), 73);
        assertEquals(e.getHealth(), 45);
    }
}