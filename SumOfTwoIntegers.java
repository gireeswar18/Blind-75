package blind75;

public class SumOfTwoIntegers {
	public static void main(String[] args) {
		System.out.println(getSum(20, 30));
	}

	public static int getSum(int a, int b) {
		if (a == 0) return b;
		if (b == 0) return a;

		while (b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		
		return a;
	}
	

}
