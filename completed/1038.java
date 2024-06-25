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
    private void insert(TreeNode current, Stack<TreeNode> nodes) {
        if (current == null) {
            return;
        }

        insert(current.left, nodes);
        nodes.push(current);
        insert(current.right, nodes);
    }

    public TreeNode bstToGst(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        insert(root, nodes);

        int sum = 0;
        while (!nodes.empty()) {
            TreeNode current = nodes.pop();
            sum += current.val;
            current.val = sum;
        }
        return root;
    }
}
