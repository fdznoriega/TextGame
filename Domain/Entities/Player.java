package Domain.Entities;

import Domain.Entities.Inventory;

public class Player {

	public String name;
	public Inventory inventory; //bag and equipment
	public Stats stats; //hp, at, de, sp
	public int lvl;
	public int xp;
	public int gold;


	//Quickly generate a player with base stats.
	public Player() {
		name = "Default";
		inventory = new Inventory();
		stats = new Stats(10, 5, 5, 5);
		this.lvl = 1;
		this.xp = 0;
		this.gold = 0;
	}

	//string of players stats
	public String statsToString() {
		String name = "[ Player: ";
		String pHp = "HP: " + this.stats.HpRatioToString() + " | ";
		String att = "ATT: " + this.stats.attack + " | ";
		String def = "DEF: " + this.stats.defense + " | ";
		String spd = "SPD: " + this.stats.speed + " | ";
		String xp = "EXP: " + this.xp + " | ";
		String gold = "G: " + this.gold + " ] ";
		return name + pHp + att + def + spd + xp + gold;
	}


	//full player toString
	public String toString() {
		return statsToString() + "\n" + inventory.toString();
	}

}
