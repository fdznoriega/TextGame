//This file will test all the methods that player has!
package Tests;

import Domain.Entities.Player;
import Domain.Interactors.PlayerInteractor;

public class PlayerTester {

  public static void main(String[] args) {
    //Make player
    Player p = new Player();
    //Check toString vals
    System.out.println(">Checking stats to string");
    System.out.println(p.statsToString());
    System.out.println(">Checking complete player to string");
    System.out.println(p.toString());
    //Make player interactor
    PlayerInteractor pInteractor = new PlayerInteractor();
    //Connect pInteractor to player inventory and stats
    /**
    pInteractor.p = this.p;
    pInteractor.invenInteractor.inven = this.p.inventory;
    //pInteractor.statInteractor.stat = this.p.stats;
    //Connect inventory interactor and stat interactor to outputs
    ConsoleUserInterface cui = new ConsoleUserInterface();
    pInteractor.invenInteractorOut = cui;
    //pInteractor.statInteractorOut = cui;
    **/

  }
}
