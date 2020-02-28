package Domain.Interfaces;

import Domain.Entities.Inventory;

public interface IPlayerInteractorOutput extends IInventoryInteractorOutput, IStatsInteractorOutput {
  // player interactor output methods


  // inventory interactor output methods
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
  // stat interactor output methods
  void showUpdateSuccess();
  void showUpdateFailure();
  void showFullyHealed();
  void showHpAlreadyMax();
  void showNoChange();
  void showIncreaseCurrentHp(int amt);
  void showIncreaseMaxHp(int amt);
  void showIncreaseAttack(int amt);
  void showIncreaseDefense(int amt);
  void showIncreaseSpeed(int amt);
  void showIncreaseLevel(int amt);
  void showIncreaseExp(int amt);
  void showIncreaseGold(int amt);
  void showDecreaseCurrentHp(int amt);
  void showDecreaseMaxHp(int amt);
  void showDecreaseAttack(int amt);
  void showDecreaseDefense(int amt);
  void showDecreaseSpeed(int amt);
  void showDecreaseLevel(int amt);
  void showDecreaseExp(int amt);
  void showDecreaseGold(int amt);
}
