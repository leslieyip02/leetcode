class Solution {
    public int waysToMakeFair(int[] nums) {
        int totalOddSum = 0;
        int totalEvenSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                totalEvenSum += nums[i];
            } else {
                totalOddSum += nums[i];
            }
        }

        int oddPrefixSum = 0;
        int evenPrefixSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int oddSum = oddPrefixSum + totalEvenSum - evenPrefixSum;
            int evenSum = evenPrefixSum + totalOddSum - oddPrefixSum;
            if (i % 2 == 0) {
                oddSum -= nums[i];
            } else {
                evenSum -= nums[i];
            }
            if (oddSum == evenSum) {
                count++;
            }

            if (i % 2 == 0) {
                evenPrefixSum += nums[i];
            } else {
                oddPrefixSum += nums[i];
            }
        }
        return count;
    }
}
