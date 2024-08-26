import java.util.*;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    private void traverse(Node current, List<Integer> order) {
        if (current == null) {
            return;
        }

        if (current.children != null) {
            for (Node child : current.children) {
                traverse(child, order);
            }
        }
        order.add(current.val);
    }

    public List<Integer> postorder(Node root) {
        List<Integer> order = new ArrayList<>();
        traverse(root, order);
        return order;
    }
}
