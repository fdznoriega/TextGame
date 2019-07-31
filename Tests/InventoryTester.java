package Tests;

import Domain.Entities.Inventory;
import Domain.Entities.Item;
import Domain.Entities.ItemType;

public class InventoryTester {

  public static void main(String[] args) {
    //Make inven
    System.out.println(">Making inventory...");
    Inventory i = new Inventory();
    //Make 10 items
    //Item(name, type, id);
    System.out.println(">Making 10 items");
    Item i1, i2, i3, i4, i5, i6, i7, i8, i9, i10;
    i1 = new Item("Hp Potion", ItemType.restore, 1);
    i2 = new Item("Mana Potion", ItemType.restore, 2);
    i3 = new Item("Key", ItemType.unlock, 1);
    i4 = new Item("Sword", ItemType.equip, 1);
    i5 = new Item("Bone", ItemType.equip, 2);
    i6 = new Item("Key", ItemType.unlock, 1);
    i7 = new Item("Hp Potion", ItemType.restore, 1);
    i8 = new Item("Hp Potion", ItemType.restore, 1);
    i9 = new Item("Mana Potion", ItemType.restore, 2);
    i10 = new Item("Rubber Duck", ItemType.enhance, 1);
    //Put em in an array
    Item[] itemArr = new Item[] { i1, i2, i3, i4, i5, i6, i7, i8, i9, i10 };
    i.bag = itemArr;
    //Test Inventory methods
    System.out.println(">Testing to string methods");
    System.out.println(">Full toString()");
    System.out.println(i.toString());
    System.out.println(">bagToString()");
    System.out.println(i.bagToString());
    System.out.println(">equipmentToString()");
    System.out.println(i.equipmentToString());
    //Make inventory interactor

    //Make 3 items
    //Item[] equipItemArr = { e1, e2, e3 };
    //i.equipment = equipItemArr;
    //test toString methods
    //make inventory interactor
  }

}
