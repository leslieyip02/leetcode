class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int flips = 0;
        BitSet bits = new BitSet(nums.length);
        for (int i = 0; i < nums.length; i++) {
            bits.set(i, nums[i] == 1);
        }

        for (int i = 0; i < nums.length; i++) {
            if (!bits.get(i)) {
                if (i > nums.length - k) {
                    return -1;
                }
                bits.flip(i, i + k);
                flips++;
            }
        }

        return flips;
    }
}
