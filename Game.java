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
    int locationID = 0;
    int depthUnlocked = 1;

    System.out.println(">Starting game...");

    //---------Load Map---------
    Map m1 = loadMap("level1");
    //Map m2 = loadMap("level2");

    //---------Update location to spawn point---------
    location = findSpawn(m1);

    //---------Start Game---------
    System.out.println(">INITIALIZED MAZE");

    //navigateMaze()
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
        }       //wip?
        else if(playerInput.equals("SAVE")) {
          //save game
          System.out.println("GAME SAVED.");
        } //wip?
        else if(playerInput.equals("I")) {
          p.showInventory();
        }
        else if(playerInput.equals("E")) {
          p.showEquipment();
          //Prompt player to equip something
          //Consider re-writing this so it's a method that takes in a player and input.
          System.out.println(">Would you like to equip something? (y/n)");
          playerInput = textInput.nextLine().replaceAll(" ", "").toUpperCase();
          //If yes, begin looping until change made.
          if(playerInput.equals("Y") || playerInput.equals("YES")) {
            tryToEquip(p, textInput);
          }
          //If no, we're done.
          else if(playerInput.equals("N") || playerInput.equals("NO")) {
            //Nothing here!
          }
          //If anything else, break out.
          else {
            System.out.println(">Invalid input.");
          }
          System.out.println(">Back to exploring.");
        }
        else if(playerInput.equals("S")) {
          System.out.println(p.toString());
        }
        else if(playerInput.equals("HELP")) {
          System.out.println(">Available commands are: ");
          System.out.println(">[ north -  move north          ]");
          System.out.println(">[ south -  move south          ]");
          System.out.println(">[ west  -  move west           ]");
          System.out.println(">[ east  -  move east           ]");
          System.out.println(">[ quit  -  exit game           ]");
          System.out.println(">[ i     -  open inventory      ]");
          System.out.println(">[ e     -  open and equip item ] ");
          System.out.println(">[ s     -  view player status  ] ");
        }
      }
      //2. Adventuring
      else if(isAdventure(playerInput)) {

        //if we try move to a 0 or out of bounds, stop.
        if(view(m1, location, playerInput) == 0 || view(m1, location, playerInput) == -1) {
          System.out.println(">Can't move that way.");
        }
        //Else, player can move that way
        else {
          //Update location based on where the player wants to move.
          location = move(m1, location, playerInput);

          //Are we near the boss? Let's check + notify the player.
          if(bossNear(m1, location)) { System.out.println(">The boss is near..."); }

          //We're on a new tile now so let's find out what we should do.
          int tileNum = m1.grid[location[0]][location[1]];
          switch(tileNum) {
            //battle tile
            case 3: System.out.println(">Battle!");
                    //Spawn random enemy.
                    int randID = (int) (Math.random() * 2);
                    Actor enemy = spawnEnemy(randID);
                    //Pass text input in so we can fetch strings.
                    if(battle(p, enemy, textInput) == 0) {
                      //Player lost
                      System.out.println(">Darkness envelops you...");
                      isPlaying = false;
                    }
                    else {
                      System.out.println(">You win!");
                      int xp = calcXp(enemy);
                      p.setXp(p.getXp() + xp);
                      System.out.println(">You gained " + xp + " EXP!");
                      int gold = calcGold(enemy);
                      p.setGold(p.getGold() + gold);
                      System.out.println(">You gained " + gold + " Gold!");

                      //Turn enemy tile into a normal walking tile.
                      //This could be changed and we could make random encounters a thing.
                      m1.grid[location[0]][location[1]] = 2;
                      //Back to exploring
                      System.out.println(">Back to exploring.");
                    }
                    break;
            //sword tile
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

  //Moves player to a certain location. Pair with view().
  //returns new location
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
    if(p.getCurrentHp() == p.getMaxHp()) {
      return 0;
    } else {
      p.setCurrentHp(p.getMaxHp());
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
    return s.equals("QUIT") || s.equals("SAVE") || s.equals("I") || s.equals("E")
    || s.equals("S") || s.equals("HELP");
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
    if(s.equals("KEY"))    return 2;
    if(s.equals("SWORD"))  return 3;
    if(s.equals("ARMOR"))  return 4;
    return -1;
	}

  //Simulates a battle between a player and an actor.
  public static int battle(Player p, Actor a, Scanner s) {
    s = new Scanner(System.in);
    System.out.println(">You encountered a " + a.getName() + "!");
    Boolean flag = true;
    while(flag) {
      //Player phase
      int action = 0; //this will indicate if the player has expended an action point.
      while(action < 1) {
        System.out.print("[ Player HP: " + p.getHpRatio() + " | ");
        System.out.print(a.getName() + ": " + a.getHpRatio() + " ] \n");
        System.out.println("[ ATTACK (AT) | ANALYZE (AN) | INVENTORY (I)]");
        String textInput = s.nextLine().replaceAll(" ", "").toUpperCase();
        if(textInput.equals("AT") || textInput.equals("ATTACK")) {
          int dmg = p.getAttack() - a.getDefense();
          a.setCurrentHp(a.getCurrentHp() - dmg);
          System.out.println(">You deal " + dmg + " damgage!");
          action = 1;
        }
        else if(textInput.equals("AN") || textInput.equals("ANALYZE")) {
          System.out.println(">You take a good look at the enemy...");
          System.out.println(a.toString());
        }
        else if(textInput.equals("I") || textInput.equals("INVENTORY")) {
          System.out.println(">You open your pouch...");
          p.showInventory();
          //System.out.println(">You open your pouch...");
          //only add 1 to action if you use an item.

        }
        else {
          System.out.println("Pick one of the three");
        }
      }
      if(a.getCurrentHp() <= 0) { break; }

      //Enemy phase
      System.out.println(">" + a.getName() + " strikes!");
      int dmg;
      //Minimum damage is always 1.
      if(a.getAttack() - p.getDefense() <= 0) {
        dmg = 1;
      }
      else {
        dmg = a.getAttack() - p.getDefense();
      }
      p.setCurrentHp(p.getCurrentHp() - dmg);
      System.out.println(">Took " + dmg + " damage!");
      if(p.getCurrentHp() <= 0) { break; }
    }
    //Who won?
    if(p.getCurrentHp() <= 0) { return 0; } //player lost.
    else                      { return 1; } //player won.
  }

  //spawns a random enemy.
  public static Actor spawnEnemy(int ID) {
    //Two kinds of enemies, Spider and Skeleton.
    switch(ID) {
      //Spider base stats: "spider", 10, 3, 3.
      case 0: return new Actor("spider", 10, 3, 3);
      //Skeleton base stats: "skeleton", 8, 5, 2
      case 1: return new Actor("skeleton", 8, 5, 2);

    }
    return null;
  }

  //Tries to equip item into player inventory.
  public static void tryToEquip(Player p, Scanner textInput) {
    System.out.println(">Pick one to equip or CANCEL");
    p.showInventory();
    boolean flag = true;
    while(flag) {
      String playerInput = textInput.nextLine().replaceAll(" ", "").toUpperCase();
      int ID = itemID(playerInput);
      //If the player asks to equip a sword OR a shield...
      if(ID == 3 || ID == 4) {
        //Check if item is in player's inventory
        if(p.inInventory(ID)) {
          //Check to see if there's space in equipment.
          if(p.getEquipment()[0] != 0 && p.getEquipment()[1] != 0) {
            System.out.println(">Equipment fully occupied.");
          }
          else {
            //Check/place spot 1
            if(p.getEquipment()[0] == 0) {
              p.getEquipment()[0] = ID;
            }
            //Check/place spot 2
            else {
              p.getEquipment()[1] = ID;
            }
            System.out.println(">Equipped.");
            //Remove from inventory and break.
            p.deleteItem(ID);
            //Update the player's stats
            //Sword and armor will increase stats by 3.
            if(ID == 3) {
              p.setAttack(p.getAttack() + 3);
              System.out.println(">ATT increased by " + 3);
            }
            if(ID == 4) {
              p.setDefense(p.getDefense() + 3);
              System.out.println(">DEF increased by " + 3);
            }
            flag = false;
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

  //Calculates worth of enemy.
  public static int calcXp(Actor enemy) {
    return (enemy.getMaxHp() + enemy.getAttack() + enemy.getDefense() / 3);
  }

  //Calculates gold worth of the enemy.
  public static int calcGold(Actor enemy) {
    int xp = calcXp(enemy);
    int bonus = (int) (Math.random() * 2.5);
    return xp + bonus;
  }

}
