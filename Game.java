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

    //---------Setup---------
    Scanner textInput = new Scanner(System.in);
    boolean isPlaying = true;
    Player p = new Player();
    int[] location = new int[2];  //array of 2 values bc row & column.
    int[] prevLocation = new int[2]; //array that keeps track of prev value.

    //---------Load Map---------
    Map m1 = loadMap("level1");
    //System.out.println(m1.row + " " + m1.column);

    //---------Update location to spawn point---------
    location = findSpawn(m1);

    //---------Start Game---------
    System.out.println("INITIALIZED MAZE");

    //---------Game loop---------
    while(isPlaying) {
      //trash previous location calculation. won't work.

      //Print stuff for debug.
      System.out.println(location[0] + ":" + location[1]);
      System.out.println(m1.grid[location[0]][location[1]]);

      //Take input from player.
      String playerInput = textInput.nextLine().replaceAll(" ", "").toUpperCase();


      //---------Possible Interactions---------
      //1. Systems Management
      if(isSystem(playerInput)) {

        if(playerInput.equals("QUIT")) {
          isPlaying = false;
        }
        else if(playerInput.equals("SAVE")) {
          //save game
          System.out.println("GAME SAVED.");
        }
        else if(playerInput.equals("I")) {
          //show inventory

        }
        else if(playerInput.equals("E")) {
          //show equipment

        }
      }
      //2. Adventuring
      else if(isAdventure(playerInput)) {

        //Let's try move player where they want to go.
        if(view(m1, location, playerInput) == 0) {
          System.out.println("Can't move that way.");
        }
        else {
          //Update location based on where the player wants to move.
          location = move(m1, location, playerInput);

          //Are we near the boss? Let's notify the player.
          if(bossNear(m1, location)) {
            System.out.println("The boss is near...");
          }
        }


      }
      //3. Wrong Input
      else {
        System.out.println("I didn't quite catch that...");
      }

    }
    System.out.println("Thanks for playing");
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
  //---UPDATE---
  public static int[] move(Map m1, int[] l, String dir) {
    //System.out.println("Move method called.");
    if(dir.equals("NORTH")) {
      //Check if the tile above is out of bounds or 0.
      if(l[0] - 1 < 0 || m1.grid[l[0] - 1][l[1]] == 0) {
        //System.out.println("Can't move that way.");
      }
      else {
        l[0] -= 1;
        System.out.println("Moved " + dir);
        return l;
      }

    }
    else if(dir.equals("SOUTH")) {
      if(l[0] + 1 >= m1.row || m1.grid[l[0] + 1][l[1]] == 0) {
        //System.out.println("Can't move that way.");
      }
      else {
        l[0] += 1;
        System.out.println("Moved " + dir);
        return l;
      }

    }
    else if(dir.equals("WEST")) {
      if(l[1] - 1 < 0 || m1.grid[l[0]][l[1] - 1] == 0) {
        //System.out.println("Can't move that way.");
      }
      else {
        l[1] -= 1;
        System.out.println("Moved " + dir);
        return l;
      }

    }
    else if(dir.equals("EAST")) {
      if(l[1] + 1 >= m1.column || m1.grid[l[0]][l[1] + 1] == 0) {
        //System.out.println("Can't move that way.");
      }
      else {
        l[1] += 1;
        System.out.println("Moved " + dir);
        return l;
      }

    }

    System.out.println("Did not move.");
    return l;

  }

  //Looks at the tile in the direction specified.
  public static boolean bossNear(Map m1, int[] l) {
    //System.out.println("/Looking for boss."); //debug code.
    int v = view(m1, l, "NORTH"); if(v == 6) { return true; }
    v = view(m1, l, "SOUTH"); if(v == 6) { return true; }
    v = view(m1, l, "EAST");  if(v == 6) { return true; }
    v = view(m1, l, "WEST");  if(v == 6) { return true; }
    return false;
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
  //Returns 1 if action done, 0 if nothing done.
  public static int refresh(Player p) {
    if(p.currentHp == p.maxHp) {
      return 0;
    } else {
      p.currentHp = p.maxHp;
      return 1;
    }


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

  //checks if string belongs to System category
  public static boolean isSystem(String s) {
    return s.equals("QUIT") || s.equals("SAVE") || s.equals("I") || s.equals("E");

  }

  //checks if string belongs to Adventure category.
  public static boolean isAdventure(String s) {
    return s.equals("NORTH") || s.equals("WEST") || s.equals("EAST") || s.equals("SOUTH");
  }

  //finds the tile in the direction desired.
  public static int view(Map m1, int[] l, String dir) {
    //System.out.println("/View method called.");
    if(dir.equals("NORTH")) {
      //Check if the tile above is out of bounds or 0.
      if(l[0] - 1 < 0) {
        //System.out.println("Can't move that way.");
      }
      else {
        //return the one above.
        return m1.grid[l[0] - 1][l[1]];
      }

    }
    else if(dir.equals("SOUTH")) {
      if(l[0] + 1 >= m1.row) {
        //System.out.println("Can't move that way.");
      }
      else {
        //return the one below.
        return m1.grid[l[0] + 1][l[1]];
      }

    }
    else if(dir.equals("WEST")) {
      if(l[1] - 1 < 0) {
        //System.out.println("Can't move that way.");
      }
      else {
        //return the one left.
        return m1.grid[l[0]][l[1] - 1];
      }

    }
    else if(dir.equals("EAST")) {
      if(l[1] + 1 >= m1.column) {
        //System.out.println("Can't move that way.");
      }
      else {
        //return the one right.
        return m1.grid[l[0]][l[1] + 1];
      }

    }

    //return self;
    return m1.grid[l[0]][l[1]];
  }

}
