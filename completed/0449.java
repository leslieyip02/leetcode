/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

public class Codec {

    private void encode(TreeNode current, StringBuilder sb) {
        if (current == null) {
            return;
        }

        // current(left(...)(...))(right(...)(...))
        sb.append(current.val);

        sb.append('(');
        encode(current.left, sb);
        sb.append(')');

        sb.append('(');
        encode(current.right, sb);
        sb.append(')');
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        encode(root, sb);
        return sb.toString();
    }

    private TreeNode decode(String current) {
        if (current.length() == 0) {
            return null;
        }

        int start = current.indexOf('(');
        int val = Integer.parseInt(current.substring(0, start));
        TreeNode root = new TreeNode(val);

        int depth = 1;
        int end = start; 
        while (depth > 0) {
            end++;
            char c = current.charAt(end);
            if (c == '(') {
                depth++;
            } else if (c == ')') {
                depth--;
            }
        }
        root.left = decode(current.substring(start + 1, end));
        root.right = decode(current.substring(end + 2, current.length() - 1));
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return decode(data);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
