class Solution {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        Set<Integer> summed = new HashSet<>();
        while (left < right) {
            int sum = nums[left] + nums[right];
            summed.add(sum);
            left++;
            right--;
        }
        return summed.size();
    }
}
