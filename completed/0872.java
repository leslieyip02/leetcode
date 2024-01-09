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
    private List<Integer> leaves(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        if (root.left == null && root.right == null) {
            values.add(root.val);
            return values;
        }

        if (root.left != null) {
            values.addAll(this.leaves(root.left));
        }
        if (root.right != null) {
            values.addAll(this.leaves(root.right));
        }
        return values;
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = this.leaves(root1);
        List<Integer> leaves2 = this.leaves(root2);
        if (leaves1.size() != leaves2.size()) {
            return false;
        }
        for (int i = 0; i < leaves1.size(); i++) {
            if (leaves1.get(i) != leaves2.get(i)) {
                return false;
            }
        }
        return true;
    }
}
