package blind75;

public class NumberOf_1Bits {
	public static void main(String[] args) {
		int n = 128;
		System.out.println(hammingWeight(n));
	}

	public static int hammingWeight(int n) {
		
		int res = 0;
		
		while (n != 0) {
			if (n % 2 == 1)
				res++;
			n /= 2;
		}
		
		return res;
		
	}
}
