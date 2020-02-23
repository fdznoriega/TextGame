package Domain.Entities;

import Domain.Entities.Tile;

public class Maze {

	public Tile[][] matrix;
	public int row, column;		//dimensions of matrix

	//makes empty maze of dimension (m x n)
	public Maze(int[] dimension) {
		matrix = new Tile[dimension[0]][dimension[1]];
		row = dimension[0];
		column = dimension[1];
	}

	// makes a maze given some level text file?
	public Maze(String fileName) {
		
	}

	//Prints the Maze.
	public String toString() {
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
