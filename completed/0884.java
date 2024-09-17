import java.util.*;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> seen = new HashMap<>();
        for (String word : s1.split(" ")) {
            seen.put(word, seen.getOrDefault(word, 0) + 1);
        }
        for (String word : s2.split(" ")) {
            seen.put(word, seen.getOrDefault(word, 0) + 1);
        }

        List<String> uncommon = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : seen.entrySet()) {
            if (entry.getValue() != 1) {
                continue;
            }
            uncommon.add(entry.getKey());
        }
        String[] answer = new String[uncommon.size()];
        for (int i = 0; i < uncommon.size(); i++) {
            answer[i] = uncommon.get(i);
        }
        return answer;
    }
}
