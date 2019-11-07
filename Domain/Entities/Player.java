package Domain.Entities;

import Domain.Entities.Inventory;

public class Player {

	public String name;
	public Inventory inventory;
	public Stats stats; //universal: hp, at, df, spd, lvl, xp, gold


	//Quickly generate a player with base stats.
	public Player() {
		name = "Default";
		inventory = new Inventory();
		stats = new Stats(10, 5, 5, 5, 1, 0 , 0);
	}

	//full player toString
	public String toString() {
		String s = "";
		s += "[ Player : ";
		s += stats.toString();
		s += " ] " +  "\n" + inventory.toString();
		return s;
	}

}
