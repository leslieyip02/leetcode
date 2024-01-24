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
    private int search(TreeNode node, HashMap<Integer, Integer> valueCounts) {
        valueCounts.put(node.val, valueCounts.getOrDefault(node.val, 0) + 1);
        if (node.left == null && node.right == null) {
            boolean odd = false;
            for (int count : valueCounts.values()) {
                if (count % 2 == 1) {
                    if (odd) {
                        valueCounts.put(node.val, valueCounts.get(node.val) - 1);
                        return 0;
                    }
                    odd = true;
                }
            }
            valueCounts.put(node.val, valueCounts.get(node.val) - 1);
            return 1;
        }

        int total = 0;
        if (node.left != null) {
            total += this.search(node.left, valueCounts);
        }
        if (node.right != null) {
            total += this.search(node.right, valueCounts);
        }
        valueCounts.put(node.val, valueCounts.get(node.val) - 1);
        return total;
    }

    public int pseudoPalindromicPaths (TreeNode root) {
        HashMap<Integer, Integer> valueCounts = new HashMap<>();
        return this.search(root, valueCounts);
    }
}
