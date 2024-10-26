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
    private int currentMaxHeight;

    private void traceLeftRight(TreeNode root, int currentHeight, Map<Integer, Integer> maxHeights) {
        if (root == null) {
            return;
        }

        maxHeights.put(root.val, currentMaxHeight);
        currentMaxHeight = Math.max(currentHeight, currentMaxHeight);

        traceLeftRight(root.left, currentHeight + 1, maxHeights);
        traceLeftRight(root.right, currentHeight + 1, maxHeights);
    }

    private void traceRightLeft(TreeNode root, int currentHeight, Map<Integer, Integer> maxHeights) {
        if (root == null) {
            return;
        }

        maxHeights.put(root.val, Math.max(maxHeights.get(root.val), currentMaxHeight));
        currentMaxHeight = Math.max(currentHeight, currentMaxHeight);

        traceRightLeft(root.right, currentHeight + 1, maxHeights);
        traceRightLeft(root.left, currentHeight + 1, maxHeights);
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        Map<Integer, Integer> maxHeights = new HashMap<>();
        currentMaxHeight = 0;
        traceLeftRight(root, 0, maxHeights);
        currentMaxHeight = 0;
        traceRightLeft(root, 0, maxHeights);

        int m = queries.length;
        int[] answer = new int[m];
        for (int i = 0; i < m; i++) {
            answer[i] = maxHeights.get(queries[i]);
        }
        return answer;
    }
}
