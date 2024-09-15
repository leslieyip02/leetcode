import java.util.*;

class Solution {
    private class Trie {
        TrieNode[] nodes;

        Trie() {
            this.nodes = new TrieNode[26];
        }

        public void insert(String prefix) {
            int nodeIndex = (int) prefix.charAt(0) - 97;
            if (nodes[nodeIndex] == null) {
                nodes[nodeIndex] = new TrieNode(prefix.charAt(0));
            }
            nodes[nodeIndex].insert(prefix, 0);
        }

        public int findPrefix(String target, int index) {
            int nodeIndex = (int) target.charAt(index) - 97;
            if (nodes[nodeIndex] == null) {
                return 0;
            }
            return nodes[nodeIndex].findPrefix(target, index);
        }
    }

    private class TrieNode {
        char value;
        TrieNode[] children;

        TrieNode(char value) {
            this.value = value;
            this.children = new TrieNode[26];
        }

        public void insert(String prefix, int index) {
            if (index + 1 == prefix.length()) {
                return;
            }

            int nextIndex = (int) prefix.charAt(index + 1) - 97;
            if (children[nextIndex] == null) {
                children[nextIndex] = new TrieNode(prefix.charAt(index + 1));
            }
            children[nextIndex].insert(prefix, index + 1);
        }

        public int findPrefix(String target, int index) {
            if (target.charAt(index) != value) {
                return 0;
            }

            int length = 1;
            if (index + 1 != target.length()) {
                int nextIndex = (int) target.charAt(index + 1) - 97;
                if (children[nextIndex] != null) {
                    length += children[nextIndex].findPrefix(target, index + 1);
                }
            }
            return length;
        }
    }

    private static final int IMPOSSIBLE = (int) 1e9;

    public int minValidStrings(String[] words, String target) {
        Trie prefixes = new Trie();
        for (String word : words) {
            prefixes.insert(word);
        }

        int[] counts = new int[target.length()];
        Arrays.fill(counts, IMPOSSIBLE);
        for (int i = 0; i < counts.length; i++) {
            int currentCount = i == 0 ? 0 : counts[i - 1];
            int maxLength = prefixes.findPrefix(target, i);
            for (int j = 0; j < maxLength; j++) {
                counts[i + j] = Math.min(currentCount + 1, counts[i + j]);
            }
        }
        return counts[counts.length - 1] == IMPOSSIBLE ? -1 : counts[counts.length - 1];
    }
}
