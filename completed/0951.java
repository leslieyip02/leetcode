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
    private boolean trace(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2 == null;
        } else if (root2 == null) {
            return root1 == null;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return (trace(root1.left, root2.left) && trace(root1.right, root2.right)) ||
            (trace(root1.left, root2.right) && trace(root1.right, root2.left));
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return trace(root1, root2);
    }
}
