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
    private int search(TreeNode current, Map<Integer, Integer> ancestors) {
        int max = 0;
        if (current == null) {
            return max;
        }

        for (Map.Entry<Integer, Integer> ancestor : ancestors.entrySet()) {
            if (ancestor.getValue() == 0) {
                continue;
            }
            max = Math.max(Math.abs(ancestor.getKey() - current.val), max);
        }
        ancestors.put(current.val, ancestors.getOrDefault(current.val, 0) + 1);
        max = Math.max(search(current.left, ancestors), max);
        max = Math.max(search(current.right, ancestors), max);
        ancestors.put(current.val, ancestors.getOrDefault(current.val, 0) - 1);
        return max;
    }

    public int maxAncestorDiff(TreeNode root) {
        return search(root, new HashMap<>());
    }
}
