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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDelete = new HashSet<>();
        for (int num : to_delete) {
            toDelete.add(num);
        }

        List<TreeNode> roots = new ArrayList<>();
        Queue<TreeNode> bfs = new LinkedList<>();
        if (!toDelete.contains(root.val)) {
            roots.add(root);
            bfs.add(root);
        } else {
            if (root.left != null) {
                if (!toDelete.contains(root.left.val)) {
                    roots.add(root.left);
                }
                bfs.add(root.left);
            }
            if (root.right != null) {
                if (!toDelete.contains(root.right.val)) {
                    roots.add(root.right);
                }
                bfs.add(root.right);
            }
        }
        while (!bfs.isEmpty()) {
            TreeNode current = bfs.poll();
            if (toDelete.contains(current.val)) {
                if (current.left != null) {
                    if (!toDelete.contains(current.left.val)) {
                        roots.add(current.left);
                    }
                }
                if (current.right != null) {
                    if (!toDelete.contains(current.right.val)) {
                        roots.add(current.right);
                    }
                }
            }

            if (current.left != null) {
                bfs.add(current.left);
                if (toDelete.contains(current.left.val)) {
                    current.left = null;
                }
            }
            if (current.right != null) {
                bfs.add(current.right);
                if (toDelete.contains(current.right.val)) {
                    current.right = null;
                }
            }
        }
        return roots;
    }
}
