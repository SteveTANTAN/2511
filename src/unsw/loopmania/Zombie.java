package unsw.loopmania;

public class Zombie extends BasicEnemy{
    public Zombie(PathPosition position) {
        super(position, 8, 18, 2, 0, "Zombie");
    }

    public int GoldLeft() {
        return 3;
    }

    public int ExpLeft() {
        return 5;
    }
}