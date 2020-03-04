package Tests;

// import
import Domain.Entities.*;
import Domain.Interactors.*;
import Domain.Interfaces.*;
import Domain.IO.ConsoleInput;
import Domain.IO.ConsoleOutput;

public class GameDirectorTester {
  public static void main(String[] args) {
    GameDirector g;
    // g = new GameDirector();
    g = new GameDirector(new ConsoleInput(), new ConsoleOutput());
    g.pInteractor.setGold(100);
    g.mInteractor.load("Square");
    g.maze = g.mInteractor.maze;
    g.setLocationToSpawn();
    g.move(Direction.South);
    g.move(Direction.North);
    g.move(Direction.East);
    g.move(Direction.West);




  }
}
