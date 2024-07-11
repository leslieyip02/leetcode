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
    private int subtreeSize(TreeNode current, int[] sizes, TreeNode[] nodes) {
        if (current == null) {
            return 0;
        }

        int size = subtreeSize(current.left, sizes, nodes) + 1 + subtreeSize(current.right, sizes, nodes);
        sizes[current.val - 1] = size;
        nodes[current.val - 1] = current;
        return size;
    }

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int[] sizes = new int[n];
        TreeNode[] nodes = new TreeNode[n];
        subtreeSize(root, sizes, nodes);

        // if subtree is less than half, then pick the parent to win
        if (sizes[x - 1] <= n / 2) {
            return true;
        }

        // if subutree is more than half, check the left and right
        TreeNode left = nodes[x - 1].left;
        if (left != null) {
            if (sizes[left.val - 1] > n / 2) {
                return true;
            }
        }
        TreeNode right = nodes[x - 1].right;
        if (right != null) {
            if (sizes[right.val - 1] > n / 2) {
                return true;
            }
        }
        return false;
    }
}
