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
        assertEquals(e.getHealth(), 3);
        assertEquals(e.getAttackRange(), 1);
        assertEquals(e.getSupportRange(), 2);
        assertEquals(e.getName(), "Jeffery");
        e.setAggressivity(1);
        assertEquals(e.getAggressivity(), 1);
        e.setHealth(1);
        assertEquals(e.getHealth(), 1);
        e.setAttackRange(2);
        assertEquals(e.getAttackRange(), 2);
        e.setSupportRange(1);
        assertEquals(e.getSupportRange(), 1);
        e.setName("Steve");
        assertEquals(e.getName(), "Steve");
    }
}
