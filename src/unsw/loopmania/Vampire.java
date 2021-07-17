package unsw.loopmania;

import java.util.Random;

public class Vampire extends BasicEnemy{

    public Vampire(PathPosition position) {
        super(position);
        super.setHealthPoint(32);
        super.setDamageValue(15);
        super.setSupportRadius(2);
        super.setBattleRadius(2);
        super.setGoldDefeated(5);
        super.setEXP(8);
        super.setName("Vampire");
    }
    /**
     * move the vampire
     */
    @Override
    public void move(){
        // TODO = modify this, since this implementation doesn't provide the expected enemy behaviour
        // this basic enemy moves in a random direction... 25% chance up or down, 50% chance not at all...
        int directionChoice = (new Random()).nextInt(6);
        if (directionChoice < 2){
            moveUpPath();
        }
        else{
            moveDownPath();
        }
    }
}
