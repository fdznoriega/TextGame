package Domain.Interactors;

import Domain.Entities.Inventory;
import Domain.Entities.Item;
import Domain.Entities.ItemType;
import Domain.Interactors.IInventoryInteractorOutput;

public class InventoryInteractor {

  public Inventory inven;
  public IInventoryInteractorOutput invenInteractorOut;

  public void insertItem(Item item) {
    int[] fullAndIndex = bagIsFull();
    int bagIsFull = fullAndIndex[0];
    int indexOfEmptySpace = fullAndIndex[1];
    if(bagIsFull == 1) {
      invenInteractorOut.showBagIsFull();
    }
    else {
      inven.bag[indexOfEmptySpace] = item;
      invenInteractorOut.showSuccess();
    }
  }

  //itemtype must be equip!
  //equipped items moved from bag to equip slot
  public void equipItem(Item item) {
    if(!isItemInBag(item)) {
      invenInteractorOut.showItemNotFound();
      return;
    }
    if(item.type != ItemType.Equip) {
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
      removeItem(item);
      //invenInteractorOut.showSuccess();
    }

  }

  public void removeItem(Item item) {
    for(int i = 0; i < inven.bag.length; i++) {
      if(inven.bag[i] != null && inven.bag[i].equals(item)) {
        inven.bag[i] = null;
        invenInteractorOut.showSuccess();
        return;
      }
    }
    invenInteractorOut.showItemNotFound();
  }

  public void unequipItem(Item item) {
    if(item != null && inven.equipment.length > 0) {
      for(int i = 0; i < inven.equipment.length; i++) {
        if(inven.equipment[i] != null) {
          if(inven.equipment[i].equals(item)) {
            inven.equipment[i] = null;
            invenInteractorOut.showSuccess();
            return;
          }
        }
      }
    }
    invenInteractorOut.showItemNotFound();
  }

  public void clearBag() {
    for(int i = 0; i < inven.bag.length; i++) {
      inven.bag[i] = null;
    }
    invenInteractorOut.showSuccess();
  }

  public void clearEquipment() {
    for(int i = 0; i < inven.equipment.length; i++) {
      inven.equipment[i] = null;
    }
    invenInteractorOut.showSuccess();
  }

  // -- Private Methods -- \\
  //returns 0/1 (false, true), and index of empty space (int; -1 = no empty space)
  private int[] bagIsFull() {
    int counter = 0;
    while(counter < inven.bag.length) {
      if(inven.bag[counter] == null) {
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
      if(inven.equipment[counter] == null) {
           return new int[] {0, counter};
      }
      counter++;
    }
    return new int[] {1, -1};
  }

  private boolean isItemInBag(Item item) {
    for(int counter = 0; counter < inven.bag.length; counter++) {
      if(inven.bag[counter] != null && inven.bag[counter].equals(item)) {
        return true;
      }
    }
    return false;
  }

}
