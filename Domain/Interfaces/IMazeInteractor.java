package Domain.Interfaces;

//import ...

public interface IMazeInteractor {
  void createFromFile(String fileName);
  int[] findSpawn();
  int[] fetchDimension();
}
