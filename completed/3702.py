class Solution:
    def longestSubsequence(self, nums: List[int]) -> int:
        bits = [0] * 32
        for num in nums:
            i = 0
            while num != 0:
                if (num & 1) == 1:
                    bits[i] += 1
                num >>= 1
                i += 1

        if sum(bits) == 0:
            return 0
        elif all(bit % 2 == 0 for bit in bits):
            return len(nums) - 1
        else:
            return len(nums)

