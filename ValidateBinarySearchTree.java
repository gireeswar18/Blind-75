package blind75;

public class ValidateBinarySearchTree {
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

	public boolean isValidBST(TreeNode root) {
		if (root == null) return true;
		
		return valid(root, null, null); 
	}

	public boolean valid(TreeNode curr, TreeNode min, TreeNode max) {
		if (curr == null)
			return true;

		if (min != null && curr.val <= min.val)
			return false;
		
		if (max != null && curr.val >= max.val)
			return false;
		
		return valid(curr.left, min, curr) && valid(curr.right, curr, max);
	}
}
