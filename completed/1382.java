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
    private void insert(TreeNode current, List<TreeNode> nodes) {
        if (current == null) {
            return;
        }

        insert(current.left, nodes);
        nodes.add(current);
        insert(current.right, nodes);
    }

    private TreeNode balance(int left, int right, List<TreeNode> nodes) {
        int mid = (left + right) / 2;
        TreeNode current = nodes.get(mid);
        current.left = mid == left ? null : balance(left, mid - 1, nodes);
        current.right = mid == right ? null : balance(mid + 1, right, nodes);
        return current;
    }

    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        insert(root, nodes);
        return balance(0, nodes.size() - 1, nodes);
    }
}
