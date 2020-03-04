package Domain.Interactors;

import java.io.IOException;
import Domain.Entities.Direction;
import Domain.Interactors.PlayerInteractor;
import Domain.Entities.Player;
import Domain.Interactors.MazeInteractor;
import Domain.Entities.Maze;
import Domain.Entities.Tile;
import Domain.Entities.TileType;
import Domain.Interfaces.IGameDirectorOutput;
import Domain.Interfaces.IGameDirectorInput;

// remove this soon. it is being used in the empty constructor
import Domain.IO.ConsoleOutput;


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
  public IGameDirectorInput input;
  public IGameDirectorOutput output;

  // default constructor
  public GameDirector() {
    this.player = new Player();
    this.output = new ConsoleOutput();
    pInteractor = new PlayerInteractor(this.player, this.output);
    mInteractor = new MazeInteractor();
    mInteractor.output = new ConsoleOutput();
  }

  // what i want game director to look like?
  public GameDirector(IGameDirectorInput input, IGameDirectorOutput output) {
    this.player = new Player();
    this.input = input;
    this.output = output;
    pInteractor = new PlayerInteractor(this.player, output);
    mInteractor = new MazeInteractor();
    mInteractor.output = output;
  }

  // set player location
  public void setLocationToSpawn() {
    this.location = mInteractor.findSpawn();
  }

  // checks if moving in direction d is ok
  public void move(Direction d) {
    int row = this.maze.row;
    int column = this.maze.column;
    int index;
    switch(d) {
      case North:
        index = location[0] - 1;
        if(index >= 0 && index < row) {
          this.location[0] -= 1;
          output.showMovedNorth();
        }
        else {
          output.showCannotMoveNorth();
          return;
        }
        break;
      case South:
        index = location[0] + 1;
        if(index >= 0 && index < row) {
          this.location[0] += 1;
          output.showMovedSouth();

        }
        else {
          output.showCannotMoveSouth();
          return;
        }
        break;
      case East:
        index = location[1] + 1;
        if(index >= 0 && index < column) {
          this.location[1] += 1;
          output.showMovedEast();

        }
        else {
          output.showCannotMoveEast();
          return;
        }
        break;
      case West:
        index = location[1] - 1;
        if(index >= 0 && index < column) {
          this.location[1] -= 1;
          output.showMovedWest();

        }
        else {
          output.showCannotMoveWest();
        }
      default: return;
    }

  }

  // menu calls the player/user can make
  public void openSettings() {
    //
  }

  // inventory calls the player/user can make
  public void openInventory() {

  }

  public void useItem() {

  }

  public void equipItem() {

  }




  // what can the player do:
  // move player character in cardinal directions
  // battle -> stats change but player does not change them
  // open settings menu
  // open inventory
  // equip items
}
