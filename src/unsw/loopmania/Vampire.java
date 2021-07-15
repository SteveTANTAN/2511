package unsw.loopmania;

public class Vampire extends BasicEnemy{
    public Vampire(PathPosition position) {
        super(position, 15, 32, 2, 2, "Vampire");
    }

    public int GoldLeft() {
        return 5;
    }

    public int ExpLeft() {
        return 8;
    }
}