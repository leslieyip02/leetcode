class Solution {
    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        for (int i = 1; i < n; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }
        }

        // just factorial?
        long count = 1;
        for (int i = 2; i < complexity.length; i++) {
            count *= i;
            count %= (int) 1e9 + 7;
        }
        return (int) count;
    }
}
