/* WHAT DOES "Player" DO?
 * Traverse the map (4 way linked list)
 * Trigger events on the Map
 * Save progress (level/exp/items)
 * Continue traveling from where they left off (if saved)
 * Detect danger when near ("sense danger in nearby room...")
 * Has inventory
 */

public class Player {

	//-------Player Qualities-------\\
	//Instead of making all these public, find out how to give Game.java
	//exclusive access to player and map.
	public int currentHp;
	public int maxHp;
	public int lvl;
	public int attack;
	public int xp;
	public int gold;
	public int[] inventory = new int[5];	//items stored here.
	public int[] equipment = new int[2];	//equipment stored here.

	public Player() {
		this.maxHp = 10;
		this.currentHp = this.maxHp;
		this.lvl = 1;
		this.attack = 5;
		this.xp = 0;
		this.gold = 0;
	}


	//-------Setters-------\\
	public void setCurrentHp(int newHp)			{ currentHp = newHp; 	}
	public void setMaxHp(int newHp)       	{ maxHp = newHp;      }
	public void setLvl(int newLvl)       		{ lvl = newLvl;       }
	public void setAttack(int newAtt)     	{ attack = newAtt;    }
	public void setXp(int newXp)          	{ xp = newXp;         }
	public void setGold(int newGold)      	{ gold = newGold;     }
	public void setInventory(int[] param) 	{ inventory = param;  }
	public void setEquipment(int[] param) 	{ equipment = param;  }

	//-------Getters-------\\
	public int getCurrentHp()			{ return currentHp; }
	public int getMaxHp()       	{ return maxHp;     }
	public int getLvl()         	{ return lvl;       }
	public int getAttack()     		{ return attack;    }
	public int getXp()          	{ return xp;        }
	public int getGold()       	 	{ return gold;      }
	public int[] getInventory() 	{ return inventory; }
	public int[] getEquipment() 	{ return equipment; }

	//-------Interaction with Inventory and Equipment-------\\

	//Prints equipment for console reading.
	public void printEquipment() {
		for(int i = 0; i < this.equipment.length; i++) {
			System.out.print(this.equipment[i] + " ");
		}
		System.out.println("");
	}

	//Prints inventory for console reading
	public void printInventory() {
		for(int i = 0; i < this.inventory.length; i++) {
			System.out.print(this.inventory[i] + " ");
		}
		System.out.println("");
	}

	//Replaces only 0 with new item.
	//Returns: item when inserted OR -1 when item couldn't fit.
	public int addItem(int item) {
		int inventoryLength = this.inventory.length;
		for(int i = 0; i < inventoryLength; i++) {
			if(this.inventory[i] == 0) {
				this.inventory[i] = item;
				return 1;
			}
		}
		return -1;
	}

	//Replaces item match with 0.
	//Returns: item when deleted OR -1 when item not found.
	public int deleteItem(int item) {
		int inventoryLength = this.inventory.length;
		for(int i = 0; i < inventoryLength; i++) {
			if(this.inventory[i] == item) {
				this.inventory[i] = 0;
				return item;
			}
		}
		return -1;
	}

	//Searches inventory and equips sword or armor (item # 3 or 4)
	//Returns -1 when failed to equip, -item when item already equipped.
	public int equipItem(int item) {
		int inventoryLength = this.inventory.length;
		//Find item we want to equip.
		for(int i = 0; i < inventoryLength; i++) {
			//Is the item in our inventory?
			if(this.inventory[i] == item) {
				//Is the item # 3 (sword)?
				if(this.inventory[i] == 3) {
					//Do we already have the sword equipped?
					if(this.equipment[0] == 3) { return -3; }
					//If the above is all good, then equip.
					else {
						this.equipment[0] = 3;
						this.inventory[i] = 0;
						//Return what you equipped.
						return 3;
					}

				}
				//Is the item # 4 (armor)?
				else if(this.inventory[i] == 4) {
					//Do we already have the armor equipped?
					if(this.equipment[1] == 4) { return -4; }
					//If the above is all good, then equip.
					else {
						this.equipment[1] = 4;
						this.inventory[i] = 0;
						//Return what you equipped.
						return 4;
					}


				}
			}
		}
		//if we got this far, nothing could be equipped.
		return -1;
	}

	//Checks equipment and places given item in inventory. Null if full inven.
	//Returns -1 when unequip failed OR item when succeeded
	public int unequipItem(int item) {
		//First: is there inven space to unequip?
		if(this.addItem(item) == -1) { return -1; }

		//Remove from equipment.
	  else if(this.equipment[0] == item) {
			this.equipment[0] = 0;
			return item;
	  }
		//Remove from equipment.
	  else if(this.equipment[1] == item) {
			this.equipment[1] = 0;
			return item;
	  }
	  else {
	    return -1;
	  }
	}

}
