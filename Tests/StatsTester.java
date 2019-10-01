package Tests;

//import...
import Domain.Entities.Stats;
import Domain.Interactors.StatsInteractor;
import Game.ConsoleUserInterface;

public class StatsTester {

  public static void main(String[] args) {
    //Setup
    ConsoleUserInterface cui = new ConsoleUserInterface();
    Stats s = new Stats(10, 5, 5, 5, 1, 0, 0);
    StatsInteractor si = new StatsInteractor();
    si.out = cui;
    //Set new stats
    Stats s1 = new Stats(12, 6, 6, 6, 2, 10, 2);
    si.setStats(s1);


  }

}
