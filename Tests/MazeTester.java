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
    System.out.println("Testing tile constructor");
    Tile t = new Tile("(EN,1)");
    System.out.println(t.toString());
    // test load maze method
    mInteractor.load("level1");
    String s = mInteractor.maze.toString();
    System.out.println(s);


  }
}
