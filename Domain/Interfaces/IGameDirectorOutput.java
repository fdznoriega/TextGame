package Domain.Interfaces;

public interface IGameDirectorOutput extends
  IPlayerInteractorOutput, IMazeInteractorOutput {
  // movement output
  void showCannotMoveNorth();
  void showCannotMoveSouth();
  void showCannotMoveEast();
  void showCannotMoveWest();
  void showMovedNorth();
  void showMovedSouth();
  void showMovedEast();
  void showMovedWest();
  // gameplay menus
  // void showInventoryMenu();
  // void showStatsMenu();
  // void showSettingsMenu();
  // void showMainMenu();

}
