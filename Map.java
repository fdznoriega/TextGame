/* WHAT DOES "Map" DO:
 *
 *
 *
 * @author andresfernandez
 */

//File Reading and Stream Functionality
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Map {

	public int[][] grid;
	public int row;
	public int column;

	public Map(int[] dimension) {
		this.grid = new int[dimension[0]][dimension[1]];
		row = dimension[0];
		column = dimension[1];
	}

	//Sets the dimensions of the double array by going through .txt file.
	public static int[] fetchDimensions(String content) {
		int r = 0;
		int c = 0;
		for(int i = 0; i < content.length(); i++) {
			//"]" is the EOF flag, so break.
			if(content.charAt(i) == ']') {
				//sub 1 to column so we don't count the extra column.
				c--;
				break;
			}
			//we've reached a new row.
			else if(content.charAt(i) == '\n') {
				r++;
				c = 0;
			}
			//we've reached a new column.
			else if(content.charAt(i) == ' ') {
				//idle.
			}
			else {
				c++;
			}
		}
		//incresae D by 1 bc we will use it to create an array.
		int[] dimensions = {r + 1,c + 1};
		return dimensions;
	}

	//Reads a .txt file and updates grid.
	public void fillMap(String content) {
		int r = 0;
		int c = 0;
		for(int i = 0; i < content.length(); i++) {
			//"]" is the EOF flag, so break.
			char currentChar = content.charAt(i);
			if(currentChar == ']') {
				break;
			}
			//we've reached a new row.
			else if(currentChar == '\n') {
				r += 1;
				c = 0;
			}
			//we've reached a new column.
			else if(currentChar == ' ') {
				//idle.
			}
			else {
				//convert char to int and put it in the grid.
				grid[r][c] = Integer.parseInt(String.valueOf(currentChar));
				c++;
			}
		}
	}


	//Prints the map.
	public void printMap() {
		for(int i = 0; i < this.row; i++) {
			for(int j = 0; j < this.column; j++) {
				if(j % this.column == 0 && i != 0) {
					System.out.println();
				}
				System.out.print(grid[i][j]);
			}
		}
		System.out.println();

	}

	public static void main(String[] args) {
		String userDir = System.getProperty("user.dir");
	 	String content = Game.fileToString(userDir + "/Levels/level1.txt");

		//set up map we'll play with.
		int[] d = fetchDimensions(content);
		System.out.println("r: " + d[0] + " | " + "c: " + d[1]);
		Map demoMap = new Map(d);
		demoMap.fillMap(content);
		demoMap.printMap();



	}
}
