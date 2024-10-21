package blind75;

public class ValidAnagram {
	public static void main(String[] args) {
		String s = "anagram";
		String t = "nagaram";
		
		System.out.println(isAnagram(s, t));
	}

	public static boolean isAnagram(String s, String t) {
		
		if (s.length() != t.length()) return false;
		
		int[] arr = new int[26];
		
		for (char c : s.toCharArray()) {
			arr[c - 'a']++;
		}
		
		for (char c : t.toCharArray()) {
			if (arr[c - 'a'] == 0) return false;
			
			arr[c - 'a']--;
		}
		
		return true;
	}
}
