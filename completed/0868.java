class Solution {
    public int binaryGap(int n) {
        // skip to first 1
        while (n > 0 && (n & 1) != 1) {
            n >>= 1;
        }

        int longest = 0;
        int gap = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                longest = Math.max(gap, longest);
                gap = 0;
            }
            gap++;
            n >>= 1;
        }
        return longest;
    }
}
