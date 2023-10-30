import java.util.*;

class Solution {
    class BitNumber implements Comparable<BitNumber> {
        int value;
        int bits;

        public BitNumber(int value) {
            this.value = value;
            this.bits = 0;
            while (value > 0) {
                if ((value & 1) == 1) {
                    this.bits++;
                }
                value >>= 1;
            }
        }

        @Override
        public int compareTo(BitNumber other) {
            return this.bits == other.bits
                ? this.value - other.value
                : this.bits - other.bits;
        }
    }

    public int[] sortByBits(int[] arr) {
        BitNumber[] nums = new BitNumber[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = new BitNumber(arr[i]);
        }
        Arrays.sort(nums);

        int[] sorted = new int[arr.length];
        for (int i = 0; i < nums.length; i++) {
            sorted[i] = nums[i].value;
        }
        return sorted;
    }

    public static void main(String[] args) {
        // int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] arr = { 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1 };

        Solution solution = new Solution();
        var result = solution.sortByBits(arr);
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
