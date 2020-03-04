//This file will test all the methods that player has!
package Tests;

import Domain.Entities.Player;
import Domain.Interactors.PlayerInteractor;

import Domain.IO.ConsoleOutput;

public class PlayerTester {

  public static void main(String[] args) {
    //Make player
    Player p1 = new Player();
    //Check toString vals
    System.out.println(">Checking complete player to string");
    System.out.println(p1.toString());
    //Player interactor connects all pieces internally in constructor
    System.out.println(">Create player interactor & set variables");
    // shorthand
    PlayerInteractor pInteractor = new PlayerInteractor(p1, new ConsoleOutput());
    //Confirm connections
    System.out.println(pInteractor.statsInteractor.stats.toString());
    System.out.println(pInteractor.invenInteractor.inventory.toString());
    //Demo Methods
    System.out.println("Demo methods");
    pInteractor.setCurrentHp(10);
    pInteractor.setGold(1000);
    pInteractor.clearEquipment();


  }
}
