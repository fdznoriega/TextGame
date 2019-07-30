package Domain.Interactors;

import Domain.Entities.Inventory;
import Domain.Entities.Item;
import Domain.Entities.ItemType;
import Domain.Interactors.IInventoryInteractorOutput;

public class InventoryInteractor {

  public Inventory inven;
  public IInventoryInteractorOutput invenInteractorOut;

  //returns 0/1 (false, true), and index of empty space (int; -1 = no empty space)
  private int[] inventoryIsFull() {
    int counter = 0;
    while(counter < inven.inventory.length) {
      if(inven.inventory[counter] == null ||
         inven.inventory[counter] == new Item()) {
           return new int[] {0, counter};
      }
      counter++;
    }
    return new int[] {1, -1};
  }

  //same as inventoryIsFull()
  private int[] equipmentIsFull() {
    int counter = 0;
    while(counter < inven.equipment.length) {
      if(inven.equipment[counter] == null ||
         inven.equipment[counter] == new Item()) {
           return new int[] {0, counter};
      }
      counter++;
    }
    return new int[] {1, -1};
  }

  public void insertItem(Item item) {
    int[] fullAndIndex = inventoryIsFull();
    int inventoryIsFull = fullAndIndex[0];
    int indexOfEmptySpace = fullAndIndex[1];
    if(inventoryIsFull == 1) {
      invenInteractorOut.showInventoryIsFull();
    }
    else {
      inven.inventory[indexOfEmptySpace] = item;
      invenInteractorOut.showSuccess();
    }
  }

  //itemtype must be equip!
  public void equipItem(Item item) {
    if(item.type != ItemType.equip) {
      invenInteractorOut.showCannotEquip();
      return;
    }
    int[] fullAndIndex = equipmentIsFull();
    int equipmentIsFull = fullAndIndex[0];
    int indexOfEmptySpace = fullAndIndex[1];
    if(equipmentIsFull == 1) {
      invenInteractorOut.showEquipmentIsFull();
    }
    else {
      inven.equipment[indexOfEmptySpace] = item;
      invenInteractorOut.showSuccess();
    }

  }

  public void removeItem(Item item) {
    for(int i = 0; i < inven.inventory.length; i++) {
      if(inven.inventory[i].equals(item)) {
        inven.inventory[i] = new Item();
        invenInteractorOut.showSuccess();
        return;
      }
    }
    invenInteractorOut.showItemNotFound();
  }

  public void unequipItem(Item item) {
    for(int i = 0; i < inven.equipment.length; i++) {
      if(inven.equipment[i].equals(item)) {
        inven.equipment[i] = new Item();
        invenInteractorOut.showSuccess();
        return;
      }
    }
    invenInteractorOut.showItemNotFound();

  }

  public void clearInventory() {
    for(int i = 0; i < inven.inventory.length; i++) {
      inven.inventory[i] = new Item();
    }
    invenInteractorOut.showSuccess();
  }

  public void clearEquipment() {
    for(int i = 0; i < inven.equipment.length; i++) {
      inven.equipment[i] = new Item();
    }
    invenInteractorOut.showSuccess();
  }

  //should this be here? seems more like a game system...
  // public void useItem(Item item) {
  //   return null;
  //
  // }

}
