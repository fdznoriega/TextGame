/* WHAT DOES "Map" DO:
 * Defines a tile (a linked list that can move in four directions).
 * A Tile is composed of a type (1 - 3) which will lead to unique traits when interacted with.
 * Generates a connected linked list based off a given text input.
 * @author andresfernandez
 */

//File Reading and Stream Functionality
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Map {

	private int[][] grid;
	private int row = 0;
	private int column = 0;

	public Map() {
		this.grid = new int[row][column];
	}

	//Sets the dimensions of the double array.
	public void setMapDimensions(String content) {
		for(int i = 0; i < content.length(); i++) {
			//Find dimensions of the double array.

			//"]" is the EOF flag, so break.
			if(content.charAt(i) == ']') {
				break;
			}
			//we've reached a new row.
			else if(content.charAt(i) == '\n') {
				this.row++;
			}
			//we've reached a new column.
			else if(content.charAt(i) == ' ') {
				//idle.
			}
			else {
				this.column++;
			}
		}

		//"column" right now has been counting every item.
		//to set the true column, divide by the number of rows + 1
		//and subtract by 1 (because we start at 0 and not 1)
		//will only work for regular shaped matrices
		this.column = (this.column / (row + 1)) - 1;
	}

	//Reads a .txt file and generates an array list.
	public int[][] fillGrid(String content) {
		return this.grid;
	}


	//Returns -1 if empty grid. Returns 1 if print happened.
	public int printGrid() {
		return 0;
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
		Map demoMap = new Map();
		demoMap.setMapDimensions(content);



	}
}
