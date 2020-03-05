package Domain.Interactors;

//import ...
import Domain.Entities.Stats;
import Domain.Interfaces.IStatsInteractor;
import Domain.Interfaces.IStatsInteractorOutput;

public class StatsInteractor implements IStatsInteractor {
  public Stats stats;
  public IStatsInteractorOutput output;

  public StatsInteractor(Stats s, IStatsInteractorOutput o) {
    this.stats = s;
    this.output = o;
  }

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
    stats = newStats;
    output.showUpdateSuccess();
  }

  // changes current Hp. Will do nothing if HP is increased and already max.
  public void setCurrentHp(int cHp) {
    //ex: a potion heals 10 hp and you have 8 / 10.
    if((cHp > stats.maxHp)) {
      if(stats.currentHp == stats.maxHp) {
        output.showHpAlreadyMax();
      }
      else {
        output.showIncreaseCurrentHp(stats.maxHp - stats.currentHp);
        stats.currentHp = stats.maxHp;
      }
      return;
    }

    switch(compare(stats.currentHp, cHp)) {
      //X health gained
      case  1:
        output.showIncreaseCurrentHp(cHp - stats.currentHp);
        break;
      //nothing happened because currentHp already max hp
      case  0:
        output.showHpAlreadyMax();
        break;
      //X damage taken
      case -1:
        output.showDecreaseCurrentHp(stats.currentHp - cHp);
        break;
    }
    stats.currentHp = cHp;
  }

  public void setMaxHp(int mHp) {
    switch(compare(stats.maxHp, mHp)) {
      case  1:
        output.showIncreaseMaxHp(mHp - stats.maxHp);
        break;
      case  0:
        output.showNoChange();
        break;
      case -1:
        output.showDecreaseMaxHp(stats.maxHp - mHp);
        break;
    }

    //Check for case where max Hp is reduced and current hp must fall too.
    if(mHp < stats.currentHp) {
      stats.currentHp = mHp;
    }

    stats.maxHp = mHp;
  }

  public void setAttack(int att) {
    switch(compare(stats.attack, att)) {
      case  1:
        output.showIncreaseAttack(att - stats.attack);
        break;
      case  0:
        output.showNoChange();
        break;
      case -1:
        output.showDecreaseAttack(stats.attack - att);
        break;
    }
    stats.attack = att;
  }

  public void setDefense(int def) {
    switch(compare(stats.defense, def)) {
      case  1:
        output.showIncreaseDefense(def - stats.defense);
        break;
      case  0:
        output.showNoChange();
        break;
      case -1:
        output.showDecreaseDefense(stats.defense - def);
        break;
    }
    stats.defense = def;
  }

  public void setSpeed(int spd) {
    switch(compare(stats.speed, spd)) {
      case  1:
        output.showIncreaseSpeed(spd - stats.speed);
        break;
      case  0:
        output.showNoChange();
        break;
      case -1:
        output.showDecreaseSpeed(stats.speed - spd);
        break;
    }
    stats.speed = spd;
  }

  public void setXp(int x) {
    switch(compare(stats.xp, x)) {
      case  1:
        output.showIncreaseExp(x - stats.xp);
        break;
      case  0:
        output.showNoChange();
        break;
      case -1:
        output.showDecreaseExp(stats.xp - x);
        break;
    }
    stats.xp = x;
  }

  public void setLvl(int l) {
    switch(compare(stats.lvl, l)) {
      case  1:
        output.showIncreaseLevel(l - stats.lvl);
        break;
      case  0:
        output.showNoChange();
        break;
      case -1:
        output.showDecreaseLevel(stats.lvl - l);
        break;
    }
    stats.lvl = l;
  }

  public void setGold(int g) {
    switch(compare(stats.gold, g)) {
      case  1:
        output.showIncreaseGold(g - stats.gold);
        break;
      case  0:
        output.showNoChange();
        break;
      case -1:
        output.showDecreaseGold(stats.gold - g);
        break;
    }
    stats.gold = g;
  }


}
