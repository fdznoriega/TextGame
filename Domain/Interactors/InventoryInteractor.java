package Domain.Interactors;

import Domain.Entities.Inventory;
import Domain.Entities.Item;
import Domain.Entities.ItemType;
import Domain.Interfaces.IInventoryInteractorOutput;

public class InventoryInteractor implements IInventoryInteractor {

  public Inventory inventory;
  public IInventoryInteractorOutput output;

  public void insertItem(Item item) {
    int[] fullAndIndex = bagIsFull();
    int bagIsFull = fullAndIndex[0];
    int indexOfEmptySpace = fullAndIndex[1];
    if(bagIsFull == 1) {
      output.showBagIsFull();
    }
    else {
      inventory.bag[indexOfEmptySpace] = item;
      output.showSuccess();
    }
  }

  //itemtype must be equip!
  //equipped items moved from bag to equip slot
  public void equipItem(Item item) {
    if(!isItemInBag(item)) {
      output.showItemNotFound();
      return;
    }
    if(item.type != ItemType.Equip) {
      output.showCannotEquip();
      return;
    }
    int[] fullAndIndex = equipmentIsFull();
    int equipmentIsFull = fullAndIndex[0];
    int indexOfEmptySpace = fullAndIndex[1];
    if(equipmentIsFull == 1) {
      output.showEquipmentIsFull();
    }
    else {
      inventory.equipment[indexOfEmptySpace] = item;
      removeItem(item);
      //output.showSuccess();
    }

  }

  public void removeItem(Item item) {
    for(int i = 0; i < inventory.bag.length; i++) {
      if(inventory.bag[i] != null && inventory.bag[i].equals(item)) {
        inventory.bag[i] = null;
        output.showSuccess();
        return;
      }
    }
    output.showItemNotFound();
  }

  public void unequipItem(Item item) {
    if(item != null && inventory.equipment.length > 0) {
      for(int i = 0; i < inventory.equipment.length; i++) {
        if(inventory.equipment[i] != null) {
          if(inventory.equipment[i].equals(item)) {
            inventory.equipment[i] = null;
            output.showSuccess();
            return;
          }
        }
      }
    }
    output.showItemNotFound();
  }

  public void clearBag() {
    for(int i = 0; i < inventory.bag.length; i++) {
      inventory.bag[i] = null;
    }
    output.showSuccess();
  }

  public void clearEquipment() {
    for(int i = 0; i < inventory.equipment.length; i++) {
      inventory.equipment[i] = null;
    }
    output.showSuccess();
  }

  // -- Private Methods -- \\
  //returns 0/1 (false, true), and index of empty space (int; -1 = no empty space)
  private int[] bagIsFull() {
    int counter = 0;
    while(counter < inventory.bag.length) {
      if(inventory.bag[counter] == null) {
           return new int[] {0, counter};
      }
      counter++;
    }
    return new int[] {1, -1};
  }

  //same as inventoryIsFull()
  private int[] equipmentIsFull() {
    int counter = 0;
    while(counter < inventory.equipment.length) {
      if(inventory.equipment[counter] == null) {
           return new int[] {0, counter};
      }
      counter++;
    }
    return new int[] {1, -1};
  }

  private boolean isItemInBag(Item item) {
    for(int counter = 0; counter < inventory.bag.length; counter++) {
      if(inventory.bag[counter] != null && inventory.bag[counter].equals(item)) {
        return true;
      }
    }
    return false;
  }

}
