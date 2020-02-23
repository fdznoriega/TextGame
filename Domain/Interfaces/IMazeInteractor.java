package Domain.Interfaces;

//import ...

public interface IMazeInteractor {
  void createFromFile(String fileName);
  int[] findSpawn();
  int[] fetchDimension();

  // redesign methods:
  // void load(String fileName) -> loads using method found in maze
  // int[] findSpawn
  //
}
