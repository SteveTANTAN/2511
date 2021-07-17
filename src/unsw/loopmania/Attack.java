package unsw.loopmania;

import java.util.List;

public interface Attack {
    public void hit(Character c, List<BasicEnemy> trancedEnemies, List<BasicEnemy> enemies,BasicEnemy e, String who);
}