package Domain.Interactors;

//import ...
import Domain.Entities.Player;
import Domain.Interactors.InventoryInteractor;

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

}
