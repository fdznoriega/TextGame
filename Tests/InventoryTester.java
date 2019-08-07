package Tests;

import Domain.Entities.Inventory;
import Domain.Entities.Item;
import Domain.Entities.ItemType;
import Domain.Interactors.InventoryInteractor;
import Game.ConsoleUserInterface;

public class InventoryTester {

  private static void sopl(String s) {
    System.out.println(s);
  }

  public static void main(String[] args) {
    //Make inven
    sopl(">TESTER: Making inventory");
    Inventory i = new Inventory();
    //Make 10 items
    //Item(name, type, id);
    sopl(">TESTER: Making 10 items");
    Item i1, i2, i3, i4, i5, i6, i7, i8, i9, i10;
    i1 = new Item("Hp Potion", ItemType.restore, 1);
    i2 = new Item("Mana Potion", ItemType.restore, 2);
    i3 = new Item("Key", ItemType.unlock, 1);
    i4 = new Item("Sword", ItemType.equip, 1);
    i5 = new Item("Bone", ItemType.equip, 2);
    i6 = new Item("Amulet", ItemType.equip, 1);
    i7 = new Item("Hp Potion", ItemType.restore, 1);
    i8 = new Item("Hp Potion", ItemType.restore, 1);
    i9 = new Item("Mana Potion", ItemType.restore, 2);
    i10 = new Item("Rubber Duck", ItemType.equip, 1);
    //Put em in an array
    Item[] itemArr = new Item[] { i1, i2, i3, i4, i5, i6, i7, i8, i9, i10 };
    i.bag = itemArr;
    /*
    //Test Inventory methods
    System.out.println(">Testing to string methods");
    System.out.println(">Full toString()");
    System.out.println(i.toString());
    System.out.println(">bagToString()");
    System.out.println(i.bagToString());
    System.out.println(">equipmentToString()");
    System.out.println(i.equipmentToString());
    */
    //Make inventory interactor & output
    sopl(">TESTER: Fully defining inventory interactor");
    InventoryInteractor invenInteractor = new InventoryInteractor();
    //----------this can be changed into any other kind of output----------
    ConsoleUserInterface cui = new ConsoleUserInterface();
    //---------------------------------------------------------------------
    invenInteractor.inven = i;
    invenInteractor.invenInteractorOut = cui;
    sopl(">TESTER: Testing methods");

    //Inserting when full
    Item i11 = new Item("Bus", ItemType.enhance, 1);
    sopl(">TESTER: Inserting when full");
    invenInteractor.insertItem(i11);
    //Removing an item by item
    sopl(">TESTER: Removing an item by item");
    invenInteractor.removeItem(i2);
    sopl(i.bagToString());
    //Adding an item when spot available
    sopl(">TESTER: Adding an item when spot available");
    invenInteractor.insertItem(i11);
    sopl(i.bagToString());
    //Equip 2 items
    sopl(">TESTER: Equip 3 items");
    invenInteractor.equipItem(i4);
    invenInteractor.equipItem(i5);
    invenInteractor.equipItem(i6);
    sopl(i.equipmentToString());
    //Equip item 3 (overflow)
    sopl(">TESTER: Equip item 4 (overflow)");
    invenInteractor.equipItem(i10);
    sopl(i.toString());
    //unequip item
    sopl(">TESTER: Unequip item");
    invenInteractor.unequipItem(i10);
    sopl(i.toString());
    //try equip item not in inventory
    sopl(">TESTER: Try equip item not in inven");
    invenInteractor.equipItem(new Item("Freako", ItemType.enhance, 1));
    //Unequip 3 items
    sopl(">TESTER: Unequip 3 items");
    invenInteractor.unequipItem(i4);
    invenInteractor.unequipItem(i5);
    invenInteractor.unequipItem(i6);
    sopl(i.equipmentToString());
    //Clearing the bag when full
    sopl(">TESTER: clearBag()");
    invenInteractor.clearBag();
    sopl(i.bagToString());
    //Removing item from empty bag
    sopl(">TESTER: Remove item Key");
    invenInteractor.removeItem(i3);
    sopl(i.bagToString());
    sopl(">TESTER: clearEquipment()");
    invenInteractor.clearEquipment();
    sopl(i.equipmentToString());

  }

}
