package Domain.Interactors;

import Domain.Entities.Inventory;
import Domain.Entities.Item;
import Domain.Entities.ItemType;
import Domain.Interactors.IInventoryInteractorOutput;

public class InventoryInteractor {

  public Inventory inven;
  public IInventoryInteractorOutput invenInteractorOut;

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
    for(int i = 0; i < inven.bag.length; i++) {
      if(inven.bag[i].equals(item)) {
        inven.bag[i] = null;
        invenInteractorOut.showSuccess();
        return;
      }
    }
    invenInteractorOut.showItemNotFound();
  }

  public void unequipItem(Item item) {
    for(int i = 0; i < inven.equipment.length; i++) {
      if(inven.equipment[i].equals(item)) {
        inven.equipment[i] = null;
        invenInteractorOut.showSuccess();
        return;
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

  //should this be here? seems more like a game system...
  // public void useItem(Item item) {
  //   return null;
  //
  // }

}
