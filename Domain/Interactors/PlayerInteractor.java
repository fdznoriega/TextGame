package Domain.Interactors;

//import ...
import Domain.Entities.Player;
import Domain.Interfaces.IPlayerInteractorOutput;
import Domain.Interactors.InventoryInteractor;
import Domain.Interactors.StatsInteractor;
import Domain.Entities.Stats;
import Domain.Entities.Item;

//player has stats and inventory which are manipulated by other classes
//pInteractor holds these other interactors and is a "manager"
public class PlayerInteractor {

  public Player player;
  public IPlayerInteractorOutput output;
  public InventoryInteractor invenInteractor;
  public StatsInteractor statsInteractor;

  // connect all components in the constructor?
  public PlayerInteractor(Player playerIn) {
    this.player = playerIn;
    //construct a inventory interactor
    invenInteractor = new InventoryInteractor();
    invenInteractor.inven = player.inventory;
    invenInteractor.invenInteractorOut = this.output;
    statsInteractor = new StatsInteractor();
    statsInteractor.s = player.stats;
    statsInteractor.out =this.output;
  }

  // we want to be able to access inventory and stat functions quickly,
  // so lets make helper functions to guide the code in the right direction
  // === before: pInteractor.statsInteractor.setMaxHp(num)
  // === after: pInteractor.setMaxHp(num)

  // Helper Stats Methods ...
  public void setStats(Stats s) {
    this.statsInteractor.setStats(s);
  }

  public void setCurrentHp(int cHp) {
    System.out.println(">Helper Function: setCurrentHp()");
    statsInteractor.setCurrentHp(cHp);
  }

  public void setMaxHp(int mHp) {
    this.statsInteractor.setMaxHp(mHp);
  }

  public void setAttack(int att) {
    this.statsInteractor.setAttack(att);
  }

  public void setDefense(int def) {
    this.statsInteractor.setDefense(def);
  }

  public void setSpeed(int spd) {
    this.statsInteractor.setSpeed(spd);
  }

  public void setXp(int x) {
    this.statsInteractor.setXp(x);
  }

  public void setLvl(int l) {
    this.statsInteractor.setLvl(l);
  }

  public void setGold(int g) {
    this.statsInteractor.setGold(g);
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
