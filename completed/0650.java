class Solution {
    public int minSteps(int n) {
        int[] steps = new int[n + 1];
        for (int i = 1; i < n; i++) {
            int j = 2;
            while (i * j <= n) {
                steps[i * j] = steps[i] + j;
                j++;
            }
        }
        return steps[n];
    }
}
