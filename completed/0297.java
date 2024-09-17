import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static final String NULL_STRING = "x";
    private static final String SEP = ",";

    private void buildBuffer(TreeNode root, StringBuilder buffer) {
        if (root == null) {
            buffer.append(NULL_STRING);
            buffer.append(SEP);
        } else {
            buffer.append(root.val);
            buffer.append(SEP);
            buildBuffer(root.left, buffer);
            buildBuffer(root.right, buffer);
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder buffer = new StringBuilder();
        buildBuffer(root, buffer);
        return buffer.deleteCharAt(buffer.length() - 1).toString();
    }

    private TreeNode buildTree(Queue<String> nodeStrings) {
        String current = nodeStrings.poll();
        if (current.compareTo(NULL_STRING) == 0) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.parseInt(current));
            node.left = buildTree(nodeStrings);
            node.right = buildTree(nodeStrings);
            return node;
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.compareTo("") == 0) {
            return null;
        }

        String[] tokens = data.split(SEP);
        Queue<String> nodeStrings = new LinkedList<>();
        for (String token : tokens) {
            nodeStrings.add(token);
        }
        return buildTree(nodeStrings);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
