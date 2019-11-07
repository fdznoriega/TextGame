//This file will test all the methods that player has!
package Tests;

import Domain.Entities.Player;
import Domain.Interactors.PlayerInteractor;
import Game.ConsoleUserInterface;

public class PlayerTester {

  public static void main(String[] args) {
    //Make player
    Player p = new Player();
    //Check toString vals
    System.out.println(">Checking stats to string");
    System.out.println(p.stats.toString());
    System.out.println(">Checking complete player to string");
    System.out.println(p.toString());
    //Player interactor connects all pieces internally in constructor
    System.out.println(">Setting player to player interactor");
    PlayerInteractor pInteractor = new PlayerInteractor(p);
    //Connect inventory interactor and stat interactor to outputs
    System.out.println(">Setting UI to player interactor");
    ConsoleUserInterface cui = new ConsoleUserInterface();
    //Now we can play with the pInteractor
    

  }
}
