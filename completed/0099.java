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

    private void traverse(TreeNode current, PriorityQueue<Integer> ordered) {
        if (current == null) {
            return;
        }

        traverse(current.left, ordered);
        ordered.add(current.val);
        traverse(current.right, ordered);
    }

    private void recover(TreeNode current, PriorityQueue<Integer> ordered) {
        if (current == null) {
            return;
        }

        recover(current.left, ordered);
        current.val = ordered.poll();
        recover(current.right, ordered);
    }

    public void recoverTree(TreeNode root) {
        PriorityQueue<Integer> ordered = new PriorityQueue<>();
        traverse(root, ordered);
        recover(root, ordered);
    }
}
