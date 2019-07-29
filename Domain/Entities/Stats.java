//Purpose: to initialize Player, Enemies, and Boss with base stats.
package Domain.Entities;

public class Stats {
  //basic game stats
  public int currentHp;
  public int maxHp;
  public int attack;
  public int defense;
  public int speed;
  //constructor
  public Stats(int mHP, int a, int d, int s) {
    this.maxHp = mHP;
    this.currentHp = this.maxHp;
    this.attack = a;
    this.defense = d;
    this.speed = s;
  }

  //stat manipulation
  public String ToString() {
    return "HP: " + HpRatioToString() + " | " +
           "Attack: " + this.attack + " | " +
           "Defense: " + this.defense + " | " +
           "Speed: " + this.speed;
  }
  public String HpRatioToString()    { return currentHp + "/" + maxHp; }

}
