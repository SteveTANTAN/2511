package unsw.loopmania;

import java.util.List;

public class ElanMuske extends BasicEnemy {

    public ElanMuske(PathPosition position) {
        super(position);
        super.setHealth(32);
        super.setAggressivity(15);
        super.setSupportRange(1);
        super.setAttackRange(1);
        super.setGoldDefeated(5);
        super.setEXP(8);
        super.setName("Elan Muske");
        super.setLevel("Boss");
    }

    @Override
    public void attack(Character c, List<BasicEnemy> trancedEnemies, List<BasicEnemy> enemies,BasicEnemy e) {
        HealAttack h = new HealAttack();
        h.hit(c, trancedEnemies, enemies, e, null);
    }
    
}
