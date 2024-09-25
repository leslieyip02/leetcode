import java.util.*;

class Solution {
    private class TrieNode {
        TrieNode[] children;
        int visited;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.visited = 0;
        }

        public void add(String word, int leftIndex) {
            int index = (int) word.charAt(leftIndex) - 'a';
            if (children[index] == null) {
                children[index] = new TrieNode();
            }

            children[index].visited++;
            if (leftIndex + 1 < word.length()) {
                children[index].add(word, leftIndex + 1);
            }
        }

        public int score(String word, int leftIndex) {
            int current = visited;
            if (leftIndex == word.length()) {
                return current;
            }

            int index = (int) word.charAt(leftIndex) - 'a';
            if (children[index] != null) {
                current += children[index].score(word, leftIndex + 1);
            }
            return current;
        }
    }

    public int[] sumPrefixScores(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.add(word, 0);
        }

        int[] answer = new int[words.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] += root.score(words[i], 0);
        }
        return answer;
    }
}
