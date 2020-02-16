import Domain.Entities.Direction;

// Game Director
// 1. take input from X source
// 2. move elements around
// 3. output result


public class GameDirector {

  public Player player;
  public Maze maze;
  public PlayerInteractor pInteractor;
  public MazeInteractor mInteractor;
  public IGameDirectorInput input;
  public IGameDirectorOutput output;

  // movement calls the player can make
  public void movePlayer(Direction d) {
    //uses maze interactor to move player in desired direction
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
