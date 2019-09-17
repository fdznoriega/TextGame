package Domain.Interfaces;

import Domain.Entities.Item;

public interface IInventoryInteractor {
  void insertItem(Item item);
  void equipItem(Item item);
  void removeItem(Item item);
  void unequipItem(Item item);
  void clearEquipment();
}
