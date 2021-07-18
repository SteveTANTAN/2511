package unsw.loopmania;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

import javax.swing.text.StyledEditorKit;

import org.javatuples.Pair;
import org.json.JSONObject;
import org.junit.platform.console.options.Theme;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ListChangeListener.Change;

/**
 * A backend world.
 *
 * A world can contain many entities, each occupy a square. More than one
 * entity can occupy the same square.
 */
public class LoopManiaWorld {
    // TODO = add additional backend functionality

    public static final int unequippedInventoryWidth = 4;
    public static final int unequippedInventoryHeight = 4;

    /**
     * width of the world in GridPane cells
     */
    private int width;

    /**
     * height of the world in GridPane cells
     */
    private int height;

    /**
     * generic entitites - i.e. those which don't have dedicated fields
     */
    private List<Entity> nonSpecifiedEntities;

    private Character character;

    // TODO = add more lists for other entities, for equipped inventory items, etc...

    // TODO = expand the range of enemies
    private List<BasicEnemy> enemies;

    // DONE = expand the range of cards
    private List<Card> cardEntities;

    // TODO = expand the range of items
    private List<Item> unequippedInventoryItems;

    // TODO = expand the range of buildings
    private List<Building> buildingEntities;

    /**
     * list of x,y coordinate pairs in the order by which moving entities traverse them
     */
    private List<Pair<Integer, Integer>> orderedPath;

    /**
     * list of goals showing
     */
    private Goal goalCondition;



    /**
     * the number of rounds
     */
    private int roundsNum = 0;
    /**
     * create the world (constructor)
     * 
     * @param width width of world in number of cells
     * @param height height of world in number of cells
     * @param orderedPath ordered list of x, y coordinate pairs representing position of path cells in world
     */
    public LoopManiaWorld(int width, int height, List<Pair<Integer, Integer>> orderedPath) {
        this.width = width;
        this.height = height;
        nonSpecifiedEntities = new ArrayList<>();
        character = null;
        enemies = new ArrayList<>();
        cardEntities = new ArrayList<>();
        unequippedInventoryItems = new ArrayList<>();
        this.orderedPath = orderedPath;
        buildingEntities = new ArrayList<>();
        //this.goalCondition = 

    }

    public boolean goalCheck(int gold, int exp, int turns) {
        return this.goalCondition.goalCheck(character.getGold(), character.getEXP(), roundsNum);

    }
    public void setGoalCondition(Goal goalCondition) {
        this.goalCondition = goalCondition;
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    /**
     * set the character. This is necessary because it is loaded as a special entity out of the file
     * @param character the character
     */
    public void setCharacter(Character character) {
        this.character = character;
    }
    
    /**
     * add a generic entity (without it's own dedicated method for adding to the world)
     * @param entity
     */
    public void addEntity(Entity entity) {
        // for adding non-specific entities (ones without another dedicated list)
        // TODO = if more specialised types being added from main menu, add more methods like this with specific input types...
        nonSpecifiedEntities.add(entity);
    }
    
    /**
     * spawns enemies if the conditions warrant it, adds to world
     * @return list of the enemies to be displayed on screen
     */
    public List<BasicEnemy> possiblySpawnEnemies(){
        // TODO = expand this very basic version
        Pair<Integer, Integer> pos = possiblyGetBasicEnemySpawnPosition();
        List<BasicEnemy> spawningEnemies = new ArrayList<>();
        if (pos != null){
            int indexInPath = orderedPath.indexOf(pos);
            Slug enemy = new Slug(new PathPosition(indexInPath, orderedPath));
            enemies.add(enemy);
            spawningEnemies.add(enemy);
        }
        return spawningEnemies;
    }
    
    /**
     * kill an enemy
     * @param enemy enemy to be killed
     */
    private void killEnemy(BasicEnemy enemy){
        enemy.destroy();
        enemies.remove(enemy);
    }
    
    /**
     * run the expected battles in the world, based on current world state
     * @return list of enemies which have been killed
     */
    public List<BasicEnemy> runBattles() {
        // TODO = modify this - currently the character automatically wins all battles without any damage!
        List<BasicEnemy> defeatedEnemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> possibleSupporEnemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> fightEnemies = new ArrayList<BasicEnemy>();
        for (BasicEnemy e: enemies){
            // Pythagoras: a^2+b^2 < radius^2 to see if within radius
            // TODO = you should implement different RHS on this inequality, based on influence radii and battle radii
            switch (e.getName()) {
                case "Slug":
                    if (Math.pow((character.getX()-e.getX()), 2) +  Math.pow((character.getY()-e.getY()), 2) <= 1){
                        // fight...
                        fightEnemies.add(e);
                    } else {
                        possibleSupporEnemies.add(e);
                    }
                    break;
                
                case "Zombie":
                    if (Math.pow((character.getX()-e.getX()), 2) +  Math.pow((character.getY()-e.getY()), 2) < 4){
                        // fight...
                        fightEnemies.add(e);
                    } else {
                        possibleSupporEnemies.add(e);
                    }
                    break;

                case "Vampire":
                    if (Math.pow((character.getX()-e.getX()), 2) +  Math.pow((character.getY()-e.getY()), 2) < 4){
                        // fight...
                        fightEnemies.add(e);
                    } else {
                        possibleSupporEnemies.add(e);
                    }
                    break;
                default:
                    break;
            }
        }

        for (BasicEnemy e: possibleSupporEnemies){
            switch (e.getName()) {
                case "Slug":
                    if (Math.pow((character.getX()-e.getX()), 2) +  Math.pow((character.getY()-e.getY()), 2) <= 1){
                        // fight...
                        fightEnemies.add(e);
                    }
                    break;

                case "Vampire":
                    if (Math.pow((character.getX()-e.getX()), 2) +  Math.pow((character.getY()-e.getY()), 2) < 9){
                        // fight...
                        fightEnemies.add(e);
                    }
                    break;
            }
        }

        List<BasicEnemy> tranceEnemies = new ArrayList<BasicEnemy>();
        while (!fightEnemies.isEmpty()) {
            CommonAttack commonAttack = new CommonAttack();

            if (!tranceEnemies.isEmpty()) {
                for (BasicEnemy b:tranceEnemies) {
                    if (b.getTranceTurn() == 0) {
                        tranceEnemies.remove(b);
                        fightEnemies.add(b);
                    }
                }
            }


            if (!tranceEnemies.isEmpty()) {
                for (BasicEnemy b:tranceEnemies) {
                    if (!fightEnemies.isEmpty()) {
                        if (b.getName().equals("Vampire")) {
                            int r = new Random().nextInt(10);
                            if (r < 3) {
                                VampireAttack va = new VampireAttack();
                                va.hit(character, tranceEnemies, fightEnemies, fightEnemies.get(0), "allied");
                            } else {
                                commonAttack.hit(character, tranceEnemies, fightEnemies, fightEnemies.get(0), "vampire");
                            }
                        } else if (b.getName().equals("Zombie")) {
                            commonAttack.hit(character, tranceEnemies, fightEnemies, fightEnemies.get(0), "zombie");
                        } else if (b.getName().equals("Slug")) {
                            commonAttack.hit(character, tranceEnemies, fightEnemies, fightEnemies.get(0), "slug");
                        }
                        if (fightEnemies.get(0).getHealth() <= 0) {
                            defeatedEnemies.add(fightEnemies.get(0));
                            fightEnemies.remove(0);
                        }
                        b.setTranceTurn(b.getTranceTurn() - 1);
                    }
                }
            }


            for (BasicEnemy e:fightEnemies) {
                System.out.println("e: " + e.getHealth());
                System.out.println("c: " + character.getHealth());
                int randomNum = new Random().nextInt(10);
                if (e.getName().equals("Zombie")) {
                    if (randomNum < 3 && !character.getSoldiers().isEmpty()) {
                        ZombieAttack za = new ZombieAttack();
                        za.hit(character, tranceEnemies, fightEnemies, e, "enemy");
                    } else {
                        commonAttack.hit(character, tranceEnemies, fightEnemies, e, "enemy");
                    }
                } else if (e.getName().equals("Vampire")) {
                    if (randomNum < 3) {
                        if (character.getShield() instanceof Shield) {
                            int index = new Random().nextInt(10);
                            if (index < 4) {
                                System.out.println("High damage");
                                VampireAttack va = new VampireAttack();
                                va.hit(character, tranceEnemies, enemies, e, "enemy");
                            } else {
                                commonAttack.hit(character, tranceEnemies, enemies, e, "enemy");
                            }
                        } else {
                            System.out.println("High damage");
                            VampireAttack va = new VampireAttack();
                            va.hit(character, tranceEnemies, fightEnemies, e, "enemy");
                        }
                    } else {
                        commonAttack.hit(character, tranceEnemies, enemies, e, "enemy");
                    }
                } else {
                    commonAttack.hit(character, tranceEnemies, fightEnemies, e, "enemy");
                }
                //e.setHealth(e.getHealth() - character.getAggressivity());
            }


            if (!fightEnemies.isEmpty()) {
                for (AlliedSoldier a :character.getSoldiers()) {
                    commonAttack.hit(character, tranceEnemies, fightEnemies, fightEnemies.get(0), "soldier");
                    if (fightEnemies.get(0).getHealth() <= 0) {
                        defeatedEnemies.add(fightEnemies.get(0));
                        fightEnemies.remove(0);
                    }
                }
            }
            
            if (!fightEnemies.isEmpty()) {
                if (character.getWeapon() instanceof Sword) {
                    commonAttack.hit(character, tranceEnemies, fightEnemies, fightEnemies.get(0), "character");
                } else if (character.getWeapon() instanceof Staff) {
                    int random = new Random().nextInt(10);
                    if (random == 2) {
                        StaffAttack sa = new StaffAttack();
                        sa.hit(character, tranceEnemies, fightEnemies, fightEnemies.get(0), "null");
                    } else {
                        commonAttack.hit(character, tranceEnemies, fightEnemies, fightEnemies.get(0), "character");
                    }
                } else if (character.getWeapon() instanceof Stake) {
                    StakeAttack ak = new StakeAttack();
                    ak.hit(character, tranceEnemies, fightEnemies, fightEnemies.get(0), "null");
                } else {
                    commonAttack.hit(character, tranceEnemies, fightEnemies, fightEnemies.get(0), "character");
                }
            }


            if (!fightEnemies.isEmpty()) {
                if (fightEnemies.get(0).getHealth() <= 0) {
                    defeatedEnemies.add(fightEnemies.get(0));
                    fightEnemies.remove(0);
                }
            } else {
                for (BasicEnemy e:tranceEnemies) {
                    defeatedEnemies.add(e);
                }
            }
        }
        
        
        
        /*
        Fight fight = new Fight();
        fight.fight(character, fightEnemies);
        if (fightEnemies.isEmpty()) {*/
        for (BasicEnemy e: defeatedEnemies){
                // IMPORTANT = we kill enemies here, because killEnemy removes the enemy from the enemies list
                // if we killEnemy in prior loop, we get java.util.ConcurrentModificationException
                // due to mutating list we're iterating over
            System.out.println("kill" + e.getName());
            killEnemy(e);
        }
        //}
        return defeatedEnemies;
    }
    
    /**
     * spawn a card in the world and return the card entity
     * @return a card to be spawned in the controller as a JavaFX node
     */
    public Card loadCard(CARDS_TYPE cards_TYPE){
        // if adding more cards than have, remove the first card...
        if (cardEntities.size() >= getWidth()){
            // TODO = give some cash/experience/item rewards for the discarding of the oldest card
            removeCard(0);
        }
        Card card = null;
        switch(cards_TYPE){
            case TOWER:{
                card = new TowerCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
                break;
            }
            case ZOMBIEPIT:{
                card = new ZombiePitCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
                break;
            }
            case VAMPIRECASTLE:{
                card = new VampireCastleCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
                break;
            }
            case BARRACK:{
                card = new BarrackCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
                break;
            }
            case VILLAGE:{
                card = new VillageCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
                break;
            }
            case TRAP:{
                card = new TrapCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
                break;
            }
            case CAMPFIRE:{
                card = new CampfireCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
                break;
            }
            default:
                break;
            }
        cardEntities.add(card);
        return card;
    }
    
    // /**
    //  * spawn a card in the world and return the card entity
    //  * @return a card to be spawned in the controller as a JavaFX node
    //  */
    // public VampireCastleCard loadVampireCard(){
        //     // if adding more cards than have, remove the first card...
        //     if (cardEntities.size() >= getWidth()){
            //         // TODO = give some cash/experience/item rewards for the discarding of the oldest card
            //         removeCard(0);
            //     }
            //     VampireCastleCard vampireCastleCard = new VampireCastleCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
            //     cardEntities.add(vampireCastleCard);
            //     return vampireCastleCard;
            // }
            
            /**
             * remove card at a particular index of cards (position in gridpane of unplayed cards)
             * @param index the index of the card, from 0 to length-1
             */
            private void removeCard(int index){
                Card c = cardEntities.get(index);
                int x = c.getX();
                c.destroy();
                cardEntities.remove(index);
                shiftCardsDownFromXCoordinate(x);
            }
            
            /**
             * spawn a item in the world and return the item entity
             * @return a item to be spawned in the controller as a JavaFX node
             */
            public Item addUnequippedItem(ITEMS_TYPE itemType){
                Pair<Integer, Integer> firstAvailableSlot = getFirstAvailableSlotForItem();
                if (firstAvailableSlot == null){
                    // eject the oldest unequipped item and replace it... oldest item is that at beginning of items
                    // TODO = give some cash/experience rewards for the discarding of the oldest sword
                    removeItemByPositionInUnequippedInventoryItems(0);
                    firstAvailableSlot = getFirstAvailableSlotForItem();
                }
                Item item = null;
                switch(itemType) {
                    case SWORD:{
                        item = new Sword(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()), 6, 0, 10);
                        break;
                    }
                    case STAKE:{
                        item = new Stake(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()), 4, 0, 10);
                        break;
                    }
                    case STAFF:{
                        item = new Staff(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()), 2, 0, 15);
                        break;
                    }
                    case ARMOUR:{
                        item = new Armour(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()), 0, 3, 20);
                        break;
                    }
                    case SHIELD:{
                item = new Shield(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()), 0, 0, 20);
                break;
            }
            case HELMET:{
                item = new Helmet(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()), 0, 1, 20);
                break;
            }
            case THEONERING:{
                item = new TheOneRing(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()), 0, 0, 0);
                break;
            }
            default:
            break;
        }
        unequippedInventoryItems.add(item);
        
        return item;
    }
    
    
    
    /**
     * remove an item by x,y coordinates
     * @param x x coordinate from 0 to width-1
     * @param y y coordinate from 0 to height-1
     */
    public void removeUnequippedInventoryItemByCoordinates(int x, int y){
        Entity item = getUnequippedInventoryItemEntityByCoordinates(x, y);
        removeUnequippedInventoryItem(item);
    }
    
    /**
     * run moves which occur with every tick without needing to spawn anything immediately
     */
    public void runTickMoves(){

        character.moveDownPath();
        int rd = new Random().nextInt(100);
        if (rd <= 1) {
            addUnequippedItem(ITEMS_TYPE.SWORD);   
        } else if (rd > 1 && rd <= 2) {
            addUnequippedItem(ITEMS_TYPE.STAKE);  
        } else if (rd > 2 && rd <= 3) {
            addUnequippedItem(ITEMS_TYPE.STAFF);  
        } else if (rd > 3 && rd <= 4) {
            addUnequippedItem(ITEMS_TYPE.ARMOUR);  
        } else if (rd > 4 && rd <= 5) {
            addUnequippedItem(ITEMS_TYPE.SHIELD);  
        } else if (rd > 5 && rd <= 6) {
            addUnequippedItem(ITEMS_TYPE.HELMET);  
        } else if (rd > 6 && rd <= 7) {
            loadCard(CARDS_TYPE.VAMPIRECASTLE);
        } else if (rd > 7 && rd <= 8) {
            loadCard(CARDS_TYPE.ZOMBIEPIT);
        } else if (rd > 8 && rd <= 9) {
            loadCard(CARDS_TYPE.TOWER);
        } else if (rd > 9 && rd <= 10) {
            loadCard(CARDS_TYPE.TRAP);
        } else if (rd > 10 && rd <= 11) {
            loadCard(CARDS_TYPE.BARRACK);
        } else if (rd > 11 && rd <= 12) {
            loadCard(CARDS_TYPE.VILLAGE);
        } else if (rd > 12 && rd <= 13) {
            loadCard(CARDS_TYPE.CAMPFIRE);
            /*
        } else if (rd > 12 && rd <= 15) {
            addUnequippedItem(ITEMS_TYPE.HEALTHPOTION);  
        } else if (rd > 29 && rd <= 31) {
            // gold
        } else if (rd > 31 && rd <= 33) {
            // exp
            */
        } else if (rd > 13 && rd <= 100) {
            // nothing
        }
        moveBasicEnemies();
    }
    
    /**
     * remove an item from the unequipped inventory
     * @param item item to be removed
     */
    private void removeUnequippedInventoryItem(Entity item){
        item.destroy();
        unequippedInventoryItems.remove(item);
    }
    
    /**
     * return an unequipped inventory item by x and y coordinates
     * assumes that no 2 unequipped inventory items share x and y coordinates
     * @param x x index from 0 to width-1
     * @param y y index from 0 to height-1
     * @return unequipped inventory item at the input position
     */
    private Item getUnequippedInventoryItemEntityByCoordinates(int x, int y){
        for (Item e: unequippedInventoryItems){
            if ((e.getX() == x) && (e.getY() == y)){
                return e;
            }
        }
        return null;
    }
    
    /**
     * remove item at a particular index in the unequipped inventory items list (this is ordered based on age in the starter code)
     * @param index index from 0 to length-1
     */
    private void removeItemByPositionInUnequippedInventoryItems(int index){
        Entity item = unequippedInventoryItems.get(index);
        item.destroy();
        unequippedInventoryItems.remove(index);
    }
    
    /**
     * get the first pair of x,y coordinates which don't have any items in it in the unequipped inventory
     * @return x,y coordinate pair
     */
    private Pair<Integer, Integer> getFirstAvailableSlotForItem(){
        // first available slot for an item...
        // IMPORTANT - have to check by y then x, since trying to find first available slot defined by looking row by row
        for (int y=0; y<unequippedInventoryHeight; y++){
            for (int x=0; x<unequippedInventoryWidth; x++){
                if (getUnequippedInventoryItemEntityByCoordinates(x, y) == null){
                    return new Pair<Integer, Integer>(x, y);
                }
            }
        }
        return null;
    }
    
    /**
     * shift card coordinates down starting from x coordinate
     * @param x x coordinate which can range from 0 to width-1
     */
    private void shiftCardsDownFromXCoordinate(int x){
        for (Card c: cardEntities){
            if (c.getX() >= x){
                c.x().set(c.getX()-1);
            }
        }
    }
    
    /**
     * move all enemies
     */
    private void moveBasicEnemies() {
        // TODO = expand to more types of enemy
        for (BasicEnemy e: enemies){
            e.move();
        }
    }
    
    /**
     * get a randomly generated position which could be used to spawn an enemy
     * @return null if random choice is that wont be spawning an enemy or it isn't possible, or random coordinate pair if should go ahead
     */
    private Pair<Integer, Integer> possiblyGetBasicEnemySpawnPosition(){
        // TODO = modify this
        
        // has a chance spawning a basic enemy on a tile the character isn't on or immediately before or after (currently space required = 2)...
        Random rand = new Random();
        int choice = rand.nextInt(2); // TODO = change based on spec... currently low value for dev purposes...
        // TODO = change based on spec
        if ((choice == 0) && (enemies.size() < 2)){
            List<Pair<Integer, Integer>> orderedPathSpawnCandidates = new ArrayList<>();
            int indexPosition = orderedPath.indexOf(new Pair<Integer, Integer>(character.getX(), character.getY()));
            // inclusive start and exclusive end of range of positions not allowed
            int startNotAllowed = (indexPosition - 2 + orderedPath.size())%orderedPath.size();
            int endNotAllowed = (indexPosition + 3)%orderedPath.size();
            // note terminating condition has to be != rather than < since wrap around...
            for (int i=endNotAllowed; i!=startNotAllowed; i=(i+1)%orderedPath.size()){
                orderedPathSpawnCandidates.add(orderedPath.get(i));
            }
            
            // choose random choice
            Pair<Integer, Integer> spawnPosition = orderedPathSpawnCandidates.get(rand.nextInt(orderedPathSpawnCandidates.size()));
            
            return spawnPosition;
        }
        return null;
    }
    
    /**
     * remove a card by its x, y coordinates
     * @param cardNodeX x index from 0 to width-1 of card to be removed
     * @param cardNodeY y index from 0 to height-1 of card to be removed
     * @param buildingNodeX x index from 0 to width-1 of building to be added
     * @param buildingNodeY y index from 0 to height-1 of building to be added
     */
    public Building convertCardToBuildingByCoordinates(int cardNodeX, int cardNodeY, int buildingNodeX, int buildingNodeY) {
        // start by getting card
        Card card = null;
        for (Card c: cardEntities){
            if ((c.getX() == cardNodeX) && (c.getY() == cardNodeY)){
                card = c;
                break;
            }
        }
        // now spawn building
        Building newBuilding = null;
        if(card instanceof TowerCard){
            newBuilding = new TowerBuilding(new SimpleIntegerProperty(buildingNodeX), new SimpleIntegerProperty(buildingNodeY));
        }
        else if(card instanceof ZombiePitCard){
            newBuilding = new ZombiePitBuilding(new SimpleIntegerProperty(buildingNodeX), new SimpleIntegerProperty(buildingNodeY));
        }
        else if(card instanceof VampireCastleCard){
            newBuilding = new VampireCastleBuilding(new SimpleIntegerProperty(buildingNodeX), new SimpleIntegerProperty(buildingNodeY));
        }
        else if(card instanceof BarrackCard){
            newBuilding = new BarrackBuilding(new SimpleIntegerProperty(buildingNodeX), new SimpleIntegerProperty(buildingNodeY));
        }
        else if(card instanceof VillageCard){
            newBuilding = new VillageBuilding(new SimpleIntegerProperty(buildingNodeX), new SimpleIntegerProperty(buildingNodeY));
        }
        else if(card instanceof TrapCard){
            newBuilding = new TrapBuilding(new SimpleIntegerProperty(buildingNodeX), new SimpleIntegerProperty(buildingNodeY));
        }
        else if(card instanceof CampfireCard){
            newBuilding = new CampfireBuilding(new SimpleIntegerProperty(buildingNodeX), new SimpleIntegerProperty(buildingNodeY));
        }
        
        buildingEntities.add(newBuilding);
        
        // destroy the card
        card.destroy();
        cardEntities.remove(card);
        shiftCardsDownFromXCoordinate(cardNodeX);
        
        return newBuilding;
    }
    /**
     * check whether the position is in the path
     * @param x x of the position
     * @param y y of the position
     * @return the result
     */
    public boolean checkInPath(Integer x, Integer y){
        boolean ret = false;
        for(Pair<Integer, Integer> pair : orderedPath){
            if(pair.getValue(0) == x && pair.getValue(1) == y){
                ret = true;
                break;
            }
        }
        return ret;
    }
    
    /**
     * check whether the position is adjacent to the path
     * @param x x of the position
     * @param y y of the position
     * @return the result
     */
    public boolean checkAdjacentPath(Integer x, Integer y){
        if(checkInPath(x, y)) return false;
        boolean ret = false;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        for(Pair<Integer, Integer> pair : orderedPath){
            int mx = (Integer)pair.getValue(0);
            int my = (Integer)pair.getValue(1);
            for(int i = 0; i < 4; i++){
                if(mx+dx[i] == x && my+dy[i] == y){
                    ret = true;
                    break;
                }
            }
        }
        return ret;
    }
    
    
    /**
     * getter of unequippedInventoryItems
     * @return unequippedInventoryItems
     */
    public List<Item> getUnequippedInventoryItems(){
        return unequippedInventoryItems;
    }
    
    /**
     * spawn a zombie
     */
    public BasicEnemy spawnAZombie(int x, int y){
        
        // find a adjacent position in the path
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        boolean isFind = false;
        for(Pair<Integer, Integer> pair : orderedPath){
            int mx = (Integer)pair.getValue(0);
            int my = (Integer)pair.getValue(1);
            for(int i = 0; i < 4; i++){
                if(x+dx[i] == mx && y+dy[i] == my){
                    x = mx;
                    y = my;
                    isFind = true;
                    break;
                }
            }
            if(isFind) break;
        }
        
        // spawn a zombie in the position (x,y)
        Pair<Integer, Integer> pos = new Pair<>(x, y);
        int indexInPath = orderedPath.indexOf(pos);
        Zombie zombie= new Zombie(new PathPosition(indexInPath, orderedPath));
        enemies.add(zombie);
        return zombie;
    }
    
    /**
     * spawn a vampire
     */
    public Vampire spawnAVampire(int x, int y){
        // find a adjacent position in the path
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        boolean isFind = false;
        for(Pair<Integer, Integer> pair : orderedPath){
            int mx = (Integer)pair.getValue(0);
            int my = (Integer)pair.getValue(1);
            for(int i = 0; i < 4; i++){
                if(x+dx[i] == mx && y+dy[i] == my){
                    x = mx;
                    y = my;
                    isFind = true;
                    break;
                }
            }
            if(isFind) break;
        }
        
        // spawn a zombie in the position (x,y)
        Pair<Integer, Integer> pos = new Pair<>(x, y);
        int indexInPath = orderedPath.indexOf(pos);
        Vampire vampire= new Vampire(new PathPosition(indexInPath, orderedPath));
        enemies.add(vampire);
        return vampire;
    }
    
    /**
     * Generate enemies according to building characteristics
     */
    public List<BasicEnemy> spawnEnemiesByBuilding(){
        List<BasicEnemy> retList = new ArrayList<>();
        if(buildingEntities == null) return retList;
        for(Building building : buildingEntities){
            if(building instanceof ZombiePitBuilding){
                List<BasicEnemy> tmp = ((ZombiePitBuilding)building).spawnZombie(this);
                if(tmp.size() > 0){
                    retList.addAll(tmp);
                }
            }
            else if(building instanceof VampireCastleBuilding){
                List<BasicEnemy> tmp = ((VampireCastleBuilding)building).spawnVampires(this);
                if(tmp.size() > 0){
                    retList.addAll(tmp);
                }
            }
        }
        return retList;
    }
    
    public void addRoundsNum(){
        roundsNum++;
    }
    
    public int getRoundsNum(){
        return roundsNum;
    }
    
    public Item getLastUnequippedInventoryItem() {
        if (unequippedInventoryItems.size() > 0) {
            return unequippedInventoryItems.get(unequippedInventoryItems.size() - 1);
        }
        return null;
    }

    public Card getLastCardEntity() {
        if (cardEntities.size() > 0) {
            return cardEntities.get(cardEntities.size() - 1);
        }
        return null;
    }

    public Character getCharacter(){
        return character;
    }

    public List<BasicEnemy> buildingFunction(){
        List<BasicEnemy>  deadEnemies = new ArrayList<>();
        if(buildingEntities == null || buildingEntities.isEmpty()) return deadEnemies;
        boolean hasAttackEnhance = false;
        for(Building building : buildingEntities){

            // tower
            if(building instanceof TowerBuilding){
                List<BasicEnemy> tmpEnemies = ((TowerBuilding)building).work(enemies);
                for (BasicEnemy e: tmpEnemies){
                    killEnemy(e);
                }
                deadEnemies.addAll(tmpEnemies);
            }

            // villiage
            if(building instanceof VillageBuilding){
                ((VillageBuilding)building).work(character);
            }

            // campfire
            if(building instanceof CampfireBuilding){
                hasAttackEnhance = ((CampfireBuilding)building).work(character);
            }

            // trap
            if(building instanceof TrapBuilding){
                List<BasicEnemy> tmpEnemies = ((TrapBuilding)building).work(enemies);
                for (BasicEnemy e: tmpEnemies){
                    killEnemy(e);
                }
                deadEnemies.addAll(tmpEnemies);
            }

            // barrack
            if(building instanceof BarrackBuilding){
                ((BarrackBuilding)building).work(character);
            }
        }
        
        if(hasAttackEnhance){
            character.setAttackEnhance(true);
        }

        return deadEnemies;
    }
        
    public Item GetEquippedFromUnequippedByCoordinates(int srcX, int srcY, int destX, int destY) {
        Item item = getUnequippedInventoryItemEntityByCoordinates(srcX, srcY);
        if (destX == 0 & destY ==0) {
            if (item instanceof Sword || item instanceof Stake || item instanceof Staff) {
                removeUnequippedInventoryItemByCoordinates(srcX, srcY);
                item.setPosition(destX, destY);          
            } else {return null;}
        } else if (destX == 1 && destY == 0) {
            if (item instanceof Armour || item instanceof Helmet) {
                removeUnequippedInventoryItemByCoordinates(srcX, srcY);
                item.setPosition(destX, destY);
            } else {return null;}
        } else if (destX == 2 && destY == 0) {
            if (item instanceof Shield) {
                removeUnequippedInventoryItemByCoordinates(srcX, srcY);
                item.setPosition(destX, destY);
            } else {return null;} 
        }
        return item;  
    }

    public void setCharacterEquipment(Item item) {
        int basicDamage = 4;
        if (item instanceof Sword) {
            character.setAggressivity(basicDamage + item.getDamageValue());
            character.setWeapon(item);
        } else if (item instanceof Stake) {
            character.setAggressivity(basicDamage + item.getDamageValue());
            character.setWeapon(item);
        } else if (item instanceof Staff) {
            character.setAggressivity(basicDamage + item.getDamageValue());
            character.setWeapon(item);
        } else if (item instanceof Armour) {
            character.setDefense(item.getDefenseValue());
            character.setArmour(item);
        } else if (item instanceof Helmet) {
            character.setDefense(item.getDefenseValue());
            character.setArmour(item);
        } else if (item instanceof Shield) {
            character.setShield(item);
        }
    }
}
