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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<TreeNode> previous = new LinkedList<>();
        Queue<TreeNode> row = new LinkedList<>();

        row.add(root);
        while (!row.isEmpty()) {
            nodes = row;
            previous = new LinkedList<>();
            row = new LinkedList<>();
            while (!nodes.isEmpty()) {
                TreeNode current = nodes.poll();
                previous.add(current);
                if (current.left != null) {
                    row.add(current.left);
                }
                if (current.right != null) {
                    row.add(current.right);
                }
            }
        }
        return previous.peek().val;
    }
}
