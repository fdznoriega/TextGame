package Domain.Interactors;

//import ...
import Domain.Entities.Stats;
import Domain.Interfaces.IStatsInteractor;
import Domain.Interfaces.IStatsInteractorOutput;

public class StatsInteractor implements IStatsInteractor {
  public Stats s;
  public IStatsInteractorOutput out;

  //methods to implement
  public void setStats(Stats newStats) {
    s = newStats;
    out.showUpdateSuccess();
  }

  // NEXT TIME: logic to see whether HP increased or decreased and then
  //            apply the correct output.
  public void setCurrentHp(int cHp) {
    s.currentHp = cHp;
  }

  public void setMaxHp(int mHp) {
    s.maxHp = mHp;
  }

  public void setAttack(int att) {
    s.attack = att;
  }

  public void setDefense(int def) {
    s.defense = def;
  }

  public void setSpeed(int spd) {
    s.speed = spd;
  }

  public void setXp(int x) {
    s.xp = x;
  }

  public void setLvl(int l) {
    s.lvl = l;
  }

  public void setGold(int g) {
    s.gold = g;
  }


}
