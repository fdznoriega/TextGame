package Domain.Interactors;

import Domain.Entities.Inventory;
import Domain.Entities.Item;

public interface IInventoryInteractorOutput {
  void showBag();
  void showBagIsFull();
  void showEquipment();
  void showCannotEquip();
  void showEquipmentIsFull();
  void showBagAndEquipment();
  void showSuccess();
  void showIndexedItem(int index);
  void showItemOfId(int id);
  void showItemNotFound();
}
