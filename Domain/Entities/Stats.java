//Purpose: to initialize Player, Enemies, and Boss with base stats.
package Domain.Entities;

public class Stats {
  //basic game stats
  public int currentHp;
  public int maxHp;
  public int attack;
  public int defense;
  public int speed;
  public int lvl;
	public int xp;
	public int gold;


  //constructor
  public Stats(int mHP, int a, int d, int s, int l, int x, int g) {
    this.maxHp = mHP;
    this.currentHp = this.maxHp;
    this.attack = a;
    this.defense = d;
    this.speed = s;
    this.lvl = l;
    this.xp = x;
    this.gold = g;
  }

  public String toString() {
    return "HP: "       + HpRatioToString()   + " | " +
           "Attack: "   + this.attack         + " | " +
           "Defense: "  + this.defense        + " | " +
           "Speed: "    + this.speed          + " | " +
           "Level: "    + this.lvl            + " | " +
           "EXP: "      + this.xp             + " | " +
           "GOLD: "     + this.gold;
  }
  public String HpRatioToString()    { return currentHp + "/" + maxHp; }

}
