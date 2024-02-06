import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                counts[(int) c - 97]++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < counts[i]; j++) { 
                    sb.append((char) (i + 97));
                }
            }
            String sorted = sb.toString();
            if (!groups.containsKey(sorted)) {
                groups.put(sorted, new ArrayList<>());
            }
            groups.get(sorted).add(str);
        }
        List<List<String>> output = new ArrayList<>();
        for (List<String> group : groups.values()) {
            output.add(group);
        }
        return output;
    }
}
