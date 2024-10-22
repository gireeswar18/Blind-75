package blind75;

public class ValidPalindrome {
	public static void main(String[] args) {
		String t1 = "A man, a plan, a canal: Panama";
		String t2 = "race a car";
		String t3 = " ";

		System.out.println(isPalindrome(t1));
		System.out.println(isPalindrome(t2));
		System.out.println(isPalindrome(t3));
	}

	public static boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		char[] arr = s.toCharArray();
		
		while (i < j) {
			char a = arr[i];
			char b = arr[j];
			
			if (!(a >= 'a' && a <= 'z' || a >= 'A' && a <= 'Z' || a >= '0' && a <= '9')) {
				i++;
				continue;
			}
			if (!(b >= 'a' && b <= 'z' || b >= 'A' && b <= 'Z' || b >= '0' && b <= '9')) {
				j--;
				continue;
			}
			
			if (a >= 'A' && a <= 'Z') {
				a = (char) (a + 32);
			}
			if (b >= 'A' && b <= 'Z') {
				b = (char) (b + 32);
			}
			if (a != b) {
				return false;
			}
			i++;
			j--;
		}
		
		return true;
	}
}
