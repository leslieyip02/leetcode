class Solution:
    def findOriginalArray(self, changed):
        if len(changed) % 2 != 0:
            return []

        nums = {}
        for num in changed:
            nums[num] = nums.get(num, 0) + 1

        result = []
        for num in sorted(nums.keys()):
            if nums[num] == 0:
                continue

            if nums.get(num * 2, 0) < nums[num]:
                return []

            c = nums[num] if num != 0 else nums[num] // 2;
            result += [num] * c
            nums[num * 2] -= nums[num]

        return result 


if __name__ == "__main__":
    # changed = [ 1, 3, 4, 2, 6, 8 ]
    changed = [ 2, 1, 2, 4, 2, 4 ]
    # changed = [ 0, 0, 0, 0 ]

    solution = Solution()
    print(solution.findOriginalArray(changed))
