class Solution:
    def minimumDeletions(self, nums: List[int]) -> int:
        min_index = 0
        max_index = 0
        for i, num in enumerate(nums):
            if num < nums[min_index]:
                min_index = i
            elif num > nums[max_index]:
                max_index = i

        min_left = min_index + 1
        max_left = max_index + 1
        min_right = len(nums) - min_index
        max_right = len(nums) - max_index

        return min(
            max(min_left, max_left),
            max(min_right, max_right),
            min_left + max_right,
            max_left + min_right,
        )

