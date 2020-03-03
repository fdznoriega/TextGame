package Domain;

import java.io.IOException;
import Domain.Entities.Direction;
import Domain.Interactors.PlayerInteractor;
import Domain.Entities.Player;
import Domain.Interactors.MazeInteractor;
import Domain.Entities.Maze;
import Domain.Entities.Tile;
import Domain.Entities.TileType;
import Domain.Interfaces.IGameDirectorOutput;
import Game.ConsoleUserInterface;
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

  // default constructor
  public GameDirector() {
    this.player = new Player();
    this.output = new ConsoleUserInterface();
    pInteractor = new PlayerInteractor(this.player, this.output);
    mInteractor = new MazeInteractor();
    mInteractor.output = new ConsoleUserInterface();
  }
  // set player location
  public void setLocationToSpawn() {
    this.location = mInteractor.findSpawn();
  }

  // checks if moving in direction d is ok
  public void move(Direction d) {
    int row = this.maze.row;
    int column = this.maze.column;
    switch(d) {
      case North:

      case South:

      case East:

      case West:


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




  // what can the player do:
  // move player character in cardinal directions
  // battle -> stats change but player does not change them
  // open settings menu
  // open inventory
  // equip items
}
