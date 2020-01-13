package Domain.Interfaces;

import Domain.Entities.Inventory;
import Domain.Entities.Item;

public interface IPlayerInteractorOutput extends IInventoryInteractorOutput, IStatsInteractorOutput {
  //Inventory Outputs
  void showBag(Inventory i);
  void showEquipment(Inventory i);
  void showInventory(Inventory i);
  void showBagIsFull();
  void showEquipmentIsFull();
  void showCannotEquip();
  void showItemNotFound();
  void showSuccess();
  //Stat Outputs
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
