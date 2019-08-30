package Domain.Interactors;

import Domain.Entities.Maze;

public interface IMazeInteractorOutput {
  void showMaze(Maze m);
  void showInitializeSuccess();
  void showDimensionSuccess();
  void showMatrixSuccess();
  void showMatrixFailure();
  void showDimensionFailure();
  void showReadFailure();
  void showReadSuccess();
  void showFindSpawnFailure();
  void showFindSpawnSuccess();
}
