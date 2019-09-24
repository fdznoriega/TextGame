package Domain.Interfaces;

import Domain.Entities.Stats;

public interface IStatsInteractor {
  void setStats(Stats s);
  void setCurrentHp(int cHp);
  void setMaxHp(int mHp);
  void setAttack(int att);
  void setDefense(int def);
  void setSpeed(int spd);
  void setXp(int x);
  void setLvl(int l);
  void setGold(int g);
}
