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
  private int hp;
  private int lvl;
  private int attack;
  private int xp;
  private int gold;
  private int[] inventory = new int[5]; //items stored here.
  private int[] equipment = new int[2];  //equipment stored here.

  public Player() {
    this.hp = 10;
    this.lvl = 1;
    this.attack = 5;
    this.xp = 0;
    this.gold = 0;
  }


  //-------Getters-------\\
  public void setHp(int newHp)          { hp = newHp;         }
  public void setLvl(int newLvl)        { lvl = newLvl;       }
  public void setAttack(int newAtt)     { attack = newAtt;    }
  public void setXp(int newXp)          { xp = newXp;         }
  public void setGold(int newGold)      { gold = newGold;     }
  public void setInventory(int[] param) { inventory = param;  }
  public void setEquipment(int[] param) { equipment = param;  }

  //-------Setters-------\\
  public int getHp()          { return hp;        }
  public int getLvl()         { return lvl;       }
  public int getAttack()      { return attack;    }
  public int getXp()          { return xp;        }
  public int setGold()        { return gold;      }
  public int[] getInventory() { return inventory; }
  public int[] getEquipment() { return equipment; }

  //-------Interaction with Inventory and Equipment-------\\

  //Replaces only 0 with new item.
  //Returns: item when inserted OR -1 when item couldn't fit.
  public int addItem(int item) {
    int inventoryLength = this.inventory.length;
    for(int i = 0; i < inventoryLength; i++) {
      if(this.inventory[i] == 0) {
        this.inventory[i] = item;
        return item;
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

  public void equipItem(int item) {
    int inventoryLength = this.inventory.length;
    int equipmentLength = this.equipment.length;
  }

}
