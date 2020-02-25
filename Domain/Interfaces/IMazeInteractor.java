package Domain.Interfaces;

//import ...

public interface IMazeInteractor {
  void load(String fileName);
  int[] findSpawn();
  int[] fetchDimension();

  // redesign methods:
  // void load(String fileName) -> loads using method found in maze
  // int[] findSpawn
  //
}
