package Domain.Interfaces;

import Domain.Entities.Inventory;
import Domain.Entities.Item;

public interface IInventoryInteractorOutput {
  void showBag(Inventory i);
  void showEquipment(Inventory i);
  void showInventory(Inventory i);
  void showBagIsFull();
  void showEquipmentIsFull();
  void showCannotEquip();
  void showItemNotFound();
  void showEquipmentCleared();
  void showBagCleared();
  void showItemInserted();
  void showItemRemoved();
  void showItemUnequipped();
}
