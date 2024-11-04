package blind75;

import java.util.*;

public class SpiralMatrix {
	public static void main(String[] args) {
		int[][] t1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] t2 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

		System.out.println(spiralOrder(t1));
		System.out.println(spiralOrder(t2));
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();

		int rowStart = 0, rowEnd = matrix.length;
		int colStart = 0, colEnd = matrix[0].length;

		while (rowStart < rowEnd && colStart < colEnd) {
			for (int i = colStart; i < colEnd; i++) {
				res.add(matrix[rowStart][i]);
			}
			rowStart++;
			System.out.println("RS: " + rowStart);
			System.out.println("RE: " + rowEnd);

			for (int i = rowStart; i < rowEnd; i++) {
				res.add(matrix[i][colEnd - 1]);
			}
			colEnd--;
			System.out.println("CS: " + colStart);
			System.out.println("CE: " + colEnd);

			if (rowStart < rowEnd) {
				for (int i = colEnd - 1; i >= colStart; i--) {
					res.add(matrix[rowEnd - 1][i]);
				}
				rowEnd--;
			}
			System.out.println("RS: " + rowStart);
			System.out.println("RE: " + rowEnd);

			if (colStart < colEnd) {
				for (int i = rowEnd - 1; i >= rowStart; i--) {
					res.add(matrix[i][colStart]);
				}
				colStart++;
			}
	
			System.out.println("CS: " + colStart);
			System.out.println("CE: " + colEnd);
			System.out.println();
		}

		return res;
	}
}
