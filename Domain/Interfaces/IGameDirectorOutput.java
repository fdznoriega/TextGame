package Domain.Interfaces;

import Domain.Entities.Direction;

public interface IGameDirectorOutput extends
  IPlayerInteractorOutput, IMazeInteractorOutput {
  // movement output
  void showCannotMove(Direction d);
  void showMoved(Direction d);
  // gameplay menus
  // void showInventoryMenu();
  // void showStatsMenu();
  // void showSettingsMenu();
  // void showMainMenu();

}
