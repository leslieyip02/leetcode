IMPOSSIBLE = 1e9

class Solution:
    def minimumDistance(self, nums: List[int]) -> int:
        num_indices = defaultdict(list)
        for i, num in enumerate(nums):
            num_indices[num].append(i)

        best_distance = IMPOSSIBLE
        for indices in num_indices.values():
            indices = sorted(indices)
            if len(indices) < 3:
                continue

            for i in range(len(indices) - 2):
                distance = abs(indices[i] - indices[i + 1]) \
                    + abs(indices[i + 1] - indices[i + 2]) \
                    + abs(indices[i] - indices[i + 2])
                best_distance = min(distance, best_distance)

        return -1 if best_distance == IMPOSSIBLE else best_distance

