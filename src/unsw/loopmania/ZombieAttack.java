package unsw.loopmania;

import java.util.List;

public class ZombieAttack implements Attack{
    @Override
    public void hit(Character c, List<BasicEnemy> trancedEnemies, List<BasicEnemy> enemies,BasicEnemy e, String who) {
        c.getSoldiers().remove(0);
        Zombie z = new Zombie(c.getPosition());
        enemies.add(z);
    }
}
