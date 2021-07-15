package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import unsw.loopmania.BasicEnemy;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Slug;
import unsw.loopmania.Zombie;

import org.javatuples.Pair;

public class BasicEnemyTest {
    @Test
    public void enemyTest1(){
        Pair p = new Pair<Integer,Integer>(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new LinkedList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        BasicEnemy e = new BasicEnemy(Pp, 4, 3, 1, 2, "Jeffery");
        assertEquals(e.getAggressivity(), 4);
        e.setAggressivity(1);
        assertEquals(e.getAggressivity(), 1);
    }

    @Test
    public void enemyTest2(){
        Pair p = new Pair<Integer,Integer>(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new LinkedList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        BasicEnemy e = new BasicEnemy(Pp, 4, 3, 1, 2, "Jeffery");
        assertEquals(e.getHealth(), 3);
        e.setHealth(1);
    }

    @Test
    public void enemyTest3(){
        Pair p = new Pair<Integer,Integer>(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new LinkedList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        BasicEnemy e = new BasicEnemy(Pp, 4, 3, 1, 2, "Jeffery");
    
        assertEquals(e.getAttackRange(), 1);
        e.setAttackRange(2);
        assertEquals(e.getAttackRange(), 2);
    }

    @Test
    public void enemyTest4(){
        Pair p = new Pair<Integer,Integer>(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new LinkedList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        BasicEnemy e = new BasicEnemy(Pp, 4, 3, 1, 2, "Jeffery");
        
        assertEquals(e.getSupportRange(), 2);
        e.setSupportRange(1);
        assertEquals(e.getSupportRange(), 1);
    }

    @Test
    public void enemyTest5(){
        Pair p = new Pair<Integer,Integer>(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new LinkedList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        BasicEnemy e = new BasicEnemy(Pp, 4, 3, 1, 2, "Jeffery");
        assertEquals(e.getName(), "Jeffery");
        e.setName("Steve");
        assertEquals(e.getName(), "Steve");
    }

    @Test
    public void slugTest(){
        Pair p = new Pair<Integer,Integer>(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new LinkedList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        Slug e = new Slug(Pp);
        assertEquals(e.getName(), "Slug");
        e.setName("Steve");
        assertEquals(e.getName(), "Steve");
    }

    @Test
    public void slugGoldTest(){
        Pair p = new Pair<Integer,Integer>(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new LinkedList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        Slug e = new Slug(Pp);
        assertEquals(e.GoldLeft(), 1);
    }

    @Test
    public void slugExpTest(){
        Pair p = new Pair<Integer,Integer>(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new LinkedList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        Slug e = new Slug(Pp);
        assertEquals(e.ExpLeft(), 2);
    }

    @Test
    public void zombieGoldTest(){
        Pair p = new Pair<Integer,Integer>(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new LinkedList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        Zombie e = new Zombie(Pp);
        assertEquals(e.GoldLeft(), 3);
    }

    @Test
    public void zombieExpTest(){
        Pair p = new Pair<Integer,Integer>(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new LinkedList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        Zombie e = new Zombie(Pp);
        assertEquals(e.ExpLeft(), 5);
    }

    @Test
    public void vampireGoldTest(){
        Pair p = new Pair<Integer,Integer>(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new LinkedList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        Vampire e = new Vampire(Pp);
        assertEquals(e.GoldLeft(), 5);
    }

    @Test
    public void vampireExpTest(){
        Pair p = new Pair<Integer,Integer>(1, 1);
        List<Pair<Integer, Integer>> orderedPath = new LinkedList<Pair<Integer, Integer>>();
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(0, orderedPath);
        Vampire e = new Vampire(Pp);
        assertEquals(e.ExpLeft(), 8);
    }
}
