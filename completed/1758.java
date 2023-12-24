class Solution {
    public int minOperations(String s) {
        int z = 0;
        int o = 0;
        for (int i = 0; i < s.length(); i++) {
            int v = s.charAt(i) - '0';
            z += i % 2 == v ? 1 : 0;
            o += i % 2 != v ? 1 : 0;
        }
        return Math.min(z, o);
    }
}
