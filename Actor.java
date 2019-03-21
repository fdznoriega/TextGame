/* What is an Actor?
 * Object that has base stats.
*/
public class Actor {

  //Actor has basic stats the game will use.
  public String name;
  public int currentHp;
  public int maxHp;
  public int attack;
  public int defense;

  //Actor(maxHp, attack, defense)
  public Actor(String n, int mHP, int attack, int defense) {
    name = n;
    this.maxHp = mHP;
    this.currentHp = this.maxHp;
    this.attack = attack;
    this.defense = defense;
  }

  public Actor() {
    this.maxHp = 10;
		this.currentHp = this.maxHp;
		this.attack = 5;
		this.defense = 1;
  }

  //-------Getters-------\\
	public int getCurrentHp()			{ return currentHp; }
	public int getMaxHp()       	{ return maxHp;     }
	public int getAttack()     		{ return attack;    }
	public int getDefense()       { return defense; }

  //-------Setters-------\\
  public void setCurrentHp(int newHp)			{ currentHp = newHp; 	}
	public void setMaxHp(int newHp)       	{ maxHp = newHp;      }
  public void setAttack(int newAtt)     	{ attack = newAtt;    }
  public void setDefense(int newDef)      { defense = newDef;   }




}
