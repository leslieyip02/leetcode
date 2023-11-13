import java.util.*;

class Solution {
    private static final HashSet<Character> vowels = new HashSet<>(
        Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u')
    );

    public String sortVowels(String s) {
        PriorityQueue<Character> sortedVowels = new PriorityQueue<>();
        for (int i = 0; i < s.length(); i++) {
            if (Solution.vowels.contains(s.charAt(i))) {
                sortedVowels.add(s.charAt(i));
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Solution.vowels.contains(s.charAt(i))) {
                result.append(sortedVowels.poll());
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "lEetcOde";

        Solution solution = new Solution();
        System.out.println(solution.sortVowels(s));
    }
}
