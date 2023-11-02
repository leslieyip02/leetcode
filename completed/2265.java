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
import java.util.*;

class Solution {
    private int[] visitNode(TreeNode node) {
        // 1st value is the sum
        // 2nd value is tht total
        // 3rd value is the count
        int[] result = { node.val, 1, 0 };
        TreeNode[] children = { node.left, node.right };
        for (TreeNode child : children) {
            if (child != null) {
                int[] childResult = this.visitNode(child);
                for (int i = 0; i < result.length; i++) {
                    result[i] += childResult[i];
                }
            }
        }

        if (result[0] / result[1] == node.val) {
            result[2]++;
        }
        return result;
    }

    public int averageOfSubtree(TreeNode root) {
        int[] result = this.visitNode(root);
        return result[2];
    }
}
