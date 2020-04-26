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

  // checks if moving in direction d is ok


  // workflow of move()
  // 1. Check if desired location is steppable.
  // 2. Step on desired location (update location)
  // 3. Trigger action on new space.
  public void move(Direction d) {
    int row = this.maze.row;
    int column = this.maze.column;
    // 1. Check if steppable
    Boolean steppable = isSteppable(d);
    if(!steppable) {
      this.output.showCannotMove(d);
      return;
    }
    // 2. Update direction
    switch(d) {
      case North: this.location[0] -= 1; break;
      case South: this.location[0] += 1; break;
      case East: this.location[1] += 1; break;
      case West: this.location[1] -= 1; break;
      default: return;
    }
    this.output.showMoved(d);
    // 3. Act
    Tile steppedOn = this.mInteractor.fetchTile(this.location);
    event(steppedOn);
    // if action completed, transform tile into walking tile...?
  }

  // can't step if boundary or obstacle
  public Boolean isSteppable(Direction d) {
    if(outOfBounds(d)) {
      return false;
    }
    else {
      return true;
    }
  }

  // returns true if moving in a direction puts us out of bounds
  public Boolean outOfBounds(Direction d) {
    int row = this.maze.row;
    int column = this.maze.column;
    int index;
    switch(d) {
      case North:
        index = this.location[0] - 1;
        if(index >= 0 && index < row) {
          return false;
        }
        break;
      case South:
        index = this.location[0] + 1;
        if(index >= 0 && index < row) {
          return false;
        }
        break;
      case East:
        index = this.location[1] + 1;
        if(index >= 0 && index < column) {
          return false;
        }
        break;
      case West:
        index = this.location[1] - 1;
        if(index >= 0 && index < column) {
          return false;
        }
      default: return true;
    }
    return true;
  }


  public void event(Tile t) {
    System.out.println(t.toString());
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
