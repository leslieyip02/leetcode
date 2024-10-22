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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        int levels = 0;
        PriorityQueue<Long> sums = new PriorityQueue<>();
        while (!nodes.isEmpty()) {
            long sum = 0;
            Queue<TreeNode> next = new LinkedList<>();
            while (!nodes.isEmpty()) {
                TreeNode current = nodes.poll();
                sum += current.val;
                if (current.left != null) {
                    next.add(current.left);
                }
                if (current.right != null) {
                    next.add(current.right);
                }
            }
            sums.add(sum);
            if (sums.size() > k) {
                sums.poll();
            }

            nodes.addAll(next);
            levels++;
        }

        if (levels < k) {
            return -1;
        }

        return sums.poll();
    }
}
