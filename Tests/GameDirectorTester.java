package Tests;

// import
import Domain.Entities.*;
import Domain.Interactors.*;
import Domain.Interfaces.*;
import Domain.GameDirector;

public class GameDirectorTester {
  public static void main(String[] args) {
    GameDirector g = new GameDirector();
    g.pInteractor.setGold(100);
    g.mInteractor.load("Square");
    g.maze = g.mInteractor.maze;
    g.setLocationToSpawn();
    g.move(Direction.North);
    System.out.println(g.location[0] + ":" + g.location[1]);
  }
}
