//This file will test all the methods that player has!
package Tests;

import Domain.Entities.Player;

public class PlayerTester {

  public static void main(String[] args) {
    System.out.println(">Creating player.");
    Player p = new Player();

    //Base
    System.out.println(">Checking toString methods");
    System.out.println(p.statsToString());
    System.out.println(p.inventoryToString());
    System.out.println(p.equipmentToString());
    System.out.println(p.toString());

  }
}
