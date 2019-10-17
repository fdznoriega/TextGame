package Tests;

import Domain.Entities.Stats;
import Domain.Interactors.StatsInteractor;
import Game.ConsoleUserInterface;

public class StatsTester {

  public static void main(String[] args) {
    //Setup
    ConsoleUserInterface cui = new ConsoleUserInterface();
    Stats s = new Stats(10, 5, 5, 5, 1, 0, 0);
    StatsInteractor si = new StatsInteractor();
    si.s = s;
    si.out = cui;
    //show base stats
    System.out.println("SHOWING CURRENT STATS");
    System.out.println(si.s.toString());
    //Set new stats
    Stats s1 = new Stats(15, 6, 6, 6, 2, 10, 2);
    System.out.println("UPDATING STATS");
    si.setStats(s1);
    System.out.println(si.s.toString());
    //==========CURRENT HP TESTING==========
    //Try update current hp in all 3 directions.
    //Neutral
    System.out.println("CHANGING CURRENT HP TO 15");
    si.setCurrentHp(15);
    System.out.println(si.s.HpRatioToString());
    //Up too high
    System.out.println("INCREASING CURRENT HP TO 20");
    si.setCurrentHp(20);
    System.out.println(si.s.HpRatioToString());
    //Down
    System.out.println("DECREASING CURRENT HP TO 10");
    si.setCurrentHp(10);
    System.out.println(si.s.HpRatioToString());
    //now move up up to max + 1
    System.out.println("INCREASING CURRENT HP TO MAX HP + 1");
    si.setCurrentHp(si.s.maxHp + 1);
    System.out.println(si.s.HpRatioToString());
    //==========MAX HP TESTING==========
    System.out.println("INCREASING MAX HP TO 20");
    si.setMaxHp(20);
    System.out.println(si.s.HpRatioToString());
    System.out.println("DECREASING MAX HP TO 10");
    si.setMaxHp(10);
    System.out.println(si.s.HpRatioToString());
    //==========ATTACK TESTING==========
    //==========DEFENSE TESTING==========
    //==========SPEED TESTING==========
    //==========LEVEL TESTING==========
    //==========EXP TESTING==========
    //==========GOLD TESTING==========



  }

}
