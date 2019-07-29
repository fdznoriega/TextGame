package Domain.Entities;

public class Player {

	public String name;
	public Stats stats; //hp, at, de, sp
	public int lvl;
	public int xp;
	public int gold;
	public int[] inventory = new int[5];	//items stored here.
	public int[] equipment = new int[2];	//equipment stored here.

	//Quickly generate a player with base stats.
	public Player() {
		name = "Default";
		stats = new Stats(10, 5, 5, 5);
		this.lvl = 1;
		this.xp = 0;
		this.gold = 0;
	}

	//string of players stats
	public String statsToString() {
		String name = "[ Player: ";
		String pHp = "HP: " + this.stats.HpRatioToString() + " | ";
		String att = "ATT: " + this.stats.attack + " ";
		String def = "DEF: " + this.stats.defense + " | ";
		String xp = "EXP: " + this.xp + " | ";
		String gold = "G: " + this.gold + " ] ";
		return name + pHp + att + def + xp + gold;
	}

	//string of player inventory
	public String inventoryToString() {
		String inven = "[ Inventory: ";
		for(int i = 0; i < this.inventory.length; i++) {
			inven += this.inventory[i] + ", ";
		}
		inven += " ] ";
		return inven;
	}

	//string of player equipment
	public String equipmentToString() {
		String equ = "[ Equipment: ";
		for(int i = 0; i < this.equipment.length; i++) {
			equ += this.equipment[i] + ", ";
		}
		equ += " ] ";
		return equ;
	}

	//full player toString
	public String toString() {
		return statsToString() + inventoryToString() + equipmentToString();
	}

}
