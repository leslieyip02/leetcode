class Solution:
    def largestDivisibleSubset(self, nums):
        nums = list(sorted(nums))
        subsets = [set([num]) for num in nums]
        for i, num in enumerate(nums):
            longest = set()
            for j in range(i - 1, -1, -1):
                if num % nums[j] == 0 and len(longest) < len(subsets[j]):
                    longest = subsets[j]
            subsets[i] |= longest

        answer = subsets[0]
        for i in range(1, len(subsets)):
            if len(subsets[i]) > len(answer):
                answer = subsets[i]
        return list(sorted(answer))


if __name__ == "__main__":
    # nums = [ 1, 2, 4, 8 ]
    nums = [ 4, 8, 10, 240 ]

    solution = Solution()
    print(solution.largestDivisibleSubset(nums))
