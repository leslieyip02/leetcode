class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int[] zeros = new int[n];
        zeros[0] = s.charAt(0) == '0' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            zeros[i] = zeros[i - 1] + (s.charAt(i) == '0' ? 1 : 0);
        }
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            int left = zeros[i];
            int right = (n - (i + 1)) - (zeros[n - 1] - zeros[i]);
            max = Math.max(left + right, max);
        }
        return max;
    }
}
