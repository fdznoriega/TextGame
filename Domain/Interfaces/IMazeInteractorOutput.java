package Domain.Interfaces;

import Domain.Entities.Maze;

public interface IMazeInteractorOutput {
  void showMaze(Maze m);
  void loadSuccess();
  void showFileToStringFailure();
  void showEdgesNotFound();
  void showMatrixNotSquare();




}
