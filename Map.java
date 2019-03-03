/* WHAT DOES "Map" DO:
 * Defines a tile (a linked list that can move in four directions).
 * A Tile is composed of a type (1 - 3) which will lead to unique traits when interacted with.
 * Generates a connected linked list based off a given text input.
 * @author andresfernandez
 */
//ArrayList and List Functionality
import java.util.List;
import java.util.ArrayList;

//File Reading and Stream Functionality
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Map {

	private int[][] grid;

	public Map(int ID) {
		this.grid = new int[][];
	}

	//Reads a .txt file and generates an array list.
	public int[][] fillGrid(String content) {
		for(int i = 0; i < content.length(); i++) {
			if(content.charAt(i) == ']') {
				break;
			}
			else {

			}
		}
	}


	//Returns -1 if empty grid. Returns 1 if print happened.
	public int printGrid() {
		//if the arraylist is empty, then stop.
		if(this.grid.get(0).size() == 0) {
			return -1;
		}
		//the arraylist is not empty, then get the vertical size.
		for(int i = 0; i < this.grid.get(0).size(); i++) {
			//Get horizontal size j and print (repeat).
			for(int j = 0; j < this.grid.get(i).size(); j++) {
				System.out.print(this.grid.get(i).get(j) + " ");
			}
			System.out.println("");
		}
		return 1;
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


	public static void main(String[] args) {
		String userDir = System.getProperty("user.dir");
	 	String content = fileToString(userDir + "/TextFiles/sampleMap.txt");



	}
}
