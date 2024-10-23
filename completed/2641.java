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
    private TreeNode createTree(TreeNode current, int nodeVal, int level, List<Integer> levelSums) {
        if (level > levelSums.size()) {
            return null;
        }

        TreeNode newNode = new TreeNode(nodeVal);
        if (level == levelSums.size()) {
            return newNode;
        }

        int childSum = 0;
        if (current.left != null) {
            childSum += current.left.val;
        }
        if (current.right != null) {
            childSum += current.right.val;
        }
        int cousinSum = levelSums.get(level) - childSum;

        if (current.left != null) {
            newNode.left = createTree(current.left, cousinSum, level + 1, levelSums);
        }
        if (current.right != null) {
            newNode.right = createTree(current.right, cousinSum, level + 1, levelSums);
        }
        return newNode;
    }

    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        List<Integer> levelSums = new ArrayList<>();
        while (!nodes.isEmpty()) {
            Queue<TreeNode> level = new LinkedList<>();
            int sum = 0;
            while (!nodes.isEmpty()) {
                TreeNode current = nodes.poll();
                sum += current.val;
                if (current.left != null) {
                    level.add(current.left);
                }
                if (current.right != null) {
                    level.add(current.right);
                }
            }
            levelSums.add(sum);
            nodes.addAll(level);
        }
        return createTree(root, 0, 1, levelSums);
    }
}
