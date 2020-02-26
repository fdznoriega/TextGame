package Domain.Interfaces;

//import ...

public interface IMazeInteractor {
  void load(String fileName);
  int[] findSpawn();
  int[] fetchDimension();
}
