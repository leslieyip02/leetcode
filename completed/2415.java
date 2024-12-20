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
    public TreeNode reverseOddLevels(TreeNode root) {
        int levelNumber = 1;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int n = 1 << levelNumber;
            boolean done = false;
            TreeNode[] levelNodes = new TreeNode[n];
            for (int i = 0; i < n / 2; i++) {
                TreeNode current = nodes.poll();
                if (current.left == null) {
                    done = true;
                    break;
                }

                levelNodes[i * 2] = current.left;
                levelNodes[i * 2 + 1] = current.right;
            }
            if (done) {
                break;
            }

            if (levelNumber % 2 == 1) {
                for (int i = 0; i < n / 2; i++) {
                    int tmp = levelNodes[i].val;
                    levelNodes[i].val = levelNodes[n - 1 - i].val;
                    levelNodes[n - 1 - i].val = tmp;
                }
            }

            for (TreeNode node : levelNodes) {
                nodes.add(node);
            }
            levelNumber++;
        }
        return root;
    }
}
