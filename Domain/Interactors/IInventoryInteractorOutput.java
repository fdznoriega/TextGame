package Domain.Interactors;

import Domain.Entities.Inventory;
import Domain.Entities.Item;

public interface IInventoryInteractorOutput {
  void showInventory();
  void showIndexedItem(int index);
  void showItemOfId(int id);
  void showItemNotFound();
}
