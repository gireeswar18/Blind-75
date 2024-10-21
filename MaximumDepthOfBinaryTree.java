package blind75;

public class MaximumDepthOfBinaryTree {
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

	public int maxDepth(TreeNode root) {
		if (root == null) return 0;
		
		return findHeight(root, 0);
	}
	
	public int findHeight(TreeNode node, int height) {
		if (node == null) {
			return height;
		}
		
		int left = findHeight(node.left, height + 1);
		int right = findHeight(node.right, height + 1);
		
		return Math.max(left, right);
	}
	
}
