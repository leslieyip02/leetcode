import java.util.*;

class Solution {
    private HashMap<Integer, HashMap<Integer, List<List<String>>>> memo;

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private List<List<String>> choose(String s, int start, int end) {
        if (end > s.length()) {
            return null;
        }

        if (memo.containsKey(start) && memo.get(start).containsKey(end)) {
            return memo.get(start).get(end);
        }

        List<List<String>> results = new ArrayList<>();
        String current = s.substring(start, end);
        if (isPalindrome(current)) {
            // choose
            if (end == s.length()) {
                List<String> result = new ArrayList<>();
                result.add(current);
                results.add(result);
                return results;
            }

            var subresults = choose(s, end, end + 1);
            if (subresults != null) {
                for (var subresult : subresults) {
                    List<String> copy = new ArrayList<>();
                    copy.add(current);
                    copy.addAll(subresult);
                    results.add(copy);
                }
            }
        }

        // don't choose
        var subresults = choose(s, start, end + 1);
        if (subresults != null) {
            results.addAll(subresults);
        }

        if (!memo.containsKey(start)) {
            memo.put(start, new HashMap<>());
        }
        memo.get(start).put(end, results);
        return results;
    }

    public List<List<String>> partition(String s) {
        memo = new HashMap<>();
        return choose(s, 0, 1);
    }
}
