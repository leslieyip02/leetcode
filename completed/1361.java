import java.util.*;

class Solution {
    private int findRoot(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> children = new HashSet<>();
        for (int i = 0; i < n; i++) {
            children.add(leftChild[i]);
            children.add(rightChild[i]);
        }
        for (int i = 0; i < n; i++) {
            if (!children.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int root = this.findRoot(n, leftChild, rightChild);
        if (root == -1) {
            return false;
        }

        Stack<Integer> nodes = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        nodes.push(root);
        visited.add(root);
        while (!nodes.isEmpty()) {
            int node = nodes.pop();
            if (leftChild[node] != -1) {
                // loop
                if (visited.contains(leftChild[node])) {
                    return false;
                }
                nodes.push(leftChild[node]);
                visited.add(leftChild[node]);
            }
            if (rightChild[node] != -1) {
                if (visited.contains(rightChild[node])) {
                    return false;
                }
                nodes.push(rightChild[node]);
                visited.add(rightChild[node]);
            }
        }
        return visited.size() == n;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] leftChild = { 1, 2, 0, 4, -1, -1 };
        int[] rightChild = { -1, -1, -1, 5, -1, -1 };

        Solution solution = new Solution();
        System.out.println(solution.validateBinaryTreeNodes(n, leftChild, rightChild));
    }
}
