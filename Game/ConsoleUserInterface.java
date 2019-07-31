package Game;

import Domain.Interactors.IInventoryInteractorOutput;
import Domain.Entities.Inventory;

//implements many interactors?
public class ConsoleUserInterface implements IInventoryInteractorOutput {

  public void showBag(Inventory i) {
    System.out.println(i.bag.toString());
  }

  public void showEquipment(Inventory i) {
    System.out.println(i.equipment.toString());
  }

  public void showInventory(Inventory i) {
    System.out.println(i.toString());
  }

  public void showBagIsFull() {
    System.out.println(">Bag is full.");
  }

  public void showEquipmentIsFull() {
    System.out.println(">Equipment is full");
  }

  public void showCannotEquip() {
    System.out.println(">Could not equip item");
  }

  public void showItemNotFound() {
    System.out.println(">Could not find item");
  }
  
  public void showSuccess() {
    System.out.println(">Success");
  }
}
