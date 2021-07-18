package unsw.loopmania;

public class Slug extends BasicEnemy{
    public Slug(PathPosition position) {
        super(position);
        super.setHealth(12);
        super.setAggressivity(4);
        super.setSupportRange(1);
        super.setAttackRange(1);
        super.setGoldDefeated(1);
        super.setEXP(2);
        super.setName("Slug");
    }
    
    public int GoldLeft() {
        return 1;
    }

    public int ExpLeft() {
        return 2;
    }
}
