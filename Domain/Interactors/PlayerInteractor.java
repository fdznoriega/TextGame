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
  public PlayerInteractor(Player p, IPlayerInteractorOutput o) {
    this.player = p;
    this.output = o;
    //construct each interactor
    invenInteractor = new InventoryInteractor();
    invenInteractor.inventory = player.inventory;
    invenInteractor.output = this.output;
    statsInteractor = new StatsInteractor();
    statsInteractor.stats = player.stats;
    statsInteractor.output = this.output;
  }


  // Helper Stats Methods ...
  // === before: pInteractor.statsInteractor.setMaxHp(num)
  // === after: pInteractor.setMaxHp(num)

  public void setStats(Stats s) {
    this.statsInteractor.setStats(s);
  }

  public void setCurrentHp(int cHp) {
    this.statsInteractor.setCurrentHp(cHp);
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
