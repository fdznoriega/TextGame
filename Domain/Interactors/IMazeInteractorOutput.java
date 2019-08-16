package Domain.Interactors;

public interface IMazeInteractorOutput {
  void showMaze();
  void showInitializeSuccess();
  void showDimensionSuccess();
  void showMatrixSuccess();
  void showMatrixFailure();
  void showDimensionFailure();
  void showReadFailure();
  void showReadSuccess();
}
