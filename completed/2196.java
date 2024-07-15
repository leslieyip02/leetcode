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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] description : descriptions) {
            int parent = description[0];
            int child = description[1];
            boolean isLeft = description[2] == 1;

            TreeNode parentNode = nodes.getOrDefault(parent, new TreeNode(parent));
            TreeNode childNode = nodes.getOrDefault(child, new TreeNode(child));
            if (isLeft) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
            nodes.put(parent, parentNode);
            nodes.put(child, childNode);
            children.add(child);
        }

        for (int nodeKey : nodes.keySet()) {
            if (!children.contains(nodeKey)) {
                return nodes.get(nodeKey);
            }
        }
        return null;
    }
}
