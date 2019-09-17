package Domain.Interactors;

//import ...
import Domain.Entities.Player;
import Domain.Interactors.InventoryInteractor;

//player has stats and inventory which are manipulated by other classes
//pInteractor holds these other interactors and is a "manager"
public class PlayerInteractor /**implements IPlayerInteractor **/ {

  public Player p;
  //public IPlayerInteractorOutput pOut;
  public InventoryInteractor invenInteractor;
  //public StatsInteractor statInteractor;

  public PlayerInteractor() {
    invenInteractor.inven = p.inventory;
    //statInteractor.stats = p.stats;
  }





}
