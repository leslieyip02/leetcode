from collections import defaultdict


class Solution:
    def lexicographicallySmallestArray(self, nums: List[int], limit: int) -> List[int]:
        indices = defaultdict(list)
        for index, num in enumerate(nums):
            indices[num].append(index)

        smallest = [0] * len(nums)
        current_nums = []
        current_indices = []
        previous = 0
        for key in sorted(indices.keys()):
            if key - previous > limit:
                for index, num in zip(sorted(current_indices), sorted(current_nums)):
                    smallest[index] = num
                current_nums.clear()
                current_indices.clear()

            current_nums.extend([key] * len(indices[key]))
            current_indices.extend(indices[key])
            previous = key

        for index, num in zip(sorted(current_indices), sorted(current_nums)):
            smallest[index] = num
        return smallest

