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

    int deepestDepth;
    int deepestCount;
    Map<Integer, Integer> depths;

    TreeNode lca = null;

    private int find(TreeNode current) {
        if (current == null || lca != null) {
            return 0;
        }

        int count = depths.get(current.val) == deepestDepth ? 1 : find(current.left) + find(current.right);
        if (count == deepestCount && (lca == null || depths.get(current.val) > depths.get(lca.val))) {
            lca = current;
        }
        return count;
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int currentDepth = 0;
        int currentCount = 0;
        depths = new HashMap<>();

        Queue<TreeNode> currentLevel = new LinkedList<>();
        currentLevel.add(root);
        while (!currentLevel.isEmpty()) {
            currentDepth++;
            currentCount = currentLevel.size();

            Queue<TreeNode> nextLevel = new LinkedList<>();
            while (!currentLevel.isEmpty()) {
                TreeNode current = currentLevel.poll();
                depths.put(current.val, currentDepth);
                if (current.left != null) {
                    nextLevel.add(current.left);
                }
                if (current.right != null) {
                    nextLevel.add(current.right);
                }
            }
            currentLevel = nextLevel;
        }

        deepestDepth = currentDepth;
        deepestCount = currentCount;
        find(root);
        return lca;
    }
}
