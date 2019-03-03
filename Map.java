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

	//to add: map.get(0) is the first row | map.get(0).get(0) is the first column
	private int ID;
	private List<List<Integer>> grid;

	public Map(int ID) {
		this.ID = ID;
		this.grid = new ArrayList<List<Integer>>();
	}

	public void fillGridDemo() {
		//For the demo, make a 5x5 grid.
		for(int i = 0; i < 5; i++) {
			//Add a new arraylist of ints.
			this.grid.add(new ArrayList<Integer>());
			//fill the new arraylist of ints.
			for(int j = 0; j < 5; j++) {
				this.grid.get(i).add(j);
			}
		}
	}

	//Reads a .txt file and generates an array list.
	public static void fillGrid() {

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

	public static void readSampleFile() {
		// implementing cleaner error handling.
    String userDirectory = System.getProperty("user.dir");
    String p = Paths.get(userDirectory + "/TextFiles/sampleText.txt").toString();

		try {
			String content = new String(Files.readAllBytes(Paths.get(p)));
			System.out.println(content);
		}
    catch (IOException e) {
			System.out.println("Could not retrieve file.");
		}
	}


	public static void main(String[] args) {
		readSampleFile();

	}
}
