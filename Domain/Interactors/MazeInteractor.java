package Domain.Interactors;

import Domain.Entities.Maze;
import Domain.Interfaces.IMazeInteractorOutput;
import Domain.Interfaces.IMazeInteractor;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

//this interactor reads data from levels folder
//another maze interactor could read data from another source.
public class MazeInteractor implements IMazeInteractor {

  public Maze maze;
  public IMazeInteractorOutput output;

  //initializes maze from given level text file
  //consider how to make abstract
  public void createFromFile(String fileName) {
    //file -> string
    int startingPoint = -1;
    int endPoint = -1;
    int row = 0;
    int column = 0;
    boolean columnChecked = false;
    String content;
    int[] d;
    Maze wipMaze;
    try {
      content = levelToString(fileName);
    }
    catch(Exception e) {
      output.showReadFailure();
      return;
    }
    //scan through string and get dimensions
    System.out.println(content.length());
    //fetch start and end points & row + column
    for(int i = 0; i < content.length(); i++) {
      if(content.charAt(i) == '[') {
        startingPoint = i;
      }
      if(content.charAt(i) == ']') {
        endPoint = i;
      }
      if(content.charAt(i) == '\n') {
        row++;
        // enter inner loop to find columns
        int j = 0;
        while(j < i && !columnChecked) {
          if(content.charAt(j) == '(') {
            column++;
          }
          j++;
        }
        columnChecked = true;
      }

    }
    // check to see if edges found found
    System.out.println(startingPoint + "," + endPoint);
    System.out.println(row + "," + column);

    if(startingPoint == -1 || endPoint == -1) {
      output.showMatrixFailure();
      return;
    }
    // read tiles
    for(int i = startingPoint; i < endPoint; i++) {
      if(content.charAt(i) == '(') {
        // read tile
      }
    }

  }

  //find spawn of maze. Key is given to be 1.
  //TO DO
  public int[] findSpawn() {
    return null;
  }

  //fetches dimensions of the maze
  public int[] fetchDimension() {
    return new int[] { maze.row, maze.column };
  }


  // -- Private Methods -- \\
  //turns files under level into string
  private String levelToString(String fileName) {
    //path TextGame folder and reach desired level
    String dir = System.getProperty("user.dir") + "/Data/Levels/" + fileName + ".txt";
    try {
     String content = new String(Files.readAllBytes(Paths.get(dir)));
     System.out.println(content);
     return content;
    }
    catch (IOException e) {
      return null;
    }
  }


}
