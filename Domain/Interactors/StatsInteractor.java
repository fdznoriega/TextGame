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
    switch(compare(s.maxHp, mHp)) {
      case  1: out.showIncreaseMaxHp(mHp - s.maxHp);  break;
      case  0: out.showNoChange();                    break;
      case -1: out.showDecreaseMaxHp(s.maxHp - mHp);  break;
    }
    s.maxHp = mHp;
  }

  public void setAttack(int att) {
    switch(compare(s.attack, att)) {
      case  1: out.showIncreaseAttack(att - s.attack); break;
      case  0: out.showNoChange();                     break;
      case -1: out.showDecreaseAttack(s.attack - att); break;
    }
    s.attack = att;
  }

  public void setDefense(int def) {
    switch(compare(s.defense, def)) {
      case  1: out.showIncreaseDefense(def - s.defense); break;
      case  0: out.showNoChange();                       break;
      case -1: out.showDecreaseDefense(s.defense - def); break;
    }
    s.defense = def;
  }

  public void setSpeed(int spd) {
    switch(compare(s.speed, spd)) {
      case  1: out.showIncreaseSpeed(spd - s.speed); break;
      case  0: out.showNoChange();                   break;
      case -1: out.showDecreaseSpeed(s.speed - spd); break;
    }
    s.speed = spd;
  }

  public void setXp(int x) {
    switch(compare(s.xp, x)) {
      case  1: out.showIncreaseExp(x - s.xp); break;
      case  0: out.showNoChange();            break;
      case -1: out.showDecreaseExp(s.xp - x); break;
    }
    s.xp = x;
  }

  public void setLvl(int l) {
    switch(compare(s.lvl, l)) {
      case  1: out.showIncreaseLevel(l - s.lvl); break;
      case  0: out.showNoChange();               break;
      case -1: out.showDecreaseLevel(s.lvl - l); break;
    }
    s.lvl = l;
  }

  public void setGold(int g) {
    switch(compare(s.gold, g)) {
      case  1: out.showIncreaseGold(g - s.gold); break;
      case  0: out.showNoChange();               break;
      case -1: out.showDecreaseGold(s.gold - g); break;
    }
    s.gold = g;
  }


}
