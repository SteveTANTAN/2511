package unsw.loopmania;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fight {
    public Fight(Character c, List<BasicEnemy> enemies) {
        List<BasicEnemy> tranceEnemies = new ArrayList<BasicEnemy>();
        while (!enemies.isEmpty() && c.getHealth() > 0) {
            if (!tranceEnemies.isEmpty()) {
                for (BasicEnemy b:tranceEnemies) {
                    if (b.getTranceTurn() == 0) {
                        tranceEnemies.remove(b);
                        enemies.add(b);
                    }
                }
            }


            if (!tranceEnemies.isEmpty()) {
                for (BasicEnemy b:tranceEnemies) {
                    if (b.getName().equals("Vampire")) {
                        int r = new Random().nextInt(10);
                        if (r < 3) {
                            VampireAttack va = new VampireAttack();
                            va.hit(c, tranceEnemies, enemies, enemies.get(0), "allied");
                        } else {
                            CommonAttack commonAttack = new CommonAttack();
                            commonAttack.hit(c, tranceEnemies, enemies, enemies.get(0), "vampire");
                        }
                    } else if (b.getName().equals("Zombie")) {
                        CommonAttack commonAttack = new CommonAttack();
                        commonAttack.hit(c, tranceEnemies, enemies, enemies.get(0), "zombie");
                    } else if (b.getName().equals("Slug")) {
                        CommonAttack commonAttack = new CommonAttack();
                        commonAttack.hit(c, tranceEnemies, enemies, enemies.get(0), "slug");
                    }
                    if (enemies.get(0).getHealth() <= 0) {
                        enemies.remove(0);
                    }
                    b.setTranceTurn(b.getTranceTurn() - 1);
                }
            }

            for (BasicEnemy e:enemies) {
                int randomNum = new Random().nextInt(10);
                if (randomNum < 3) {
                    switch (e.getName()) {
                        case "Vampire":
                            if (c.getShield() instanceof Shield) {
                                int index = new Random().nextInt(10);
                                if (index < 4) {
                                    VampireAttack va = new VampireAttack();
                                    va.hit(c, tranceEnemies, enemies, e, "enemy");
                                } else {
                                    CommonAttack commonAttack = new CommonAttack();
                                    commonAttack.hit(c, tranceEnemies, enemies, e, "enemy");
                                }
                            } else {
                                VampireAttack va = new VampireAttack();
                                va.hit(c, tranceEnemies, enemies, e, "enemy");
                            }
                            break;
    
                        case "Zombie":
    
                        case "Soldier":
                            ZombieAttack za = new ZombieAttack();
                            za.hit(c,tranceEnemies, enemies, e, "null");
                            break;

                        case "Slug":
                            CommonAttack commonAttack = new CommonAttack();
                            commonAttack.hit(c, tranceEnemies, enemies, e, "enemy");
                            break;
                    }
                } else {
                    CommonAttack commonAttack = new CommonAttack();
                    commonAttack.hit(c, tranceEnemies, enemies, e, "enemy");
                }

            }
            for (AlliedSoldier a :c.getSoldiers()) {
                CommonAttack commonAttack = new CommonAttack();
                commonAttack.hit(c, tranceEnemies, enemies, enemies.get(0), "soldier");
                if (enemies.get(0).getHealth() <= 0) {
                    enemies.remove(0);
                }
            }

            if (c.getWeapon() instanceof Sword) {
                CommonAttack commonAttack = new CommonAttack();
                commonAttack.hit(c, tranceEnemies, enemies, enemies.get(0), "character");
            } else if (c.getWeapon() instanceof Staff) {
                int random = new Random().nextInt(10);
                if (random == 2) {
                    StaffAttack sa = new StaffAttack();
                    sa.hit(c, tranceEnemies, enemies, enemies.get(0), "null");
                } else {
                    CommonAttack commonAttack = new CommonAttack();
                    commonAttack.hit(c, tranceEnemies, enemies, enemies.get(0), "character");
                }
            } else if (c.getWeapon() instanceof Stake) {
                StakeAttack ak = new StakeAttack();
                ak.hit(c, tranceEnemies, enemies, enemies.get(0), "null");
            }
            if (enemies.get(0).getHealth() <= 0) {
                enemies.remove(0);
            }
        }
    }
}