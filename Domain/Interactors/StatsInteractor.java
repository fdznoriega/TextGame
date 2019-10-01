package Domain.Interactors;

//import ...
import Domain.Entities.Stats;
import Domain.Interfaces.IStatsInteractor;
import Domain.Interfaces.IStatsInteractorOutput;

public class StatsInteractor implements IStatsInteractor {
  public Stats s;
  public IStatsInteractorOutput out;

  //returns: 1 for new > current ; 0 for new = current ; -1 new < current
  private int compare(int currentVal, int newVal) {
    if(newVal > currentVal) {
      return 1;
    }
    else if(newVal == currentVal) {
      return 0;
    }
    else {
      return -1;
    }
  }


  //methods to implement
  public void setStats(Stats newStats) {
    s = newStats;
    out.showUpdateSuccess();
  }

  // NEXT TIME: logic to see whether HP increased or decreased and then
  //            apply the correct output.
  public void setCurrentHp(int cHp) {
    //ex: a potion heals 10 hp and you have 8 / 10.
    if((cHp > s.maxHp)) {
      if(s.currentHp == s.maxHp) {
        out.showHpAlreadyMax();
      }
      else {
        out.showIncreaseCurrentHp(s.maxHp - s.currentHp);
        s.currentHp = s.maxHp;
      }
      return;
    }


    switch(compare(s.currentHp, cHp)) {
      //X health gained
      case  1: out.showIncreaseCurrentHp(cHp - s.currentHp); break;
      //nothing happened because currentHp already max hp
      case  0: out.showHpAlreadyMax();                       break;
      //X damage taken
      case -1: out.showDecreaseCurrentHp(s.currentHp - cHp); break;
    }
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
