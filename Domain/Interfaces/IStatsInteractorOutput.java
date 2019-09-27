package Domain.Interfaces;

//import...

/* Note: Stats are currentHp, maxHp, attack, defense, speed, lvl, xp, gold */

public interface IStatsInteractorOutput {
  void showUpdateSuccess();
  void showUpdateFailure();
  //show increase of individual stats.
  //void showIncrease...
  //can i make this more abstract?
  void showIncreaseCurrentHp();
  void showIncreaseMaxHp();
  void showIncreaseAttack();
  void showIncreaseDefense();
  void showIncreaseSpeed();
  void showIncreaseLevel();
  void showIncreaseExp();
  void showIncreaseGold();
  //show decrease of individual stats.
  //void showDecrease...


}
