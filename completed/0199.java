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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ordered = new ArrayList<>();
        traverse(root, 0, ordered);
        return ordered;
    }

    private void traverse(TreeNode root, int depth, List<Integer> ordered) {
        if (root == null) {
            return;
        }

        if (depth >= ordered.size()) {
            ordered.add(root.val);
        }

        traverse(root.right, depth + 1, ordered);
        traverse(root.left, depth + 1, ordered);
    }
}
