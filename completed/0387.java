class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> f = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            f.put(c, f.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (f.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }
}
