## ASSUMPTIONS
*   The game supports **ONE** player at most.
*   Only **ONE** character is provided in the game.
*   At the start of the game, the character uses their **FISTS** to fight the enemies (without equipment).
*   The initial map is fixed, consisting of path tiles, non-path tiles, and **ONE** Hero castle.
*   The map has two slugs moving randomly at initial map.
*   The character can only move clockwise through the path.
*   Every **20** loops, the number of slug refreshes is increased by **ONE**.
*   Character moving stops when encounter enemies or arrive the Hero Castle.
*   The random movement of the enemy includes clockwise and anti-clockwise.
<br/><br/><p>
*	The attributes of character and enemies are listed below:
</p>

|                 | Health point | Damage value | Defense | Supportradius | Battle radius | Gold achieved by defeating | EXP |
| :-------------: | :----------: | :----------: | :-----: | :-----------: | :-----------: | :------------------------: | :-: |
|    Character	  |      100	 |       4	    |    0	  |       -	      |       -	      |               -	           |  -  |
|      Slug       |      12	     |       4	    |    0	  |       1	      |       1	      |               1	           |  2  |
|     Zombie      |      18	     |       8	    |    0	  |       0	      |       2	      |               3	           |  5  |
|     Vampire     |	     32      |       15	    |    0	  |       3	      |       2	      |               5	           |  8  |
| Allied soldiers |	     15	     |       5	    |    0	  |       -	      |       -	      |               -	           |  -  |


<br/><br/><p>
*   Property and price of equipment are listed below:
</p>

|               |      Damage value      | Defense | Price |
| :-----------: | :--------------------: | :-----: | :---: |
|    Sword	    |            6	         |    -	   |   10  |
|    Stake	    | 4 (but 12 for vampire) |    -	   |   10  |
|    Staff	    |            2	         |    -	   |   15  |
|    Anduil	    |   9 (but 27 for boss)	 |    -	   |   30  |
|    Armour	    |            -	         |    3	   |   20  |
|    Shield	    |            -	         |    -	   |   20  |
|   TreeStump   |            -	         |    -	   |   30  |
|    Helmet	    |            -	         |    1	   |   20  |
| Health potion |            -	         |    -	   |   10  |

<br/><br/><p>
*	Refresh probability of items and cards are list below:
</p>

|	                  | Loot from enemies | Pick up from tiles |
| :-----------------: | :---------------: | :----------------: |
| Vampire castle card |	        1/7	      |         1%         |
|   Zombie pit card   |	        1/7	      |         1%         |
|     Tower card      |	        1/7	      |         1%         |
|    Village card     |		    1/7		  |         1%         |
|    Barracks card    |		    1/7	      |         1%         |
|      Trap card      |		    1/7	      |         1%	       |
|   Camp fire card    |		    1/7	      |         1%	       |	

|	                  | Loot from enemies | Pick up from tiles | Oldest card replaced |
| :-----------------: | :---------------: | :----------------: | :------------------: |
|    Health potion    |		    10%	      |         3%	       |	       1%	      |
|        Sword        |		    20%       |         1%	       |	       1%	      |
|        Stake        |		    15%	      |         1%	       |	       1%	      |
|        Staff 	      | 		10%	      |         1%	       |	       1%	      |
|        Armour       |		    10%	      |         1%	       |	       1%         |
|        Shield       |		    15%	      |         1%	       |	       1%	      |
|        Helmet       |		    15%	      |         1%	       |	       1%	      |
|    The one ring     |		    5%        |         -	       |	       -		  |
|         gold        |		   100%       |         3%	       |	      100%		  |
|         EXP         |		   100%       |         3%	       |	      100%		  |



<br/><br/>
*   When selling equipment at Hero's Castle, the character can only get **40%** of gold when normally purchasing.
*   When the oldest equipment is replaced in the unequipped inventory, the character can only get **20%** of gold when normally purchasing.
*   When the oldest card is replaced, the character can get **1-5** golds.
*	When the oldest card/equipment is replaced, the character can get **2** points of EXP.
*	When the character picks up the gold spawns randomly on path tiles, the overall gold amount increases **2**.
*	When the character picks up the EXP spawns randomly on path tiles, the overall EXP amount increases **2**.
*	Rare items cannot be bought or traded in Hero castle.
*	One Health potion can refill **50** character HP value.
*	Enemies cannot use weapons, gold or health potions.
*	Allied soldiers cannot use weapons, gold or health potions.
*	The maximum number of allied solvers is **5**.
*	When a new Allied soldier is added, the Allied soldier with the **least** value of HP will be replaced.
*	The vampire castle and zombie pit produce **multiple** vampires and zombies respectively each time they are spawned.
*	Character Equipped inventory only supports **ONE** weapon, **ONE** armor, **ONE** helmet and **ONE** shield.
    - For the weapon slot, any hand-held melee weapon can be placed in.
    - For the helmet slot, any headgear can be placed inside it.
    - For the shield slot, any hand-held defense item can be placed inside it.
    - For the armor slot, any defensive device worn on the body can be placed in it.
*	The size of character unequipped inventory is **16**.
*	All newly acquired equipment will go to the unequipped inventory first.
*	When the equipment in the unequipped inventory reaches the upper limit, the oldest equipment will be replaced.
*	The size of the character card bar is **8**.
*	When the card in the card bar reaches the upper limit, the oldest card will be replaced.
*	The real damage = damage value **-** defense power
*   In the game, battle in round, when one unit's HP value is less than or equal to 0, it is judged as defeat.
*	When fighting, the enemy attacks **first** then character (zombies attack later due to their slow speed).
*   The character and alied soldiers can fight with more than one enemy at the same time, and both sides **randomly** choose the target.
*	When the character enters the enemies' battle radius, it will start fighting automatically.
*	When a character battles with an enemy within a vampire's support radius, the vampire joins the battle.
*	Incite defection
    - If encountering one enemy and trance the enemy, the battle will be awarded as victory automatically.
    - If encountering more than one enemy, the tranced enemy will fight alongside the Character and attack other enemies as an allied soldier. 
    - The attacked enemy will end the trance during the fight when one of the enemies is defeated.
*	After **50** loops, there is a small probability of looting advanced equipment from vampires.
*	After **80** loops, the game will generate advanced enemies. After killing, the character has a 100% chance to get advanced equipment.
*	Click "Exit to main menu" during the game will to save the game automatically and return to the main menu.
*   When the character sells items in the store, it can only be sold as items in the unequipped inventory.
*   Helmet can reduce **5** damage value for enemy, reduce **2** damage value for character.
*   Vampire hold **30%** chance critical hit, critical hit value between **1-10**.
*   Zombie hold **30%** chance infecte allied soilder.