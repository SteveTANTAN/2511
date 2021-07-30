package unsw.loopmania;

import java.util.List;
import java.util.Random;

public class Doggie extends BasicEnemy{

    public Doggie(PathPosition position) {
        super(position);
        super.setHealth(32);
        super.setAggressivity(15);
        super.setSupportRange(1);
        super.setAttackRange(1);
        super.setGoldDefeated(5);
        super.setEXP(8);
        super.setName("Doggie");
        super.setLevel("Boss");
    }
    @Override
    public void attack(Character c, List<BasicEnemy> trancedEnemies, List<BasicEnemy> enemies,BasicEnemy e) {
        int index = new Random().nextInt(10);
        if (index < 2) {
            DoggieAttack d = new DoggieAttack();
            d.hit(c, trancedEnemies, enemies, e, null);
        } else {
            CommonAttack a = new CommonAttack();
            a.hit(c, trancedEnemies, enemies, e, "enemy");
        }
    }
}
