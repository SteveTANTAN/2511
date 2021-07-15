package unsw.loopmania;

public class Slug extends BasicEnemy{
    public Slug(PathPosition position) {
        super(position, 4, 12, 1, 1, "Slug");
    }
    
    public int GoldLeft() {
        return 1;
    }

    public int ExpLeft() {
        return 2;
    }
}
