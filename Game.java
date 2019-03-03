/* What does "Game" Do?
 * Receives text inputs from console
 * Handles exploration
 * Handles battles (experience, attack, calculations.)
 * Handles level ups and scaling.
 * Loads a save file.
 * Updates a save file.
 * Creates a save file.
*/

import java.util.Scanner;

public class Game {

  Scanner textInput = new Scanner(System.in);
  boolean isPlaying = true;

  public static void main(String[] args) {
    String playerInput;
    System.out.println("Entered Maze");

    //Game loop
    while(isPlaying) {
      //use switch instead?
      if(playerInput.toUpperCase.equals("QUIT")) {
        //quit game
        isPlaying = false;
      }
      else if(playerInput.toUpperCase.equals("SAVE")) {
        //save game
      }
      else if(playerInput.toUpperCase.equals("NORTH")) {
        //move north if possible.
      }
      else if(playerInput.toUpperCase.equals("SOUTH")) {
        //move south if possible.
      }
      else if(playerInput.toUpperCase.equals("WEST")) {
        //move west if possible.
      }
      else if(playerInput.toUpperCase.equals("EAST")) {
        //move east if possible.
      }
      else if(playerInput.toUpperCase.equals("I")) {
        //open inventory
      }
      else if(playerInput.toUpperCase.equals("E")) {
        //open equipment
      }
    }

  }

  public int move(String dir) {
    return 0;
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

  //
  public int battle() {
    return 0;
  }
}
