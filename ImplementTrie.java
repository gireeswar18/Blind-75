package blind75;

public class ImplementTrie {
	public static void main(String[] args) {
		Trie t = new Trie();
		
		t.insert("apple");
		System.out.println(t.search("apple"));
		System.out.println(t.search("app"));
		
		System.out.println(t.startsWith("app"));
	}
}

class Trie {

	TrieNode root;
	
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        
        public TrieNode() {
			children = new TrieNode[26];
		}
        
    }
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        
        for (int i = 0; i < word.length(); i++) {
        	char c = word.charAt(i);
        	
        	if (curr.children[c - 'a'] == null) {
        		curr.children[c - 'a'] = new TrieNode();
        	}
        	
        	curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        return search(root, 0, word);
    }
    
    public boolean search(TrieNode curr, int ind, String word) {
    	if (ind == word.length()) return false;
    	
    	TrieNode node = curr.children[word.charAt(ind) - 'a'];
    	
    	if (node == null) return false;
    	
    	if (ind == word.length() - 1 && node.isEnd) return true;
    	
    	return search(node, ind + 1, word);
    	
    }
    
    public boolean startsWith(String prefix) {
        return startsWith(root, 0, prefix);
    }
    
    public boolean startsWith(TrieNode curr, int ind, String prefix) {
    	if (ind == prefix.length()) return false;
    	
    	TrieNode node = curr.children[prefix.charAt(ind) - 'a'];
    	
    	if (node == null) return false;
    	
    	if (ind == prefix.length() - 1) return true;
    	
    	return startsWith(node, ind + 1, prefix);
    	
    }
}

