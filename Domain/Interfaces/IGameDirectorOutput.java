package Domain.Interfaces;

public interface IGameDirectorOutput extends IPlayerInteractorOutput {
  void showCannotMoveNorth();
  void showCannotMoveSouth();
  void showCannotMoveEast();
  void showCannotMoveWest();
  void showMovedNorth();
  void showMovedSouth();
  void showMovedEast();
  void showMovedWest();

}