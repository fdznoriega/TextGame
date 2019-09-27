package Domain.Interfaces;

//import...

/* Note: Stats are currentHp, maxHp, attack, defense, speed, lvl, xp, gold */

public interface IStatsInteractorOutput {
  void showUpdateSuccess();
  void showUpdateFailure();
  //show increase of individual stats.
  //can i make this more abstract? -- no because we want to be specific w player
  void showIncreaseCurrentHp();
  void showIncreaseMaxHp();
  void showIncreaseAttack();
  void showIncreaseDefense();
  void showIncreaseSpeed();
  void showIncreaseLevel();
  void showIncreaseExp();
  void showIncreaseGold();
  //show decrease of individual stats.
  void showDecreaseCurrentHp();
  void showDecreaseMaxHp();
  void showDecreaseAttack();
  void showDecreaseDefense();
  void showDecreaseSpeed();
  void showDecreaseLevel();
  void showDecreaseExp();
  void showDecreaseGold();


}
