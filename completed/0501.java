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
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> counts = new HashMap<>();

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode current = nodes.poll();
            counts.put(current.val, counts.getOrDefault(current.val, 0) + 1);
            if (current.left != null) {
                nodes.add(current.left);
            }
            if (current.right != null) {
                nodes.add(current.right);
            }
        }

        int highest = 0;
        List<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int count = entry.getValue();
            if (count >= highest) {
                if (count > highest) {
                    highest = count;
                    modes.clear();
                }
                modes.add(entry.getKey());
            }
        }

        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }
}
