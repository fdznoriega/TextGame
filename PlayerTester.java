//This file will test all the methods that player has!


public class PlayerTester {

  public static void main(String[] args) {
    System.out.println(">Creating player.");
    Player p = new Player();

    //Base
    System.out.println(">Checking player's base stats.");
    System.out.println("HP: " + p.getHp());
    System.out.println("Lvl: " + p.getLvl());
    System.out.println("Attack: " + p.getAttack());
    System.out.println("XP: " + p.getXp());
    System.out.println("Gold: " + p.getGold());

    //Modified
    System.out.println(">Modifying player's base stats.");
    p.setHp(30);
    p.setLvl(40);
    p.setAttack(99);
    p.setXp(1000);
    p.setGold(1);
    System.out.println(">Checking player's new stats.");
    System.out.println("HP: " + p.getHp());
    System.out.println("Lvl: " + p.getLvl());
    System.out.println("Attack: " + p.getAttack());
    System.out.println("XP: " + p.getXp());
    System.out.println("Gold: " + p.getGold());

    //Inventory & Equipment Testing
    System.out.println(">Viewing default inventory/equipment");
    int[] demoI = p.getInventory();
    int[] demoE = p.getEquipment();

    //View current inventory.
    System.out.print(">Current Inventory: ");
    for(int i = 0; i < demoI.length; i++) {
      System.out.print(demoI[i] + " ");
    }
    System.out.println("");

    //View current equipment.
    System.out.print(">Current Equipment: ");
    for(int i = 0; i < demoE.length; i++) {
      System.out.print(demoE[i] + " ");
    }
    System.out.println("");

    //Add items to inventory.
    System.out.println(">Adding 6 items into inventory");
    System.out.print(p.addItem(1) + " ");
    System.out.print(p.addItem(2) + " ");
    System.out.print(p.addItem(3) + " ");
    System.out.print(p.addItem(4) + " ");
    System.out.print(p.addItem(5) + " ");
    System.out.print(p.addItem(6) + " ");
    System.out.println("");

    //View new inventory.
    System.out.print(">New Inventory: ");
    for(int i = 0; i < demoI.length; i++) {
      System.out.print(demoI[i] + " ");
    }
    System.out.println("");

    //Now that inventory is full, test equipping something.

  }
}
