from collections import Counter


class Solution:
    def isGood(self, nums: List[int]) -> bool:
        n = len(nums) - 1

        counts = Counter(nums)
        if len(counts.keys()) != n:
            return False
        for i in range(1, n):
            if counts[i] != 1:
                return False
        if counts[n] != 2:
            return False
        return True
