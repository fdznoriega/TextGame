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
import Domain.Entities.Item;
import Domain.Entities.Stats;


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

  public GameDirector(IGameDirectorInput input, IGameDirectorOutput output) {
    this.player = new Player();
    this.input = input;
    this.output = output;
    pInteractor = new PlayerInteractor(this.player, output);
    mInteractor = new MazeInteractor();
    mInteractor.output = output;
  }

  // asks for an input and stores it.
  private void fetch() {
    this.input.request();
  }

  // reacts based on the type of input
  private void react() {
    // check what is currently in the input
    String s = this.input.toString();
    switch(s) {
      case "north":
    }
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
  public void openSettingsMenu() {
    //
  }

  // inventory calls the player/user can make
  public void openInventoryMenu() {

  }

  public void useItem() {

  }

  // === helper methods ===

  // player interactor
  public void setStats(Stats s) {
    this.pInteractor.statsInteractor.setStats(s);
  }

  public void setCurrentHp(int cHp) {
    this.pInteractor.statsInteractor.setCurrentHp(cHp);
  }

  public void setMaxHp(int mHp) {
    this.pInteractor.statsInteractor.setMaxHp(mHp);
  }

  public void setAttack(int att) {
    this.pInteractor.statsInteractor.setAttack(att);
  }

  public void setDefense(int def) {
    this.pInteractor.statsInteractor.setDefense(def);
  }

  public void setSpeed(int spd) {
    this.pInteractor.statsInteractor.setSpeed(spd);
  }

  public void setXp(int x) {
    this.pInteractor.statsInteractor.setXp(x);
  }

  public void setLvl(int l) {
    this.pInteractor.statsInteractor.setLvl(l);
  }

  public void setGold(int g) {
    this.pInteractor.statsInteractor.setGold(g);
  }

  public void insertItem(Item item) {
    this.pInteractor.invenInteractor.insertItem(item);
  }

  public void equipItem(Item item) {
    this.pInteractor.invenInteractor.equipItem(item);
  }

  public void removeItem(Item item) {
    this.pInteractor.invenInteractor.removeItem(item);
  }

  public void unequipItem(Item item) {
    this.pInteractor.invenInteractor.unequipItem(item);
  }

  public void clearEquipment() {
    this.pInteractor.invenInteractor.clearEquipment();
  }

  // maze interactor
  public void loadMap(String fileName) {
    this.mInteractor.load(fileName);
    this.maze = this.mInteractor.maze;
    this.location = this.mInteractor.findSpawn();
  }

}
