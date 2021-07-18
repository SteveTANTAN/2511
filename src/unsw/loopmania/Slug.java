package unsw.loopmania;

public class Slug extends BasicEnemy{
    /**
     * slug constructor
     * @param position slug position
     */
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
}
