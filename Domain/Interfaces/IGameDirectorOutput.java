package Domain.Interfaces;

public interface IGameDirectorOutput extends IPlayerInteractorOutput {
  void showCannotMoveNorth();
  void showCannotMoveSouth();
  void showCannotMoveEast();
  void showCannotMoveWest();

}
