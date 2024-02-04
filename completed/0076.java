class Solution {
    private boolean isValid(HashMap<Character, Integer> target, HashMap<Character, Integer> current) {
        for (Map.Entry<Character, Integer> entry : target.entrySet()) {
            char c = entry.getKey();
            int v = entry.getValue();
            if (current.getOrDefault(c, 0) < v) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> target = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            target.put(c, target.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        String min = "";
        HashMap<Character, Integer> current = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            current.put(c, current.getOrDefault(c, 0) + 1);
            while (this.isValid(target, current)) {
                String sub = s.substring(left, right + 1);
                if (min.compareTo("") == 0 || sub.length() < min.length()) {
                    min = sub;
                }
                c = s.charAt(left);
                current.put(c, current.get(c) - 1);
                left++;
            }
            right++;
        }
        return min;
    }
}
