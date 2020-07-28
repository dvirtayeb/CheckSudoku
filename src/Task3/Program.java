/*
 * ID: 316522341
 * NAME: Dvir tayeb
 */
package Task3;

import java.util.Scanner;

public class Program {
	public static int chooseProgram(Scanner myscan) {
		int num = myscan.nextInt();
		while (num < -1 || num > 2 || num == 0) {
			System.out.println("you didn't choose corret nubmer, insert again: ");
			num = myscan.nextInt();
		}
		return num;
	}

	public static void checkSudoku() {
		Sudoku game = new Sudoku();
		boolean ok = game.checkSudoku();
		if (!ok)
			System.out.println("Not a valid Sudoku");
		else
			System.out.println("A valid Sudoku");
	}

	public static void dogPension() {
		DogHouseTest.testDogPension();
	}

	public static void test() {
		CageTest.testCage();
	}

	public static void main(String[] args) {
		Scanner myscan = new Scanner(System.in);
		int userChoice;
		do {
			System.out.println("Welcome, please choose between the missions :\r\n" + "1.Sudoku\r\n" + "2. Dog Pension\r\n"
					+ "to exit press -1.\r\n" + "insert the nubmer of choice: ");
			userChoice = chooseProgram(myscan);
			switch (userChoice) {
			case 1:
				checkSudoku();
				break;
			case 2:
				dogPension();
				break;
			case -1:
				System.out.println("thank you, Goodbye!");
			}
		}while(userChoice != -1);
			myscan.close();
	}

}
