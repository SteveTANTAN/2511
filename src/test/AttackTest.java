package test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.beans.property.SimpleIntegerProperty;

import org.javatuples.Pair;

import unsw.loopmania.AlliedSoldier;
import unsw.loopmania.Armour;
import unsw.loopmania.BasicEnemy;
import unsw.loopmania.Character;
import unsw.loopmania.CommonAttack;
import unsw.loopmania.Helmet;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Slug;
import unsw.loopmania.StaffAttack;
import unsw.loopmania.Stake;
import unsw.loopmania.StakeAttack;
import unsw.loopmania.Vampire;
import unsw.loopmania.VampireAttack;
import unsw.loopmania.Zombie;
import unsw.loopmania.ZombieAttack;

public class AttackTest {

    private CommonAttack ca = new CommonAttack();
        
    @Test
    public void slugcommonAttackTest1(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Slug e = new Slug(Pp);
        ca.hit(Character, trancedEnemies, enemies, e, "enemy");
        assertEquals(Character.getHealth(), 96);
    }

    @Test
    public void VampirecommonAttackTest1(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Vampire e = new Vampire(Pp);
        ca.hit(Character, trancedEnemies, enemies, e, "enemy");
        assertEquals(Character.getHealth(), 85);
    }

    @Test
    public void VampireAttackTest1(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Vampire e = new Vampire(Pp);
        VampireAttack va = new VampireAttack();
        va.hit(Character, trancedEnemies, enemies, e, "enemy");
        assertNotEquals(Character.getHealth(), 85);
    }

    @Test
    public void ZombiecommonAttackTest1(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Zombie e = new Zombie(Pp);
        ca.hit(Character, trancedEnemies, enemies, e, "enemy");
        assertEquals(Character.getHealth(), 92);
    }

    @Test
    public void ZombieAttackTest1(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        AlliedSoldier soldier = new AlliedSoldier(new SimpleIntegerProperty(1),new SimpleIntegerProperty(1));
        Character.addSoldier(soldier);
        assertEquals(Character.getSoldiers().size(), 1);
        Zombie e = new Zombie(Pp);
        ZombieAttack za = new ZombieAttack();
        za.hit(Character, trancedEnemies, enemies, e, "enemy");
        assertEquals(Character.getSoldiers().size(), 0);
    }

    @Test
    public void AmmourTest(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Armour am = new Armour(null, null, 0, 0, 0);
        Character.setArmour(am);
        Slug e = new Slug(Pp);
        ca.hit(Character, trancedEnemies, enemies, e, "enemy");
        assertEquals(Character.getHealth(), 98);
    }

    @Test
    public void HelmetTest1(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Helmet Hm = new Helmet(null, null, 0, 0, 0);
        Character.setArmour(Hm);
        Slug e = new Slug(Pp);
        ca.hit(Character, trancedEnemies, enemies, e, "enemy");
        assertEquals(Character.getHealth(), 100);
    }

    @Test
    public void HelmetTest2(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Helmet Hm = new Helmet(null, null, 0, 0, 0);
        Character.setArmour(Hm);
        Slug e = new Slug(Pp);
        ca.hit(Character, trancedEnemies, enemies, e, "character");
        assertEquals(e.getHealth(), 10);
    }

    @Test
    public void CharacterTest(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Slug e = new Slug(Pp);
        ca.hit(Character, trancedEnemies, enemies, e, "character");
        assertEquals(e.getHealth(), 8);
    }

    @Test
    public void CharacterTestWithStake(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Stake s = new Stake(null, null, 0, 0, 0);
        Character.setWeapon(s);
        Slug e = new Slug(Pp);
        ca.hit(Character, trancedEnemies, enemies, e, "character");
        assertEquals(e.getHealth(), 8);
    }

    @Test
    public void CharacterTestWithStake2(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Stake s = new Stake(null, null, 0, 0, 0);
        Character.setWeapon(s);
        Vampire e = new Vampire(Pp);
        StakeAttack sa = new StakeAttack();
        sa.hit(Character, trancedEnemies, enemies, e, "character");
        assertEquals(e.getHealth(), 20);
    }

    @Test
    public void CharacterTestWithStaff(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Stake s = new Stake(null, null, 0, 0, 0);
        Character.setWeapon(s);
        Vampire e = new Vampire(Pp);
        StaffAttack sa = new StaffAttack();
        sa.hit(Character, trancedEnemies, enemies, e, "character");
        assertEquals(trancedEnemies.size(), 1);
        assertEquals(enemies.size(), 0);
    }
}
