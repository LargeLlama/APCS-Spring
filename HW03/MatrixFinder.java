//Wubin Peco
//APCS pd2
//HW03 - yeah brudder
//2017-02-01

import java.util.Scanner;

public class MatrixFinder {
	//algo developed Toot Toot Cabbage, consisting of...
	//Bill Ni
	//Andrew Shao
	//yours truly, woooobin peco!
	//we start off at the top right most element, and if it is less than the desired value, it cannot be in that row since 
	//the right most element is the large of each row, so we go down to the next row
	//if it is greater than, we start going down columns
	//we repeat this for each element until we reach the end, go "out of bounds", or find our element and break the loop
	
	public static String linSearch(int[][] matrix, int desiredValue) {
		int currentRow = 0;	//first row
		int currentColumn = matrix.length - 1; //last element
	
		String retString = "(-1, -1)";	//return string in case the element is not found

		while (currentColumn >= 0 && currentRow < matrix.length) {	//as long as we are within bounds, we keep looping
			if (matrix[currentRow][currentColumn] == desiredValue) {		//if we find the element
				retString = "(" + currentRow + ", " + currentColumn + ")";	//print our current location
				break;
			} else if (matrix[currentRow][currentColumn] < desiredValue) {	//if the current element is less than
				currentRow++;												//go down to the next row
			} else {														//if the current element is greater than
				currentColumn--;											//go to the column to the left
			}
		}

		return retString;													//return the string
	}

//==========HELPER FUNCTIONS FOR GENERATING THE MATRIX==============
	public static void sortArray(int[] array) {
		int min = array[0];

		for (int i = 0; i < array.length - 1; i++) {
			for (int n = 0; n < array.length - 1; n++) {
				if (array[n] > array[n + 1]) {
					int temp = array[n];
					array[n] = array[n + 1];
					array[n + 1] = temp;
				}
			}
		}
	}

	public static String printArray(int[] array) {
		String retString = "|";

		for (int i = 0; i < array.length; i++) {
			if (array[i] < 10)
				retString += "  " + array[i];
			else
				retString += " " + array[i];
			
		}
		retString += " |";

		return retString + "\n";	
	}

	public static void printMatrix(int[][] matrix) {
		String retString = "";
		for (int i = 0; i < matrix.length; i++) {
			retString += printArray(matrix[i]);
		}
		System.out.println(retString);
	}
//===============================================================

	public static int[][] genMatrix (int rows) {
		int[] numbers = new int[rows * rows];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random() * 20);
		}

		sortArray(numbers);

		int[][] matrix = new int[rows][rows];
		int counter = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int n = 0; n < matrix[i].length; n++) {
				matrix[i][n] = numbers[counter];
				counter ++;
			}
		}

		return matrix;
	}

	public static void main(String[] args) {
		System.out.println("Generating matrix...\n");

		int[][] matrix = new int[3][3];
		matrix = genMatrix(3);
		printMatrix(matrix);

		System.out.println("Enter the integer you would like to find");
		Scanner sc = new Scanner(System.in);
		
		String value = "";
		int choice = 0;

		while(true) {
			value = sc.nextLine();

			try {
				choice = Integer.parseInt(value);
				break;
			} catch (Exception e) {
				System.out.println("Invalid input, try again!");
			}
		}

		System.out.println(choice + " is at location " + linSearch(matrix, choice));

	}
}
