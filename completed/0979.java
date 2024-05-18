import java.util.*;

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
    private int moves = 0;

    private int trace(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = trace(root.left);
        int right = trace(root.right);
        moves += Math.abs(left) + Math.abs(right);
        return (root.val - 1) + left + right;
    }

    public int distributeCoins(TreeNode root) {
        trace(root);
        return moves;
    }
}
