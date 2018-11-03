/* WHAT DOES "Map" DO:
 * Defines a tile (a linked list that can move in four directions).
 * A Tile is composed of a type (1 - 3) which will lead to unique traits when interacted with.
 * Generates a connected linked list based off a given text input.
 * @author andresfernandez
 */
import java.io.File;
import java.util.Scanner;

public class Map {

	private static class Tile {
	    private int type;
	    private Tile north, east, west, south;

	    private Tile(int i) {
	        this.type = i;
	        this.north = null;
	        this.east = null;
	        this.west = null;
	        this.south = null;

	      }
	  }

		//Demo linked list that generates a four by four map.
		public Map createFourByFour() {


		}

		//Will read a text file and create a connected linked list
		public Map generateMap() {

		}
}
