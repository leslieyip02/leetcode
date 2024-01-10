/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private static int time = 0;

    private int depth(TreeNode root, int start) {
        if (root == null) {
            return 0;
        }

        int left = this.depth(root.left, start);
        int right = this.depth(root.right, start);
        if (root.val == start) {
            // negative depth means a branch contains the start
            Solution.time = Math.max(left, right);
            return -1;
        } else if (left >= 0 && right >= 0) {
            // subtree does not contain start
            return Math.max(left, right) + 1;
        } else {
            // subtree contains start
            Solution.time = Math.max(Math.abs(left) + Math.abs(right), Solution.time);
            return Math.min(left, right) - 1;
        }
    }

    public int amountOfTime(TreeNode root, int start) {
        depth(root, start);
        return Solution.time;
    }
}
