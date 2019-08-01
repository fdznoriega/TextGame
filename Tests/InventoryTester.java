package Tests;

import Domain.Entities.Inventory;
import Domain.Entities.Item;
import Domain.Entities.ItemType;
import Domain.Interactors.InventoryInteractor;
import Game.ConsoleUserInterface;

public class InventoryTester {

  public static void main(String[] args) {
    //Make inven
    System.out.println(">TESTER: Making inventory");
    Inventory i = new Inventory();
    //Make 10 items
    //Item(name, type, id);
    System.out.println(">TESTER: Making 10 items");
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
    System.out.println(">TESTER: Fully defining inventory interactor");
    InventoryInteractor invenInteractor = new InventoryInteractor();
    //----------this can be changed into any other kind of output----------
    ConsoleUserInterface cui = new ConsoleUserInterface();
    //---------------------------------------------------------------------
    invenInteractor.inven = i;
    invenInteractor.invenInteractorOut = cui;
    System.out.println(">TESTER: Testing methods");

    //Inserting when full
    Item i11 = new Item("Bus", ItemType.enhance, 1);
    System.out.println(">TESTER: Inserting when full");
    invenInteractor.insertItem(i11);
    //Removing an item by item
    System.out.println(">TESTER: Removing an item by item");
    invenInteractor.removeItem(i2);
    System.out.println(i.bagToString());
    //Adding an item when spot available
    System.out.println(">TESTER: Adding an item when spot available");
    invenInteractor.insertItem(i11);
    System.out.println(i.bagToString());
    //Equip 2 items
    System.out.println(">TESTER: Equip 3 items");
    invenInteractor.equipItem(i4);
    invenInteractor.equipItem(i5);
    invenInteractor.equipItem(i6);
    System.out.println(i.equipmentToString());
    //Equip item 3 (overflow)
    System.out.println(">TESTER: Equip item 4 (overflow)");
    invenInteractor.equipItem(i10);
    System.out.println(i.toString());
    //try equip item not in inventory
    //System.out.println(">TESTER: Equip item not in bag");

    //Unequip 3 items


    //Clearing the bag when full
    System.out.println(">TESTER: clearBag()");
    invenInteractor.clearBag();
    System.out.println(i.bagToString());
    //Removing item from empty bag
    System.out.println(">TESTER: removeItem(Item item)");
    invenInteractor.removeItem(i3);
    System.out.println(i.bagToString());

    //Removing an item

    //equipItem(Item item);
    //removeItem(Item item);
    //unequipItem(Item item);
    //clearBag();
    //clearEquipment();



    //Make 3 items
    //Item[] equipItemArr = { e1, e2, e3 };
    //i.equipment = equipItemArr;
    //test toString methods
    //make inventory interactor
  }

}
