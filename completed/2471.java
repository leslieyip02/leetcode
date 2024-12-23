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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        int operations = 0;
        while (!nodes.isEmpty()) {
            Queue<TreeNode> level = new LinkedList<>();
            List<Integer> values = new ArrayList<>();
            List<Integer> ordered = new ArrayList<>();
            Map<Integer, Integer> indices = new HashMap<>();
            int index = 0;
            while (!nodes.isEmpty()) {
                TreeNode current = nodes.poll();
                if (current.left != null) {
                    level.add(current.left);
                }
                if (current.right!= null) {
                    level.add(current.right);
                }

                values.add(current.val);
                ordered.add(current.val);
                indices.put(current.val, index);
                index++;
            }

            Collections.sort(ordered);
            for (int i = 0; i < values.size(); i++) {
                int current = values.get(i);
                int target = ordered.get(i);
                if (current != target) {
                    int j = indices.get(target);
                    Collections.swap(values, i, j);
                    indices.put(current, j);
                    operations++;
                }
            }

            nodes = level;
        }

        return operations;
    }
}
