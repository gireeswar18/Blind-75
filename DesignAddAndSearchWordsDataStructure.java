package blind75;

public class DesignAddAndSearchWordsDataStructure {

	public static void main(String[] args) {
		WordDictionary w = new WordDictionary();

		w.addWord("arc");
		w.addWord("apple");
		w.addWord("app");
		System.out.println(w.search("a.c"));

		System.out.println(w.search("app"));
	}

}

class WordDictionary {

	TrieNode root;

	class TrieNode {

		TrieNode[] children;
		boolean isEndOfWord;

		public TrieNode() {
			children = new TrieNode[26];
		}
	}

	public WordDictionary() {
		root = new TrieNode();
	}

	public void addWord(String word) {

		TrieNode curr = root;

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);

			if (curr.children[c - 'a'] == null) {
				curr.children[c - 'a'] = new TrieNode();
			}

			curr = curr.children[c - 'a'];
		}
		curr.isEndOfWord = true;

	}

	public boolean search(String word) {
		return search(word.toCharArray(), 0, root);
	}
	
	public boolean search(char[] str, int ind, TrieNode curr) {
		if (ind == str.length) {
			return curr.isEndOfWord;
		}
		
		if (str[ind] == '.') {
			for (TrieNode t : curr.children) {
				
				if (t != null && search(str, ind + 1, t)) {
					return true;
				}
			}
			
			return false;
		}
		
		else {
			if (curr.children[str[ind] - 'a'] == null)
				return false;
			
			return search(str, ind + 1, curr.children[str[ind] - 'a']);
		}
		
	}
}
