import java.util.*;

class Solution {
    private static final int M = (int) 1e9 + 7; 

    private int rev(int num) {
        int result = 0;
        while (num > 0) {
            result *= 10;
            result += num % 10;
            num /= 10;
        }
        return result;
    }

    public int countNicePairs(int[] nums) {
        int pairs = 0;
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        for (int num : nums) {
            int sum = num - rev(num);
            int frequency = frequencies.getOrDefault(sum, 0);
            pairs += frequency;
            pairs %= Solution.M;
            frequencies.put(sum, frequency + 1);
        }
        return pairs;
    }

    public static void main(String[] args) {
        int[] nums = { 13, 10, 35, 24, 76 };

        Solution solution = new Solution();
        System.out.println(solution.countNicePairs(nums));
    }
}
