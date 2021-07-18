package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import unsw.loopmania.PathPosition;
import unsw.loopmania.Slug;
import unsw.loopmania.Vampire;
import unsw.loopmania.Zombie;

import org.javatuples.Pair;

public class BasicEnemyTest {
    @Test
    public void enemyTest1(){
        Pair p = new Pair(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        Slug e = new Slug(Pp);
        assertEquals(e.getAggressivity(), 4);
        e.setAggressivity(1);
        assertEquals(e.getAggressivity(), 1);
    }

    @Test
    public void enemyTest2(){
        Pair p = new Pair(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        Slug e = new Slug(Pp);
        assertEquals(e.getHealth(), 12);
        e.setHealth(1);
        assertEquals(e.getHealth(), 1);
    }

    @Test
    public void enemyTest3(){
        Pair p = new Pair(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        Slug e = new Slug(Pp);
    
        assertEquals(e.getAttackRange(), 1);
        e.setAttackRange(2);
        assertEquals(e.getAttackRange(), 2);
    }

    @Test
    public void enemyTest4(){
        Pair p = new Pair(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        Slug e = new Slug(Pp);
        
        assertEquals(e.getSupportRange(), 1);
        e.setSupportRange(2);
        assertEquals(e.getSupportRange(), 2);
    }

    @Test
    public void enemyTest5(){
        Pair p = new Pair(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        Slug e = new Slug(Pp);
        assertEquals(e.getName(), "Slug");
        e.setName("Steve");
        assertEquals(e.getName(), "Steve");
    }

    @Test
    public void enemyTest6(){
        Pair p = new Pair(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        Slug e = new Slug(Pp);
        assertEquals(e.getGoldDefeated(), 1);
        e.setGoldDefeated(2);
        assertEquals(e.getGoldDefeated(), 2);
    }

    @Test
    public void enemyTest7(){
        Pair p = new Pair(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        Slug e = new Slug(Pp);
        assertEquals(e.getEXP(), 2);
        e.setEXP(1);
        assertEquals(e.getEXP(), 1);
    }

    @Test
    public void zombieTest1(){
        Pair p = new Pair(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        Zombie e = new Zombie(Pp);
        assertEquals(e.getAggressivity(), 8);
        e.setAggressivity(1);
        assertEquals(e.getAggressivity(), 1);
    }

    @Test
    public void zombieTest2(){
        Pair p = new Pair(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        Zombie e = new Zombie(Pp);
        assertEquals(e.getHealth(), 18);
        e.setHealth(1);
        assertEquals(e.getHealth(), 1);
    }

    @Test
    public void zombieTest3(){
        Pair p = new Pair(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        Zombie e = new Zombie(Pp);
    
        assertEquals(e.getAttackRange(), 2);
        e.setAttackRange(1);
        assertEquals(e.getAttackRange(), 1);
    }

    @Test
    public void zombieTest4(){
        Pair p = new Pair(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        Zombie e = new Zombie(Pp);
        
        assertEquals(e.getSupportRange(), 0);
        e.setSupportRange(2);
        assertEquals(e.getSupportRange(), 2);
    }

    @Test
    public void zombieTest5(){
        Pair p = new Pair(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        Zombie e = new Zombie(Pp);
        assertEquals(e.getName(), "Zombie");
        e.setName("Jeffery");
        assertEquals(e.getName(), "Jeffery");
    }

    @Test
    public void zombieTest6(){
        Pair p = new Pair(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        Zombie e = new Zombie(Pp);
        assertEquals(e.getGoldDefeated(), 3);
        e.setGoldDefeated(2);
        assertEquals(e.getGoldDefeated(), 2);
    }

    @Test
    public void zombieTest7(){
        Pair p = new Pair(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        Zombie e = new Zombie(Pp);
        assertEquals(e.getEXP(), 5);
        e.setEXP(1);
        assertEquals(e.getEXP(), 1);
    }

    @Test
    public void vampireTest1(){
        Pair p = new Pair(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        Vampire e = new Vampire(Pp);
        assertEquals(e.getAggressivity(), 15);
        e.setAggressivity(1);
        assertEquals(e.getAggressivity(), 1);
    }

    @Test
    public void vampireTest2(){
        Pair p = new Pair(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        Vampire e = new Vampire(Pp);
        assertEquals(e.getHealth(), 32);
        e.setHealth(1);
        assertEquals(e.getHealth(), 1);
    }

    @Test
    public void vampireTest3(){
        Pair p = new Pair(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        Vampire e = new Vampire(Pp);;
    
        assertEquals(e.getAttackRange(), 2);
        e.setAttackRange(1);
        assertEquals(e.getAttackRange(), 1);
    }

    @Test
    public void vampireTest4(){
        Pair p = new Pair(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        Vampire e = new Vampire(Pp);
        
        assertEquals(e.getSupportRange(), 2);
        e.setSupportRange(1);
        assertEquals(e.getSupportRange(), 1);
    }

    @Test
    public void vampireTest5(){
        Pair p = new Pair(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        Vampire e = new Vampire(Pp);
        assertEquals(e.getName(), "Vampire");
        e.setName("Victor");
        assertEquals(e.getName(), "Victor");
    }

    @Test
    public void vampireTest6(){
        Pair p = new Pair(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        Vampire e = new Vampire(Pp);
        assertEquals(e.getGoldDefeated(), 5);
        e.setGoldDefeated(2);
        assertEquals(e.getGoldDefeated(), 2);
    }

    @Test
    public void vampireTest7(){
        Pair p = new Pair(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        Vampire e = new Vampire(Pp);
        assertEquals(e.getEXP(), 8);
        e.setEXP(1);
        assertEquals(e.getEXP(), 1);
    }
}
