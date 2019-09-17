package Domain.Entities;

import Domain.Entities.Inventory;

public class Player {

	public String name;
	public Inventory inventory; //bag and equipment
	public Stats stats; //universal: hp, at, df, spd, lvl, xp, gold


	//Quickly generate a player with base stats.
	public Player() {
		name = "Default";
		inventory = new Inventory();
		stats = new Stats(10, 5, 5, 5, 1, 0 , 0);
	}

	//string of players stats
	public String statsToString() {
		String name = "[ Player: ";
		String pHp = "HP: " + this.stats.HpRatioToString() + " | ";
		String lvl = "LVL: " + this.stats.lvl + " | ";
		String xp = "EXP: " + this.stats.xp + " | ";
		String att = "ATT: " + this.stats.attack + " | ";
		String def = "DEF: " + this.stats.defense + " | ";
		String spd = "SPD: " + this.stats.speed + " | ";
		String gold = "G: " + this.stats.gold + " ] ";
		return name + pHp + lvl + xp + att + def + spd + xp + gold;
	}

	//full player toString
	public String toString() {
		return statsToString() + "\n" + inventory.toString();
	}

}
