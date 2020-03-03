package Tests;

import Domain.Entities.*;
import Domain.Interactors.*;
import Domain.IO.ConsoleUserInterface;
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
    // test load maze method with various matrix sizes
    // square
    mInteractor.load("Square");
    String s = mInteractor.maze.toString();
    System.out.println(s);
    int[] l = mInteractor.findSpawn();
    System.out.println("Spawn: " + l[0] + ":" + l[1]);
    // more columns than rows
    mInteractor.load("MoreColumn");
    s = mInteractor.maze.toString();
    System.out.println(s);
    l = mInteractor.findSpawn();
    System.out.println("Spawn: " + l[0] + ":" + l[1]);
    // more rows than columns
    mInteractor.load("MoreRow");
    s = mInteractor.maze.toString();
    System.out.println(s);
    l = mInteractor.findSpawn();
    System.out.println("Spawn: " + l[0] + ":" + l[1]);
    // a vertical line
    mInteractor.load("Line");
    s = mInteractor.maze.toString();
    System.out.println(s);
    l = mInteractor.findSpawn();
    System.out.println("Spawn: " + l[0] + ":" + l[1]);
    // test find spawn



  }
}
