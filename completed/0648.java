import java.util.*;

class Solution {
    private class TrieNode {
        boolean end;
        TrieNode[] next;

        public TrieNode() {
            this.next = new TrieNode[26];
        }

        public void add(String word) {
            if (word.length() == 0) {
                this.end = true;
                return;
            }

            char letter = word.charAt(0);
            int index = (int) letter - 97;
            if (this.next[index] == null) {
                this.next[index] = new TrieNode();
            }
            this.next[index].add(word.substring(1));
        }

        public StringBuilder find(String word) {
            if (this.end) {
                StringBuilder result = new StringBuilder();
                return result;
            }

            if (word.length() == 0) {
                return null;
            }

            char letter = word.charAt(0);
            int index = (int) letter - 97;
            if (this.next[index] == null) {
                return null;
            } else {
                StringBuilder result = this.next[index].find(word.substring(1));
                if (result != null) {
                    result.append(letter);
                }
                return result;
            }
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            root.add(word);
        }

        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            StringBuilder result = root.find(words[i]);
            if (result != null) {
                words[i] = result.reverse().toString();
            }
        }
        return String.join(" ", words);
    }
}
