package unsw.loopmania;

import java.util.Random;

public class Zombie extends BasicEnemy{
    private Building building;
    /**
     * constructor of zombie
     * @param position position
     */
    public Zombie(PathPosition position, Building building) {
        super(position);
        super.setHealth(18);
        super.setAggressivity(8);
        super.setSupportRange(0);
        super.setAttackRange(2);
        super.setGoldDefeated(3);
        super.setEXP(5);
        super.setName("Zombie");
        this.building = building;
    } 

    /**
     * move the zombie
     */
    @Override
    public void move(){
        // this basic enemy moves in a random direction... 25% chance up or down, 50% chance not at all...
        int directionChoice = (new Random()).nextInt(6);
        if (directionChoice < 4){
            moveUpPath();
        }
        else{
            moveDownPath();
        }
    }
    public Building getZombieBuilding(){
        return building;
    }
}
