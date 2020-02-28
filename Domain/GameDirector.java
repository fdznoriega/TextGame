import Domain.Entities.Direction;

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

  // set player location
  private void setInitialLocation() {
    this.location = mInteractor.findSpawn();
  }

  // checks if moving in direction d is ok
  public void movePlayer(Direction d) {
    int row = this.maze.row;
    int column = this.maze.column;
    switch(d) {
      case 1: d == Direction.North;
              // check if space above is in array
              try {
                maze.matrix[location[0] - 1][location[1]];
                location[0] = location[0] - 1;
              }
              catch(IOException) {
                output.showCannotMoveNorth();
                return false;
              }
              break;
      case 2: d == Direction.South;
              // check if space below is in array
              try {
                maze.matrix[location[0] + 1][location[1]];
                location[0] = location[0] + 1;
              }
              catch(IOException) {
                output.showCannotMoveSouth();
                return false;
              }
              break;
      case 3: d == Direction.East;
              // check if space right is in array
              try {
                maze.matrix[location[0]][location[1] + 1];
                location[0] = location[1] + 1;
              }
              catch(IOException) {
                output.showCannotMoveEast();
                return false;
              }
              break;
      case 4: d == Direction.West;
              // check if space left is in array
              try {
                maze.matrix[location[0]][location[1] - 1];
                location[0] = location[1] - 1;
              }
              catch(IOException) {
                output.showCannotMoveWest();
                return false;
              }
              break;
      default: return false;
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

  }



  // what can the player do:
  // move player character in cardinal directions
  // battle -> stats change but player does not change them
  // open settings menu
  // open inventory
  // equip items
}
