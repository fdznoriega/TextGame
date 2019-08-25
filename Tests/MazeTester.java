package Tests;

import Domain.Entities.*;
import Domain.Interactors.*;
import Game.ConsoleUserInterface;

public class MazeTester {
  public static void main(String[] args) {
    Maze m;
    ConsoleUserInterface cli = new ConsoleUserInterface();
    MazeInteractor mInteractor = new MazeInteractor();
    mInteractor.maze = m;
    mInteractor.mOut = cui;

    mInteractor.initializeMaze("level1");

  }
}
