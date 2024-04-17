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
    private String smallest = null;

    private void trace(TreeNode root, String current) {
        current = String.format("%c%s", root.val + 97, current);
        if (root.left == null && root.right == null) {
            if (smallest == null || current.compareTo(smallest) < 0) {
                smallest = current;
            }
        } else {
            if (root.left != null) {
                trace(root.left, current);
            }
            if (root.right != null) {
                trace(root.right, current);
            }
        }
    }

    public String smallestFromLeaf(TreeNode root) {
        trace(root, "");
        return smallest;
    }
}
