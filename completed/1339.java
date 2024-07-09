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
    private int subtreeSums(TreeNode current, Map<TreeNode, Integer> sums) {
        if (current == null) {
            return 0;
        }

        int sum = current.val + subtreeSums(current.left, sums) + subtreeSums(current.right, sums);
        sums.put(current, sum);
        return sum;
    }

    public int maxProduct(TreeNode root) {
        Map<TreeNode, Integer> sums = new HashMap<>();
        subtreeSums(root, sums);
        long total = sums.get(root);
        long maximum = 0;
        for (int sum : sums.values()) {
            long product = (long) sum * (total - sum);
            maximum = Math.max(product, maximum);
        }
        return (int) (maximum % (int) (1e9 + 7));
    }
}
