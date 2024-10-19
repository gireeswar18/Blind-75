package blind75;

import java.util.Arrays;

public class CountBits {
	public static void main(String[] args) {
		int n = 0;

		System.out.println(Arrays.toString(countBits(n)));
	}

	public static int[] countBits(int n) {
		int[] res = new int[n + 1];
		res[0] = 0;
		if (n == 0)
			return res;
		
		res[1] = 1;

		for (int i = 2; i <= n; i++) {
			res[i] = res[i / 2] + (i % 2 == 1 ? 1 : 0);
		}
		
		return res;
	}
}
