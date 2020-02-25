package Domain.Entities;

import Domain.Entities.Tile;
import java.util.ArrayList;
import java.nio.file.Files;
import java.io.IOException;



public class Maze {

	public Tile[][] matrix;
	public int row, column;		//dimensions of matrix

	//makes empty maze of dimension (m x n)
	public Maze(int[] dimension) {
		matrix = new Tile[dimension[0]][dimension[1]];
		row = dimension[0];
		column = dimension[1];
	}

	//Prints the Maze.
	public String toString() {
		System.out.println("Hey");
		if(this == null) {
			return "";
		}
		String info = "";
		for(int i = 0; i < this.row; i++) {
			for(int j = 0; j < this.column; j++) {
				if(j % this.column == 0 && i != 0) {
					//System.out.println();
					info += "\n";
				}
				info += matrix[i][j].toString() + " ";
			}
		}
		//System.out.println();
		return info;

	}



}
