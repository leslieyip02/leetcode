class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> triplets = new ArrayList<>();
        int left = 0;
        while (left < nums.length) {
            int mid = left + 1;
            int right = nums.length - 1;
            while (mid < right) {
                int sum = nums[left] + nums[mid] + nums[right];
                if (sum == 0) {
                    triplets.add(List.of(nums[left], nums[mid], nums[right]));

                    int currentMid = nums[mid];
                    while (mid < right && nums[mid] == currentMid) {
                        mid++;
                    }
                    continue;
                }

                if (sum < 0) {
                    mid++;
                } else {
                    right--;
                }
            }

            int currentLeft = nums[left];
            while (left < nums.length && nums[left] == currentLeft) {
                left++;
            }
        }
        return triplets;
    }
}
