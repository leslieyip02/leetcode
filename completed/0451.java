import java.util.*;

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> f = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            f.put(c, f.getOrDefault(c, 0) + 1);
        }
        List<String> ss = new ArrayList<>();
        for (Map.Entry<Character, Integer> e : f.entrySet()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < e.getValue(); i++) {
                sb.append(e.getKey());
            }
            ss.add(sb.toString());
        }
        ss.sort((s1, s2) -> s2.length() - s1.length());
        StringBuilder sb = new StringBuilder();
        for (String sss : ss) {
            sb.append(sss);
        }
        return sb.toString();
    }
}
