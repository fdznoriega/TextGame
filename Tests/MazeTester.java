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
    mInteractor.initializeMaze("level2");
    //Print it out.
    String mazeDuplicate = mInteractor.maze.toString();
    System.out.println(mazeDuplicate);
    //Find the spawn
    int[] spawnLocation = mInteractor.findSpawn();
    //top left corner = 0,0
    System.out.println(spawnLocation[0] +  " , " + spawnLocation[1]);
    //get the dimensions
    int[] d = mInteractor.fetchDimension();
    System.out.println("Dimensions: " + d[0] + " , " + d[1]);


  }
}
