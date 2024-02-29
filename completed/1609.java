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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> layer = new LinkedList<>();
        layer.add(root);
        boolean odd = true;
        while (!layer.isEmpty()) {
            int n = layer.size();
            int previous = odd ? 0 : Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                TreeNode current = layer.poll();
                if (odd) {
                    if (current.val % 2 == 0 || current.val <= previous) {
                        return false;
                    }
                } else {
                    if (current.val % 2 == 1 || current.val >= previous) {
                        return false;
                    }
                }
                previous = current.val;
                if (current.left != null) {
                    layer.add(current.left);
                }
                if (current.right != null) {
                    layer.add(current.right);
                }
            }
            odd = !odd;
        }
        return true;
    }
}
