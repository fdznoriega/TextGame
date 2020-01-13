//This file will test all the methods that player has!
package Tests;

import Domain.Entities.Player;
import Domain.Interactors.PlayerInteractor;
import Game.ConsoleUserInterface;

public class PlayerTester {

  public static void main(String[] args) {
    //Make player
    Player p1 = new Player();
    //Check toString vals
    System.out.println(">Checking stats to string");
    System.out.println(p1.stats.toString());
    System.out.println(">Checking complete player to string");
    System.out.println(p1.toString());
    //Player interactor connects all pieces internally in constructor
    System.out.println(">Create player interactor & set variables");
    PlayerInteractor pInteractor = new PlayerInteractor(p1, new ConsoleUserInterface());
    //Confirm connections
    System.out.println(pInteractor.statsInteractor.stats.toString());
    System.out.println(pInteractor.invenInteractor.inventory.toString());
    //Demo Methods

    // PROBLEM: interactors have already been created but we only added
    // output to pInteractor.output. Looks like we need to pass in an
    // output to the player interactor constructor
    System.out.println(">Running setCurrentHp(10)");
    pInteractor.setCurrentHp(10);
    System.out.println(">Running clearEquipment()");
    pInteractor.clearEquipment();

  }
}
