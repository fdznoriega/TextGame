package Domain.Interfaces;

//import ...

public interface IMazeInteractor {
  void initializeMaze(String fileName);
  int[] findSpawn();
  int[] fetchDimension();
}
