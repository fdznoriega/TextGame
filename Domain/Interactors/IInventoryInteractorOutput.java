package Domain.Interactors;

import Domain.Entities.Inventory;
import Domain.Entities.Item;

public interface IInventoryInteractorOutput {
  void showInventory();
  void showInventoryIsFull();
  void showEquipment();
  void showCannotEquip();
  void showEquipmentIsFull();
  void showInventoryAndEquipment();
  void showSuccess();
  void showIndexedItem(int index);
  void showItemOfId(int id);
  void showItemNotFound();
}
