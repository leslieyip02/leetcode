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
    private int search(TreeNode current, int distance, Set<TreeNode> leaves, Map<TreeNode, TreeNode> parents, Set<TreeNode> visited, TreeNode start) {
        if (current != start && (distance < 0 || visited.contains(current))) {
            return 0;
        }

        visited.add(current);
        if (current != start && leaves.contains(current)) {
            return 1;
        }

        int good = 0;
        TreeNode parent = parents.get(current);
        if (parent != null) {
            good += search(parent, distance - 1, leaves, parents, visited, start);
        }
        if (current.left != null) {
            good += search(current.left, distance - 1, leaves, parents, visited, start);
        }
        if (current.right != null) {
            good += search(current.right, distance - 1, leaves, parents, visited, start);
        }
        return good;
    }

    public int countPairs(TreeNode root, int distance) {
        Set<TreeNode> leaves = new HashSet<>();
        Map<TreeNode, TreeNode> parents = new HashMap<>();

        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        while (!bfs.isEmpty()) {
            TreeNode current = bfs.poll();
            if (current.left == null && current.right == null) {
                leaves.add(current);
            }

            if (current.left != null) {
                parents.put(current.left, current);
                bfs.add(current.left);
            }
            if (current.right != null) {
                parents.put(current.right, current);
                bfs.add(current.right);
            }
        }

        int pairs = 0;
        for (TreeNode leaf : leaves) {
            Set<TreeNode> visited = new HashSet<>();
            pairs += search(leaf, distance, leaves, parents, visited, leaf);
        }
        return pairs / 2;
    }
}
