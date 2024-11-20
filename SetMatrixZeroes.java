package blind75;

import java.util.Arrays;

public class SetMatrixZeroes {
	public static void main(String[] args) {
		int[][] t1 = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		int[][] t2 = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		setZeroes(t1);
		setZeroes(t2);

		for (int[] x : t1) {
			System.out.println(Arrays.toString(x));
		}
		System.out.println();
		
		for (int[] x : t2) {
			System.out.println(Arrays.toString(x));
		}

	}

	public static void setZeroes(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		
		boolean[] rows = new boolean[m];
		boolean[] cols = new boolean[n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = true;
					cols[j] = true;
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			if (rows[i]) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		for (int j = 0; j < n; j++) {
			if (cols[j]) {
				for (int i = 0; i < m; i++) {
					matrix[i][j] = 0;
				}
			}
		}
 	}
}
