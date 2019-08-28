package Tests;

import Domain.Entities.*;
import Domain.Interactors.*;
import Game.ConsoleUserInterface;

public class MazeTester {
  public static void main(String[] args) {
    //Setup the output
    ConsoleUserInterface cui = new ConsoleUserInterface();
    MazeInteractor mInteractor = new MazeInteractor();
    mInteractor.mOut = cui;
    //Initialize Maze
    mInteractor.initializeMaze("level1");
    //Print it out.
    String mazeDuplicate = mInteractor.maze.toString();
    System.out.println(mazeDuplicate);


  }
}
