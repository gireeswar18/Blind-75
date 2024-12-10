package blind75;

import java.util.*;

public class CloneGraph {
	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}
	
	public Node cloneDfs(Node og, Map<Node, Node> visited) {
		Node clone = new Node(og.val);
		visited.put(og, clone);
		ArrayList<Node> adj = new ArrayList<Node>();
		
		for (Node adjNode : og.neighbors) {
			if (visited.containsKey(adjNode)) {
				adj.add(visited.get(adjNode));
			}
			else {
				adj.add(cloneDfs(adjNode, visited));
			}
		}
		clone.neighbors = adj;
		return clone;
	}

	public Node cloneGraph(Node node) {
		if (node == null) return null;
		
		Map<Node, Node> visited = new HashMap<>();
		
		return cloneDfs(node, visited);
	}
}
