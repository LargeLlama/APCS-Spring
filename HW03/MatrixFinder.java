public class MatrixFinder {
	
	public static String linSearch(int[][] matrix, int desiredValue) {
		int currentRow = 0;
		int currentColumn = matrix.length - 1;

		String retString = "(-1, -1)";

		while (currentColumn >= 0 && currentRow < matrix.length) {
			if (matrix[currentRow][currentColumn] == desiredValue)
				retString = "(" + currentRow + ", " + currentColumn + ")";
			else if (matrix[currentRow][currentColumn] < desiredValue)
				currentRow++;
			else
				currentColumn--;
		}

		return retString;
	}
}
