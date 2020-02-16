package Domain.Entities;

public class Maze {

	public int[][] matrix;		//matrix of ints
	public int row, column;		//dimensions of matrix

	//makes empty maze of dimension (m x n)
	public Maze(int[] dimension) {
		matrix = new int[dimension[0]][dimension[1]];
		row = dimension[0];
		column = dimension[1];
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
				info += matrix[i][j] + " ";
			}
		}
		//System.out.println();
		return info;

	}



}
