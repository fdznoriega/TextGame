/* WHAT DOES "Map" DO:
 * Defines a tile (a linked list that can move in four directions).
 * A Tile is composed of a type (1 - 3) which will lead to unique traits when interacted with.
 * Generates a connected linked list based off a given text input.
 * @author andresfernandez
 */
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

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
	public static void main(String[] args) {
		System.out.println("Making map.");
		Map map = new Map(1);
		System.out.println("Filling grid.");
		map.fillGridDemo();
		System.out.println("Printing grid.");
		map.printGrid();
	}
}
