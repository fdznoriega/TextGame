package Domain.Interactors;

import Domain.Entities.Maze;
import Domain.Entities.TileType;
import Domain.Entities.Tile;
import Domain.Interfaces.IMazeInteractorOutput;
import Domain.Interfaces.IMazeInteractor;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;

//this interactor reads data from levels folder
//another maze interactor could read data from another source.
public class MazeInteractor implements IMazeInteractor {

  public Maze maze;
  public IMazeInteractorOutput output;

  // initializes maze given a filename
  public void load(String fileName) {
    // convert the file into a string
    String content = levelToString(fileName);
    // check if null
    if(content == null) {
      output.showFileToStringFailure();
      this.maze = null;
      return;
    }
    // find edges of string [  ] that indicate maze notation
    int[] e = findEdges(content);
    if(e == null) {
      output.showEdgesNotFound();
      this.maze = null;
      return;
    }
    // iterate from first edge to last edge to obtain:
    // 1. the dimensions of the string
    // 2. the tiles we need
    int leftEdge = e[0];
    int rightEdge = e[1];
    int row = 1;  // traversing first row first
    int column = 0; // counting columns from 0
    boolean columnChecked = false;
    ArrayList<Tile> tiles = new ArrayList<Tile>();
    for(int i = leftEdge; i < rightEdge; i++) {
      // if '(' then scan up to ')' and generate/add tile to tiles
      if(content.charAt(i) == '(') {
        // scan and find length
        String almostTile = "";
        while(content.charAt(i) != ')') {
          if(content.charAt(i) != ' ') {
            almostTile += String.valueOf(content.charAt(i));
            i += 1;
          }
        }
        almostTile += ")";
        // almostTile -> (AA,1)
        Tile t = new Tile(almostTile);
        tiles.add(t);
      }
      // if '\n' or ']' then row + 1. count columns ONCE
      else if(content.charAt(i) == '\n' || content.charAt(i) == ']') {
        row++;
        // count columns
        int j = 0;
        while(j < i && !columnChecked) {
          if(content.charAt(j) == '(') {
            column++;
          }
          j++;
        }
        columnChecked = true;
      }
      // any other char is irrelevant.
      else {
        // nothing.
      }
    }
    // create an empty maze which will be filled.
    Maze m = new Maze(new int[] {row, column});
    // iterate through empty maze and insert values from tiles
    int fullCount = 0;
    for(int i = 0; i < row; i++) {
      for(int j = 0; j < column; j++) {
        m.matrix[i][j] = tiles.get(fullCount);
        fullCount += 1;
      }
    }
    // update this.maze
    output.loadSuccess();
    this.maze = m;
    this.maze.row = row;
    this.maze.column = column;
  }

  //find spawn of maze. TileType : Spawn | ID : 1
  public int[] findSpawn() {
    if(this.maze == null) {
      output.showMazeNotInitialized();
      return null;
    }
    Maze m = this.maze;
    for(int i = 0; i < m.row; i++) {
      for(int j = 0; j < m.column; j++) {
        Tile t = m.matrix[i][j];
        if(t.type == TileType.Spawn && t.id == 1) {
          return new int[] {i,j};
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

  // fetch tile given coordinates
  public Tile fetchTile(int[] coords) {
    return maze.matrix[coords[0]][coords[1]];
  }


  // -- Private Methods -- \\
  //turns files under level into string
  private String levelToString(String fileName) {
    //path TextGame folder and reach desired level
    String dir = System.getProperty("user.dir") + "/Data/Levels/" + fileName + ".txt";
    try {
      String content = new String(Files.readAllBytes(Paths.get(dir)));
      return content;
    }
    catch (IOException e) {
      return null;
    }
  }

  private int[] findEdges(String content) {
    int i = 0;
    int j = 0;
    boolean leftBracket = false;
    boolean rightBracket = false;
    // find left bracket
    for(i = 0; i < content.length(); i++) {
      if(content.charAt(i) == '[') {
        leftBracket = true;
        break;
      }
    }
    // find right bracket
    for(j = content.length() - 1; j > 0; j--) {
      if(content.charAt(j) == ']') {
        rightBracket = true;
        break;
      }
    }
    // check both
    if(leftBracket && rightBracket) {
      return new int[] {i, j};
    } else {
      return null;
    }
  }

}
