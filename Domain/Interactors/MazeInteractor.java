package Domain.Interactors;

import Domain.Entities.Maze;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class MazeInteractor {

  public Maze maze;
  public IMazeInteractorOutput mOut;

  public void initializeMaze(String fileName) {
    //turn file into string content
    String content = textFileToString(fileName);
    //get dimensions of that content
    int[] d = stringMatrixDimension(content);
    //make empty matrix from those dimensions
    Maze m = new Maze(d);
    //fill zero matrix
    //m.matrix = fillMatrix(content);
    //show success

  }

  private static String textFileToString(String fileName) {
    String userDir = System.getProperty("user.dir");
	 	return fileToString(userDir + "/Levels/" + fileName + ".txt");
  }

  private static int[] stringMatrixDimension(String content) {
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

  //finds/turns text file into string given a file name
  private static String fileToString(String p) {
     try {
			String content = new String(Files.readAllBytes(Paths.get(p)));
			return content;
		}
    catch (IOException e) {
			return null;
		}
	}

}
