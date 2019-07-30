package Domain.Interactors;

import Domain.Entities.Inventory;

public class InventoryInteractor {

  public Inventory inven;
  public IInventoryInteractorOutput invenInteractorOut;

  private boolean inventoryIsFull() {
    int counter = 0;
    while(counter < inven.inventory.length) {

    }
  }

  private boolean equipmentIsFull() {
    return null;
  }

  public void insertItem(Item item) {
    return null;
  }

  public void removeItem(Item item) {
    return null;

  }

  public void clearInventory() {
    return null;

  }

  public void useItem(Item item) {
    return null;

  }

  public void equipItem(Item item) {
    return null;

  }

  public void unequipItem(Item item) {
    return null;

  }

  public void clearEquipment() {
    return null;

  }

}
