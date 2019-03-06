/* What does "Game" Do?
 * Receives text inputs from console
 * Handles exploration
 * Handles battles (experience, attack, calculations.)
 * Handles level ups and scaling.
 * Loads a save file.
 * Updates a save file.
 * Creates a save file.
*/

import java.io.IOException;
import java.util.Scanner;


import java.nio.file.Files;
import java.nio.file.Paths;

public class Game {


  public static void main(String[] args) {

    //Setup
    Scanner textInput = new Scanner(System.in);
    boolean isPlaying = true;
    Player p = new Player();
    int[] location = new int[2];  //array of 2 values bc row & column.

    //Load Map
    Map m1 = loadMap("level1");
    System.out.println(m1.row + " " + m1.column);

    //Update location to spawn point.
    location = findSpawn(m1);

    //Start
    System.out.println("INITIALIZED MAZE");

    //Game loop
    while(isPlaying) {
      //use switch instead?
      String playerInput = textInput.nextLine().replaceAll(" ", "").toUpperCase();

      //---------Pseudo Menus---------
      if(playerInput.equals("QUIT")) {
        //quit game
        isPlaying = false;
      }
      else if(playerInput.equals("SAVE")) {
        //save game
        System.out.println("GAME SAVED.");
      }
      else if(playerInput.equals("I")) {
        //open inventory
      }
      else if(playerInput.equals("E")) {
        //open equipment
      }

      //---------Moving Around---------
      //move(Map, Location, Direction)
      location = move(m1, location, playerInput);


      System.out.println(m1.grid[location[0]][location[1]]);

    }

  }

  //Fetch file from its given name in string form
	//Returns string of file's contents.
	public static String fileToString(String p) {
		try {
			String content = new String(Files.readAllBytes(Paths.get(p)));
			return content;
		}
    catch (IOException e) {
			System.out.println("Could not retrieve file.");
			return null;
		}
	}

  //Moves player to a certain location
  //returns new location
  public static int[] move(Map m1, int[] l, String dir) {
    if(dir.equals("NORTH")) {
      if(l[0] - 1 < 0) {
        System.out.println("Can't move that way.");
      }
      else {
        l[0] -= 1;
      }
    }
    else if(dir.equals("SOUTH")) {
      if(l[0] + 1 >= m1.row) {
        System.out.println("Can't move that way.");
      }
      else {
        l[0] += 1;
      }
    }
    else if(dir.equals("WEST")) {
      if(l[1] - 1 < 0) {
        System.out.println("Can't move that way.");
      }
      else {
        l[1] -= 1;
      }
    }
    else if(dir.equals("EAST")) {
      if(l[1] + 1 >= m1.column) {
        System.out.println("Can't move that way.");
      }
      else {
        l[1] += 1;
      }
    }
    else {
      return l;
    }
    return l;
  }

  //Take player data and input it in a .txt file.
  public int save() {
    return 0;
  }

  //Move player data from a .txt file into the game player.
  public int load() {
    return 0;
  }

  //Refill player's current HP to match max hp.
  public int refresh() {
    return 0;
  }

  //Battles.
  public int battle() {
    return 0;
  }

  //Loads a map from a given txt file.
	public static Map loadMap(String s) {
    //Map m = new loadMap("level1.txt");
    String userDir = System.getProperty("user.dir");
	 	String content = fileToString(userDir + "/Levels/" + s + ".txt");

		//set up map we'll play with.
		int[] d = Map.fetchDimensions(content);
		Map map = new Map(d);
		map.fillMap(content);
		return map;
  }

  //Finds the spawn point and returns the row-column location as an array
  public static int[] findSpawn(Map m) {
    for(int r = 0; r < m.row; r++) {
      for(int c = 0; c < m.column; c++) {
        if(m.grid[r][c] == 1) {
          int[] l = {r, c};
          return l;
        }

      }
    }
    return null;
  }

  //this function will trigger game functions
  public void event(int tileNum) {

    switch(tileNum) {
      //1 is a spawn tile
      case 1: break;
      //2 is a walk tile.
      case 2: break;
      //3 is a enemy tile.
      case 3: //battle();
              break;
      //4 is a treasure tile.
      case 4: //openTreasure();
              break;
      //5 is a refresh tile.
      case 5: //refreshPlayer();
              break;
      //6 is a boss tile.
      case 6: //bossBattle();
              break;

    }

  }
}
