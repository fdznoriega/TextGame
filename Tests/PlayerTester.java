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
    PlayerInteractor pInteractor = new PlayerInteractor(p1);
    pInteractor.output = new ConsoleUserInterface();
    /*
    //Connect inventory interactor and stat interactor to outputs
    System.out.println(">Setting UI to player interactor");
    ConsoleUserInterface cui = new ConsoleUserInterface();
    //Now we can play with the pInteractor
    System.out.println(">Running setCurrentHp(10)");
    pInteractor.setCurrentHp(10);
    System.out.println(">Running clearEquipment()");
    pInteractor.clearEquipment();
    */

  }
}
