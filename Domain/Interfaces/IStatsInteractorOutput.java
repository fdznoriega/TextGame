package Domain.Interfaces;

//import...

/* Note: Stats are currentHp, maxHp, attack, defense, speed, lvl, xp, gold */

public interface IStatsInteractorOutput {
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
