package Tests;

import Domain.Entities.*;
import Domain.Interactors.*;
import Game.ConsoleUserInterface;
import Domain.Interfaces.*;

public class MazeTester {
  public static void main(String[] args) {
    //Setup the output
    ConsoleUserInterface cui = new ConsoleUserInterface();
    MazeInteractor mInteractor = new MazeInteractor();
    mInteractor.output = cui;
    //Initialize Maze
    mInteractor.createFromFile("level1");


  }
}
