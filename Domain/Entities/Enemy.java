package Domain.Entities;

import Domain.Entities.Stats;

public class Enemy {
  public String name;
  public int id;
  public Stats stats;


  public String statsToString() {
		String name = "[ " + this.name + " | ";
    String id = "ID: " + this.id + " | ";
		String pHp = "HP: " + this.stats.HpRatioToString() + " | ";
		String att = "ATT: " + this.stats.attack + " | ";
		String def = "DEF: " + this.stats.defense + " | ";
		String spd = "SPD: " + this.stats.speed + " ] ";
		return name + pHp + att + def + spd;
	}
}
