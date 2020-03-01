package Domain;

import java.io.IOException;
import Domain.Entities.Direction;
import Domain.Interactors.PlayerInteractor;
import Domain.Entities.Player;
import Domain.Interactors.MazeInteractor;
import Domain.Entities.Maze;
import Domain.Entities.Tile;
import Domain.Interfaces.IGameDirectorOutput;
// import Domain.Interfaces.IGameDirectorInput;



// Game Director
// 1. take input from X source
// 2. move elements around
// 3. output result


public class GameDirector {

  public Player player;
  public int[] location; //player's location on the board
  public Maze maze;
  public PlayerInteractor pInteractor;
  public MazeInteractor mInteractor;
  // public IGameDirectorInput input;
  public IGameDirectorOutput output;

  // set player location
  private void setInitialLocation() {
    this.location = mInteractor.findSpawn();
  }

  // checks if moving in direction d is ok
  public void movePlayer(Direction d) {
    int row = this.maze.row;
    int column = this.maze.column;
    Tile check; // may not initialize and error will be caught
    switch(d) {
      case North:
              // check above
              check = maze.matrix[location[0] - 1][location[1]];
              if(check != null) {
                this.location[0] = location[0] - 1;
              }
              else {
                output.showCannotMoveNorth();
                return;
              }
              break;
      case South:
              // check below
              check = maze.matrix[location[0] + 1][location[1]];
              if(check != null) {
                this.location[0] = location[0] + 1;
              }
              else {
                output.showCannotMoveSouth();
                return;
              }
              break;
      case East:
              // check right
              check = maze.matrix[location[0]][location[1] + 1];
              if(check != null) {
                this.location[1] = location[1] + 1;
              }
              else {
                output.showCannotMoveEast();
                return;
              }
              break;
      case West:
              // check left
              check = maze.matrix[location[0]][location[1] - 1];
              if(check != null) {
                this.location[1] = location[1] - 1;
              }
              else {
                output.showCannotMoveWest();
                return;
              }
              break;
      default: return;
    }

  }
  // menu calls the player/user can make
  public void openSettingsMenu() {
    //
  }

  // inventory calls the player/user can make
  public void openInventory() {

  }

  public void useItem() {

  }

  public void equipItem() {

  }

  public static void main(String[] args) {
    GameDirector d;

  }



  // what can the player do:
  // move player character in cardinal directions
  // battle -> stats change but player does not change them
  // open settings menu
  // open inventory
  // equip items
}
