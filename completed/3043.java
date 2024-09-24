import java.util.*;

class Solution {
    private class Node {
        Node[] children;

        public Node() {
            this.children = new Node[11];
        }

        public void add(String value, int leftIndex) {
            if (leftIndex >= value.length()) {
                return;
            }

            int childIndex = (int) value.charAt(leftIndex) - '0';
            if (children[childIndex] == null) {
                children[childIndex] = new Node();
            }
            children[childIndex].add(value, leftIndex + 1);
        }

        public int prefixLength(String value, int leftIndex) {
            if (leftIndex >= value.length()) {
                return 0;
            }

            int childIndex = (int) value.charAt(leftIndex) - '0';
            if (children[childIndex] == null) {
                return 0;
            }
            return children[childIndex].prefixLength(value, leftIndex + 1) + 1;
        }
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Node root = new Node();
        for (int num : arr1) {
            root.add(num + "", 0);
        }

        int longest = 0;
        for (int num : arr2) {
            longest = Math.max(root.prefixLength(num + "", 0), longest);
        }
        return longest;
    }
}
