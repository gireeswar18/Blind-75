package blind75;

public class WordSearch {
	public static void main(String[] args) {
		char[][] t1 = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

		System.out.println(exist(t1, "ABCCED"));

		char[][] t2 = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

		System.out.println(exist(t2, "SEE"));

	}

	public static boolean exist(char[][] board, String word) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (dfs(board, i, j, 0, word))
					return true;
			}
		}

		return false;
	}

	public static boolean dfs(char[][] board, int i, int j, int ind, String word) {
		
		if (ind == word.length()) return true;

		if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] != word.charAt(ind)) {
			return false;
		}

		board[i][j] = '*';

		boolean res = dfs(board, i + 1, j, ind + 1, word) || dfs(board, i - 1, j, ind + 1, word)
				|| dfs(board, i, j + 1, ind + 1, word) || dfs(board, i, j - 1, ind + 1, word);
		
		board[i][j] = word.charAt(ind);
		
		return res;
	}
}
