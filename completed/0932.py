class Solution:
    def beautifulArray(self, n):
        return self.shuffle(list(range(1, n + 1)))

    def shuffle(self, nums):
        if len(nums) <= 2:
            return nums

        odds = [i >> 1 for i in nums if i % 2 == 1]
        evens = [i >> 1 for i in nums if i % 2 == 0]
        shuffled_odds = [(i << 1) + 1 for i in self.shuffle(odds)]
        shuffled_evens = [(i << 1) for i in self.shuffle(evens)]
        return shuffled_odds + shuffled_evens


if __name__ == "__main__":
    n = 4

    solution = Solution()
    print(solution.beautifulArray(n))
