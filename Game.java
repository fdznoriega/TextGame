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
    System.out.println(">INITIALIZED MAZE");

    //---------Game loop---------
    while(isPlaying) {
      //Print stuff for debug.
      //System.out.println(location[0] + ":" + location[1]);
      //System.out.println(m1.grid[location[0]][location[1]]);

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
          p.showInventory();
        }
        else if(playerInput.equals("E")) {
          p.showEquipment();
          //Prompt player to equip something
          System.out.println(">Would you like to equip something? (y/n)");
          playerInput = textInput.nextLine().replaceAll(" ", "").toUpperCase();
          //If yes, let's enter equip loop.
          if(playerInput.equals("Y") || playerInput.equals("YES")) {
            System.out.println(">Pick one to equip or CANCEL");
            p.showInventory();
            boolean flag = true;
            while(flag) {
              playerInput = textInput.nextLine().replaceAll(" ", "").toUpperCase();
              int ID = itemID(playerInput);
              //If the player asks to equip a sword OR a shield...
              if(ID == 3 || ID == 4) {
                //Check if item is in player's inventory
                if(p.inInventory(ID)) {
                  //Check to see if there's space in equipment.
                  if(p.equipment[0] != 0 && p.equipment[1] != 0) {
                    System.out.println(">Equipment fully occupied.");
                  }
                  else {
                    //Check/place spot 1
                    if(p.equipment[0] == 0) {
                      p.equipment[0] = ID;
                    }
                    //Check/place spot 2
                    else {
                      p.equipment[1] = ID;
                    }
                    System.out.println(">Equipped.");
                    //Remove from inventory and break.
                    p.deleteItem(ID);
                    break;
                  }
                }
                else {
                  System.out.println(">Not in your inventory.");
                }

              }
              else if(playerInput.equals("CANCEL")) {
                flag = false;
                System.out.println(">Canceled equipment changes.");
              }
              else {
                System.out.println(">Choose an item or CANCEL");
              }

            }
          }
          else if(playerInput.equals("N") || playerInput.equals("NO")) {
            System.out.println(">Understood.");
          }
          else {
            System.out.println(">Enter: y/n");
          }




        }

        System.out.println(">Back to exploring.");
      }
      //2. Adventuring
      else if(isAdventure(playerInput)) {

        //if we try move to a 0 or out of bounds, stop.
        if(view(m1, location, playerInput) == 0 || view(m1, location, playerInput) == -1) {
          System.out.println(">Can't move that way.");
        }
        else {
          //Update location based on where the player wants to move.
          location = move(m1, location, playerInput);

          //Are we near the boss? Let's notify the player.
          if(bossNear(m1, location)) { System.out.println(">The boss is near..."); }

          //We're on a new tile now so let's find out what we should do.
          int tileNum = m1.grid[location[0]][location[1]];
          switch(tileNum) {
            //Spawn tile.
            case 1: //spawnMessage();
                    break;
            //Walk tile.
            case 2: //walkMessage();
                    break;
            //battle tile
            case 3: System.out.println(">Battle found.");
                    break;
            //sword treasure tile
            case 4: System.out.println(">Sword found.");
                    if(p.addItem(3) == 1) {
                      System.out.println(">Sword added to inventory.");
                    } else {
                      System.out.println(">Inventory full.");
                    }

                    break;
            //fountain tile
            case 5: if(refresh(p) == 1) { System.out.println(">Refreshed!"); }
                    break;
            //boss tile
            case 6: System.out.println(">Boss found.");
                    break;
          }
        }


      }
      //3. Wrong Input
      else {
        System.out.println(">Didn't quite catch that...");
      }

    }
    System.out.println(">Thanks for playing");
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
      l[0] -= 1;
    }
    else if(dir.equals("SOUTH")) {
      l[0] += 1;
    }
    else if(dir.equals("WEST")) {
      l[1] -= 1;
    }
    else if(dir.equals("EAST")) {
      l[1] += 1;
    }
    System.out.println(">Moved " + dir);
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
        return -1;
      }
      else {
        //return the one above.
        return m1.grid[l[0] - 1][l[1]];
      }
    }
    else if(dir.equals("SOUTH")) {
      if(l[0] + 1 >= m1.row) {
        return -1;
      }
      else {
        //return the one below.
        return m1.grid[l[0] + 1][l[1]];
      }
    }
    else if(dir.equals("WEST")) {
      if(l[1] - 1 < 0) {
        return -1;
      }
      else {
        //return the one left.
        return m1.grid[l[0]][l[1] - 1];
      }
    }
    else if(dir.equals("EAST")) {
      if(l[1] + 1 >= m1.column) {
        return -1;
      }
      else {
        //return the one right.
        return m1.grid[l[0]][l[1] + 1];
      }
    }

    //return self;
    return m1.grid[l[0]][l[1]];
  }

  //Translates player input into int.
	//Returns -1 if there is no value assigned to that string.
	public static int itemID(String s) {
    if(s.equals("POTION")) return 1;
    if(s.equals("KEY")) return 2;
    if(s.equals("SWORD")) return 3;
    if(s.equals("ARMOR")) return 4;
    return -1;
	}
}
