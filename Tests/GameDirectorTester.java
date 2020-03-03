package Tests;

// import
import Domain.Entities.*;
import Domain.Interactors.*;
import Domain.Interfaces.*;

public class GameDirectorTester {
  public static void main(String[] args) {
    GameDirector g = new GameDirector();
    // GameDirector g = new GameDirector()
    g.pInteractor.setGold(100);
    g.mInteractor.load("Square");
    g.maze = g.mInteractor.maze;
    g.setLocationToSpawn();
    System.out.println("LOC: " + g.location[0] +  ":" + g.location[1]);
    g.move(Direction.South);
    System.out.println("LOC: " + g.location[0] +  ":" + g.location[1]);
    g.move(Direction.North);
    System.out.println("LOC: " + g.location[0] +  ":" + g.location[1]);
    g.move(Direction.East);
    System.out.println("LOC: " + g.location[0] +  ":" + g.location[1]);
    g.move(Direction.West);
    System.out.println("LOC: " + g.location[0] +  ":" + g.location[1]);




  }
}
