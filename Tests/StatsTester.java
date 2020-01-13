package Tests;

import Domain.Entities.Stats;
import Domain.Interactors.StatsInteractor;
import Game.ConsoleUserInterface;

public class StatsTester {

  public static void main(String[] args) {
    //Setup
    Stats s = new Stats(10, 5, 5, 5, 1, 0, 0);
    StatsInteractor si = new StatsInteractor();
    si.s = s;
    si.out = new ConsoleUserInterface();
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
    System.out.println("INCREASING ATTACK TO 10");
    si.setAttack(10);
    System.out.println(si.s.attack);
    System.out.println("DECREASING ATTACK TO 5");
    si.setAttack(5);
    System.out.println(si.s.attack);
    System.out.println("RESETTING ATTACK TO 5");
    si.setAttack(5);
    System.out.println(si.s.attack);
    //==========DEFENSE TESTING==========
    System.out.println("INCREASING DEFENSE TO 10");
    si.setDefense(10);
    System.out.println(si.s.defense);
    System.out.println("DECREASING DEFENSE TO 5");
    si.setDefense(5);
    System.out.println(si.s.defense);
    System.out.println("RESETTING DEFENSE TO 5");
    si.setDefense(5);
    System.out.println(si.s.defense);
    //==========SPEED TESTING==========
    System.out.println("INCREASING SPEED TO 10");
    si.setSpeed(10);
    System.out.println(si.s.speed);
    System.out.println("DECREASING SPEED TO 5");
    si.setSpeed(5);
    System.out.println(si.s.speed);
    System.out.println("RESETTING SPEED TO 5");
    si.setSpeed(5);
    System.out.println(si.s.speed);
    //==========LEVEL TESTING==========
    System.out.println("INCREASING LEVEL TO 10");
    si.setLvl(10);
    System.out.println(si.s.lvl);
    System.out.println("DECREASING LEVEL TO 5");
    si.setLvl(5);
    System.out.println(si.s.lvl);
    System.out.println("RESETTING LEVEL TO 5");
    si.setLvl(5);
    System.out.println(si.s.lvl);
    System.out.println("INCREASING LEVEL BY 1");
    si.setLvl(si.s.lvl + 1);
    System.out.println(si.s.lvl);
    //==========EXP TESTING==========
    System.out.println("INCREASING EXP TO 10");
    si.setXp(10);
    System.out.println(si.s.xp);
    System.out.println("DECREASING EXP TO 5");
    si.setXp(5);
    System.out.println(si.s.xp);
    System.out.println("RESETTING EXP TO 5");
    si.setXp(5);
    System.out.println(si.s.xp);
    //==========GOLD TESTING==========
    System.out.println("INCREASING GOLD TO 10");
    si.setGold(10);
    System.out.println(si.s.gold);
    System.out.println("DECREASING GOLD TO 5");
    si.setGold(5);
    System.out.println(si.s.gold);
    System.out.println("RESETTING GOLD TO 5");
    si.setGold(5);
    System.out.println(si.s.gold);



  }

}
