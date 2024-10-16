package blind75;

public class ValidParentheses {
	public static void main(String[] args) {
		String s = "[";
		
		System.out.println(isValid(s));
	}

	public static boolean isValid(String s) {
		char[] stack = new char[s.length()];
		int top = -1;
		char[] str = s.toCharArray();
		
		for (char c : str) {
			if (c == '(') {
				stack[++top] = ')';
			}
			else if (c == '[') {
				stack[++top] = ']';
			}
			else if (c == '{') {
				stack[++top] = '}';
			}
			else if (top != -1 && stack[top] == c) {
				top--;
			}
			else {
				return false;
			}
		}
		
		return top == -1;
	}
}
