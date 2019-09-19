package Domain.Interfaces;

import Domain.Entities.Stats;

public interface IStatsInteractor {
  void updateAll(Stats s);
  void updateCurrentHp();
  void updateMaxHp();
  void updateAttack(int att);
  void updateDefense(int def);
  void updateSpeed(int spd);
  void updateXp(int x);
  void updateLvl(int l);
  void updateGold(int g);
}
