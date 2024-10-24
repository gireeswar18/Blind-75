package blind75;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		String t1 = "abcabcbb";
		String t2 = "bbbbb";
		String t3 = "pwwkew";

		System.out.println(lengthOfLongestSubstring(t1));
		System.out.println(lengthOfLongestSubstring(t2));
		System.out.println(lengthOfLongestSubstring(t3));
	}

	public static int lengthOfLongestSubstring(String s) {
		int[] arr = new int[128];

		int l = 0;
		int r = 0;
		int n = s.length();
		int max = 0;
		char[] str = s.toCharArray();
		
		while (r < n) {
			if (arr[str[r]] == 0) {
				arr[str[r]]++;
				r++;
			}
			else {
				max = Math.max(max, r - l);
				arr[str[l]]--;
				l++;
			}
		}
		
		max = Math.max(max, r - l);
		return max;
	}
}
