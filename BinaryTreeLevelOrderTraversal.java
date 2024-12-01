package blind75;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
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

		public List<List<Integer>> levelOrder(TreeNode root) {
			List<List<Integer>> res = new ArrayList<>();
			
			if (root == null) return res;
			
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			
			while (!queue.isEmpty()) {
				int size = queue.size();
				List<Integer> list = new ArrayList<>();
				
				while (size-- != 0) {
					TreeNode temp = queue.poll();
					
					if (temp.left != null) queue.offer(temp.left);
					if (temp.right != null) queue.offer(temp.right);
					
					list.add(temp.val);
				}
				
				res.add(list);
			}
			
			return res;
	
		}
	}
}
