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
    private String startPath;
    private String destPath;

    private void tracePaths(TreeNode currentNode, StringBuilder currentPath, int startValue, int destValue) {
        if (currentNode.val == startValue) {
            startPath = currentPath.toString();
        }
        if (currentNode.val == destValue) {
            destPath = currentPath.toString();
        }

        TreeNode leftNode = currentNode.left;
        if (leftNode != null) {
            int currentLength = currentPath.length();
            currentPath.append('L');
            tracePaths(leftNode, currentPath, startValue, destValue);
            currentPath.setLength(currentLength);
        }

        TreeNode rightNode = currentNode.right;
        if (rightNode != null) {
            int currentLength = currentPath.length();
            currentPath.append('R');
            tracePaths(rightNode, currentPath, startValue, destValue);
            currentPath.setLength(currentLength);
        }
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        tracePaths(root, new StringBuilder(), startValue, destValue);

        int i = 0;
        while (i < startPath.length() && i < destPath.length() && startPath.charAt(i) == destPath.charAt(i)) {
            i++;
        }

        String path = "U".repeat(startPath.length() - i) + destPath.substring(i);
        return path;
    }
}
