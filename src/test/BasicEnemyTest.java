package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import unsw.loopmania.BasicEnemy;
import unsw.loopmania.PathPosition;
import org.javatuples.Pair;

public class BasicEnemyTest {
    @Test
    public void enemyTest1(){
        Pair p = new Pair(1, 1);
        List<Pair<Integer, Integer>> orderedPath;
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(currentPositionInPath, orderedPath);
        BasicEnemy e = new BasicEnemy(Pp, 4, 3, 1, 2, "Jeffery");
        assertEquals(e.getAggressivity(), 4);
        e.setAggressivity(1);
        assertEquals(e.getAggressivity(), 1);
    }

    @Test
    public void enemyTest2(){
        Pair p = new Pair(1, 1);
        List<Pair<Integer, Integer>> orderedPath;
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(currentPositionInPath, orderedPath);
        BasicEnemy e = new BasicEnemy(Pp, 4, 3, 1, 2, "Jeffery");
        assertEquals(e.getHealth(), 3);
        e.setHealth(1);
    }

    @Test
    public void enemyTest3(){
        Pair p = new Pair(1, 1);
        List<Pair<Integer, Integer>> orderedPath;
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(currentPositionInPath, orderedPath);
        BasicEnemy e = new BasicEnemy(Pp, 4, 3, 1, 2, "Jeffery");
    
        assertEquals(e.getAttackRange(), 1);
        e.setAttackRange(2);
        assertEquals(e.getAttackRange(), 2);
    }

    @Test
    public void enemyTest4(){
        Pair p = new Pair(1, 1);
        List<Pair<Integer, Integer>> orderedPath;
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(currentPositionInPath, orderedPath);
        BasicEnemy e = new BasicEnemy(Pp, 4, 3, 1, 2, "Jeffery");
        
        assertEquals(e.getSupportRange(), 2);
        e.setSupportRange(1);
        assertEquals(e.getSupportRange(), 1);
    }

    @Test
    public void enemyTest5(){
        Pair p = new Pair(1, 1);
        List<Pair<Integer, Integer>> orderedPath;
        orderedPath.add(p);
        PathPosition Pp = new PathPosition(currentPositionInPath, orderedPath);
        BasicEnemy e = new BasicEnemy(Pp, 4, 3, 1, 2, "Jeffery");
        assertEquals(e.getName(), "Jeffery");
        e.setName("Steve");
        assertEquals(e.getName(), "Steve");
    }
}
