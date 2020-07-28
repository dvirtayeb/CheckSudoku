/*
 * ID: 316522341
 * NAME: Dvir tayeb
 */

package Task3;

import java.util.Scanner;

public class Sudoku {
	private int size;
	private int[][] sudoku;
	Scanner myScan = new Scanner(System.in);

	// Constructor:
	public Sudoku() {
		// input: "N" for the size of the matrix
		System.out.println("choose size for your Sudoku: ");
		size = myScan.nextInt();
		while (size < 1 || checkSize() == false) {
			System.out.println("you didn't insert proper Sudoku, Insert Again: ");
			size = myScan.nextInt();
		}
		// matrix of the user (N*N) :
		sudoku = new int[size][size];
		inputNumInSudoku();
		show();
	}

	// GET & SET
	public int getSize() {
		return size;
	}

	// methods
	public boolean checkSize() {
		double checkSize = Math.sqrt(size);
		if (checkSize == ((int) checkSize)) {
			return true;
		}
		return false;
	}

	public void inputNumInSudoku() {
		System.out.println("Please enter numbers for every row in the sudoku: ");
		for (int i = 0; i < sudoku.length; i++) {
			System.out.printf("Row Number: %d \n", i + 1);
			for (int j = 0; j < sudoku[i].length; j++) {
				sudoku[i][j] = myScan.nextInt();
				while (sudoku[i][j] < 1 || sudoku[i][j] > this.size) {
					System.out.printf("You cannot enter number biggther then %d, or smaller then 1, try again: ", size);
					sudoku[i][j] = myScan.nextInt();
				}
			}
		}
	}

	private boolean isValidSodukoRow(int indexRow) {
		// make boolean array with the same length of the sudoku, tell us if the numbers
		// are equals or not in the same Row.
		boolean[] check = new boolean[sudoku.length + 1];

		// tell us if we got the same numbers in the Row:
		for (int i = 0; i < sudoku.length; i++) {
			// term if : we got the same number.
			if (check[sudoku[indexRow][i]] == true) {
				return false;
			}
			check[sudoku[indexRow][i]] = true;
		}
		return true;
	}

	private boolean isValidSodukoCol(int indexCol) {
		// make boolean array with the same length of the sudoku, tell us if the numbers
		// are equals or not in the same Column.
		boolean[] check = new boolean[sudoku.length + 1];

		// tell us if we got the same numbers in the Column:
		for (int i = 0; i < sudoku.length; i++) {
			// term if : we got the same number.
			if (check[sudoku[i][indexCol]] == true) {
				return false;
			}
			// change the indexes to true:
			check[sudoku[i][indexCol]] = true;
		}
		return true;
	}

	private boolean isValidSodukoQuadrant(int Qr, int Qc) {
		// make boolean array with one more space, length of the sudoku.
		boolean[] check = new boolean[(sudoku.length + 1)];

		// tell us if we got the same numbers in the quadrant of the sudoku,
		// when the Qr or the Qc change it will check another Quadrant of the sudoku.
		int rootOfSize = (int) Math.sqrt(sudoku.length);
		int whereRowStart = Qr * rootOfSize;
		int whereColStart = Qc * rootOfSize;
		for (int i = whereRowStart; i < (whereRowStart + rootOfSize); i++) {
			for (int j = whereColStart; j < (whereColStart + rootOfSize); j++) {
				if (check[sudoku[i][j]] == true)
					return false;
				else
					check[sudoku[i][j]] = true;
			}
		}
		return true;
	}

	public boolean checkSudoku() {
		// check term for Quadrant:
		for (int i = 0; i < Math.sqrt(sudoku.length); i++) {
			for (int j = 0; j < Math.sqrt(sudoku.length); j++) {
				if (isValidSodukoQuadrant(i, j) == false) {
					return false;
				}
			}
		}
		// check term for Row And Column, if one of them not true we will get false
		for (int i = 0; i < sudoku.length; i++) {
			if (isValidSodukoRow(i) == false || isValidSodukoCol(i) == false) {
				return false;
			}
		}
		return true;
	}

	public void show() {
		System.out.println("Sudoku (" + getSize() + "x" + getSize() + ")");
		for (int i = 0; i < sudoku.length; i++) {
			for (int j = 0; j < sudoku[i].length; j++) {
				System.out.print(this.sudoku[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
