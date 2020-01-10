package Domain.Interactors;

//import ...
import Domain.Entities.Player;
import Domain.Interactors.InventoryInteractor;
import Domain.Interactors.StatsInteractor;
import Domain.Entities.Stats;
import Domain.Entities.Item;

//player has stats and inventory which are manipulated by other classes
//pInteractor holds these other interactors and is a "manager"
public class PlayerInteractor {

  public Player p;
  public InventoryInteractor invenInteractor;
  public StatsInteractor statInteractor;

  public PlayerInteractor(Player np) {
    p = np;
    invenInteractor = new InventoryInteractor();
    statInteractor = new StatsInteractor();
    invenInteractor.inven = p.inventory;
    statInteractor.s = p.stats;
  }

  // we want to be able to access inventory and stat functions quickly,
  // so lets make helper functions to guide the code in the right direction
  // === before: pInteractor.statInteractor.setMaxHp(num)
  // === after: pInteractor.setMaxHp(num)

  // Helper Stats Methods ...
  public void setStats(Stats s) {
    this.statInteractor.setStats(s);
  }

  public void setCurrentHp(int cHp) {
    this.statInteractor.setCurrentHp(cHp);
  }

  public void setMaxHp(int mHp) {
    this.statInteractor.setMaxHp(mHp);
  }

  public void setAttack(int att) {
    this.statInteractor.setAttack(att);
  }

  public void setDefense(int def) {
    this.statInteractor.setDefense(def);
  }

  public void setSpeed(int spd) {
    this.statInteractor.setSpeed(spd);
  }

  public void setXp(int x) {
    this.statInteractor.setXp(x);
  }

  public void setLvl(int l) {
    this.statInteractor.setLvl(l);
  }

  public void setGold(int g) {
    this.statInteractor.setGold(g);
  }

  // Helper Inventory Methods ...
  public void insertItem(Item item) {
    this.invenInteractor.insertItem(item);
  }
  public void equipItem(Item item) {
    this.invenInteractor.equipItem(item);
  }
  public void removeItem(Item item) {
    this.invenInteractor.removeItem(item);
  }
  public void unequipItem(Item item) {
    this.invenInteractor.unequipItem(item);
  }
  public void clearEquipment() {
    this.invenInteractor.clearEquipment();
  }



}
