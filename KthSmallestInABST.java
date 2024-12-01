package blind75;

import java.util.*;

public class KthSmallestInABST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public int kthSmallest(TreeNode root, int k) {
//		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//		dfs(root, minHeap);
//		
//		for (int i = 0; i < k - 1; i++) {
//			minHeap.poll();
//		}
//		
//		return minHeap.poll();

//		List<Integer> list = new ArrayList<>();
//		inorder(root, list);
//		
//		return list.get(k - 1);

		return inorderIterative(root, k);
	}

	public static void dfs(TreeNode curr, PriorityQueue<Integer> pq) {
		if (curr == null)
			return;

		pq.add(curr.val);

		if (curr.left != null)
			dfs(curr.left, pq);
		if (curr.right != null)
			dfs(curr.right, pq);
	}

	public static void inorder(TreeNode curr, List<Integer> list) {
		if (curr == null)
			return;

		inorder(curr.left, list);
		list.add(curr.val);
		inorder(curr.right, list);
	}

	public static int inorderIterative(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<>();
		int cnt = 0;
		TreeNode curr = root;

		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}

			curr = stack.pop();
			cnt++;
			
			if (cnt == k) return curr.val;
			
			curr = curr.right;
		}
		
		return 0;
	}
}
