//defines player inventory and its actions
package Domain.Entities;

public class Inventory {

  public Item[] inventory = new Item[10]; //limit: 10 items
  public Item[] equipment = new Item[3];   //limit: 3 items

  public String toString() {
    return inventoryToString() + equipmentToString();
  }

  public String inventoryToString() {
    String inv = "[ Inventory:\n";
    int counter = 0;
    while(counter < inventory.length) {
      inv += counter + ": " + inventory[counter].toString() + "\n";
    }
    return inv;
  }

  public String equipmentToString() {
    String eq = "[ Equipment:\n";
    int counter = 0;
    while(counter < equipment.length) {
      eq += counter + ": " + equipment[counter].toString() + "\n";
    }
    return eq;
  }


}
