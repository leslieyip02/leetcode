class Solution:
    def restoreArray(self, adjacentPairs):
        nums = {}
        for pair in adjacentPairs:
            a, b = pair
            nums[a] = nums.get(a, [])
            nums[b] = nums.get(b, [])
            nums[a].append(b)
            nums[b].append(a)

        current = None
        for num, adjacents in nums.items():
            if len(adjacents) == 1:
                current = num
                break

        original = []
        while current != None:
            previous = original[-1] if len(original) != 0 else None
            original.append(current)
            adjacents = nums[current]
            current = None
            for adjacent in adjacents:
                if adjacent != previous:
                    current = adjacent
                    break
        return original

if __name__ == "__main__":
    adjacentPairs = [ [ 2, 1], [ 3, 4], [ 3, 2 ] ]

    solution = Solution()
    print(solution.restoreArray(adjacentPairs))
