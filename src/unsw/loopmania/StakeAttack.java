package unsw.loopmania;

import java.util.List;

public class StakeAttack implements Attack{
    @Override
    public void hit(Character c, List<BasicEnemy> trancedEnemies, List<BasicEnemy> enemies,BasicEnemy e, String who) {
        int hurt;
        if (c.getArmour() instanceof Helmet) {
            hurt = - 2;
        }
        if (e.getName().equals("Vampire")) {
            hurt = c.getAggressivity() + 8;
        } else {
            hurt = c.getAggressivity();
        }

        e.setHealth(e.getHealth() - hurt);
    }
}
