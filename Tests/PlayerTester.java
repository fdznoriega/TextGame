//This file will test all the methods that player has!
package Tests;

import Domain.Entities.Player;

public class PlayerTester {

  public static void main(String[] args) {
    //Make player
    Player p = new Player();
    //Check toString vals
    System.out.println(">Checking toString methods");
    System.out.println(p.statsToString());
    System.out.println(p.toString());
    //Make player interactor (wip)

  }
}
