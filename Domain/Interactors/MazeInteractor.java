package Domain.Interactors;

import Domain.Entities.Maze;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

//this interactor reads data from levels folder
//another maze interactor could read data from another source.
public class MazeInteractor {

  public Maze maze;
  public IMazeInteractorOutput mOut;

  //initializes maze from given level text file.
  public void initializeMaze(String fileName) {
    //turn file into string content
    String content;
    int[] d;
    try {
      content = levelFileToString(fileName);
    }
    catch(Exception e) {
      mOut.showReadFailure();
      return;
    }
    //get dimensions of that content
    try {
      d = stringMatrixDimension(content);
    }
    catch(NullPointerException e) {
      mOut.showDimensionFailure();
      return;
    }
    //make empty matrix from those dimensions
    //fill zero matrix
    try {
      Maze wipMaze = new Maze(d);
      wipMaze.matrix = transcribeMatrix(d, content);
    }
    catch(Exception e) {
      mOut.showMatrixFailure();
      return;
    }
    //show success
    mOut.showInitializeSuccess();
  }

  //find location given id -- WIP METHOD
  public int[] locateSpace(int id) {
    switch(id) {
      case 1: //spawn
      case 4: //treasure
    }
    return new int[] {0,0};
  }

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
    int[][] matrix = new int[d[0]][d[1]];
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

}
