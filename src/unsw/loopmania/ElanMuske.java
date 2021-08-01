package unsw.loopmania;

import java.util.ArrayList;
import java.util.List;

public class ElanMuske extends BasicEnemy implements DoggieCoinObserver{
    /**
     * doggie coin observer
     */
    private List<Observer> doggieList = new ArrayList<Observer>();

    /**
     * constructor
     * @param position
     */
    public ElanMuske(PathPosition position) {
        super(position);
        super.setHealth(40); 
        super.setAggressivity(27);
        super.setSupportRange(1);
        super.setAttackRange(1);
        super.setGoldDefeated(20);
        super.setEXP(100);
        super.setName("Elan Muske");
        super.setLevel("Boss");
    }

    /**
     * elan muske attack
     */
    @Override
    public void attack(Character c, List<BasicEnemy> trancedEnemies, List<BasicEnemy> enemies,BasicEnemy e) {
        HealAttack h = new HealAttack();
        h.hit(c, trancedEnemies, enemies, e, null);
    }

    /**
     * add observer
     */
    @Override
    public void registerObserver(Observer ob) {
        doggieList.add(ob);
    }

    /**
     * remove observer
     */
    @Override
    public void removeObserver(Observer ob) {
        doggieList.remove(ob);
        
    }

    /**
     * notify observer
     */
    @Override
    public void notifyObservers(int newPrice) {
        for (Observer ob : doggieList) {
			ob.updatePrice(newPrice);
		}    
    }
    

}
