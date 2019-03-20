//This file will test all the methods that player has!
//Hello?

public class PlayerTester {

  public static void main(String[] args) {
    System.out.println(">Creating player.");
    Player p = new Player();

    //Base
    System.out.println(">Checking player's base stats.");
    System.out.println("Max HP: " + p.getMaxHp());
    System.out.println("Lvl: " + p.getLvl());
    System.out.println("Attack: " + p.getAttack());
    System.out.println("XP: " + p.getXp());
    System.out.println("Gold: " + p.getGold());

    //Modified
    System.out.println(">Modifying player's base stats.");
    p.setMaxHp(30);
    p.setLvl(40);
    p.setAttack(99);
    p.setXp(1000);
    p.setGold(1);
    System.out.println(">Checking player's new stats.");
    System.out.println("Max HP: " + p.getMaxHp());
    System.out.println("Lvl: " + p.getLvl());
    System.out.println("Attack: " + p.getAttack());
    System.out.println("XP: " + p.getXp());
    System.out.println("Gold: " + p.getGold());

    //Inventory & Equipment Testing
    System.out.println(">Viewing default inventory");
    p.printInventory();

    //View current equipment.
    System.out.println(">Viewing default equipment");
    p.printEquipment();

    //Try to equip something BEFORE inventory is occupied:
    System.out.println(">Attempting to equip 0, 3, 4, and 5");
    System.out.print(p.equipItem(0) + " ");
    System.out.print(p.equipItem(3) + " ");
    System.out.print(p.equipItem(4) + " ");
    System.out.print(p.equipItem(5) + "\n");

    //Add items to inventory.
    System.out.println(">Adding 6 items into inventory");
    System.out.print(p.addItem(1) + " ");
    System.out.print(p.addItem(2) + " ");
    System.out.print(p.addItem(3) + " ");
    System.out.print(p.addItem(4) + " ");
    System.out.print(p.addItem(5) + " ");
    System.out.print(p.addItem(6) + "\n");

    //View new inventory.
    System.out.println(">Checking Inventory");
    p.printInventory();

    //Now that inventory is full, test equipping something.
    System.out.println(">Equipping sword (#3)");
    System.out.println(p.equipItem(3));
    System.out.println(">Equipping armor (#4)");
    System.out.println(p.equipItem(4));

    //Check new equipment
    System.out.print(">New Equipment: ");
    p.printEquipment();

    //See if items were removed from inventory
    System.out.print(">Checking Updated Inventory: ");
    p.printInventory();

    //Add more items to inventory
    System.out.println(">Adding to Inventory: ");
    System.out.print(p.addItem(4) + " ");
    System.out.print(p.addItem(3) + "\n");

    //Checking updated inventory.
    System.out.print(">Updated Inventory: ");
    p.printInventory();

    //Attempting to equip another sword and armor.
    System.out.println(">Attempting to re-equip 0, 3, and 4");
    System.out.print(p.equipItem(0) + " ");
    System.out.print(p.equipItem(3) + " ");
    System.out.print(p.equipItem(4) + "\n");

    //Try delete an item.
    System.out.println(">Deleting item 1 in inventory");
    System.out.println(p.deleteItem(1));

    //Check updated inventory
    System.out.print(">Updated Inventory: ");
    p.printInventory();

    //Unequip item 3.
    System.out.print(">Unequipping item 3: ");
    System.out.print(p.unequipItem(3) + "\n");

    //Check inven + equip menu.
    System.out.print(">Updated Inventory: ");
    p.printInventory();
    System.out.print(">New Equipment: ");
    p.printEquipment();

    //Attempt to unequip item 3 again.
    System.out.print(">Unequipping item 3 and 4: ");
    System.out.print(p.unequipItem(3) + " ");
    System.out.print(p.unequipItem(4) + "\n");

    //Testing done.
    System.out.println(">Whoa, lookin' cool Joker!");


  }
}
