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
  public void initializeMaze(String fileName) {
    //turn file into string content
    String content;
    int[] d;
    Maze wipMaze;
    try {
      content = levelFileToString(fileName);
    }
    catch(Exception e) {
      output.showReadFailure();
      return;
    }
    //get dimensions of that content
    try {
      d = stringMatrixDimension(content);
    }
    catch(NullPointerException e) {
      output.showDimensionFailure();
      return;
    }
    //make empty matrix from those dimensions
    //fill zero matrix
    try {
      wipMaze = new Maze(d);
      wipMaze.matrix = transcribeMatrix(d, content);
    }
    catch(Exception e) {
      output.showMatrixFailure();
      return;
    }
    //assign completed maze to the interactor
    this.maze = wipMaze;
    //show success
    output.showInitializeSuccess();
  }

  //find spawn of maze. Key is given to be 1.
  public int[] findSpawn() {
    for(int r = 0; r < maze.row; r++) {
      for(int c = 0; c < maze.column; c++) {
        if(maze.matrix[r][c] == 1) {
          output.showFindSpawnSuccess();
          return new int[] {r, c};
        }
      }
    }
    output.showFindSpawnFailure();
    return null;
  }

  //fetches dimensions of the maze
  public int[] fetchDimension() {
    return new int[] { maze.row, maze.column };
  }


  // -- Private Methods -- \\
  //turns files under level into string
  private static String levelFileToString(String fileName) {
    //path TextGame folder and reach desired level
    String dir = System.getProperty("user.dir") + "/Data/Levels/" + fileName + ".txt";
	 	return fileToString(dir);
  }

  //finds and turns text file into string given a file name
  private static String fileToString(String p) {
     try {
			String content = new String(Files.readAllBytes(Paths.get(p)));
			return content;
		}
    catch (IOException e) {
			return null;
		}
	}

  //browses through string maze and returns dimensions
  private static int[] stringMatrixDimension(String content) {
    if(content == null) {
      return null;
    }
    int r = 0;
		int c = 0;
		for(int i = 0; i < content.length(); i++) {
			//"]" is the EOF flag, so break.
			if(content.charAt(i) == ']') {
				//sub 1 to column so we don't count the extra column.
				c--;
				break;
			}
			//we've reached a new row.
			else if(content.charAt(i) == '\n') {
				r++;
				c = 0;
			}
			//we've reached a new column.
			else if(content.charAt(i) == ' ') {
				//idle.
			}
			else {
				c++;
			}
		}
		//incresae D by 1 bc we will use it to create an array.
		int[] dimensions = {r + 1 , c + 1};
		return dimensions;
  }

  //copies a zero int matrix from a char matrix
  private static int[][] transcribeMatrix(int[] d, String content) {
    int r = 0;
		int c = 0;
    int[][] matrix = new Tile[d[0]][d[1]];
		for(int i = 0; i < content.length(); i++) {
			//"]" is the EOF flag, so break.
			char currentChar = content.charAt(i);
			if(currentChar == ']') {
				break;
			}
			//we've reached a new row.
			else if(currentChar == '\n') {
				r += 1;
				c = 0;
			}
			//we've reached a new column.
			else if(currentChar == ' ') {
				//idle.
			}
			else {
				//convert char to int and put it in the grid.
				matrix[r][c] = Integer.parseInt(String.valueOf(currentChar));
				c++;
			}
		}
    return matrix;
  }

  // converts string item into tile item
  private static Tile stringToTile(String s) {
    switch(s) {
      case '0': return new Tile ;
      case 'W':
      case 'B':
      case 'E':
      case 'T':
      case 'F':
    }
  }

}
