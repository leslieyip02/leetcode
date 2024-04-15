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
    private int trace(TreeNode root, int current) {
        if (root == null) {
            return 0;
        }

        current = current * 10 + root.val;
        if (root.left == null && root.right == null) {
            return current;
        }

        return trace(root.left, current) + trace(root.right, current);
    }

    public int sumNumbers(TreeNode root) {
        return trace(root, 0);
    }
}
