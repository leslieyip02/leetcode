class Solution:
    def tupleSameProduct(self, nums):
        products = {}
        for i, num in enumerate(nums):
            for j in range(i + 1, len(nums)):
                product = num * nums[j]
                products[product] = products.get(product, 0) + 1

        count = 0
        permutations = 2 * 2 * 2
        for p in products.values():
            count += p * (p - 1) // 2 * permutations
        return count


if __name__ == "__main__":
    nums = [ 1, 2, 4, 5, 10 ]

    solution = Solution()
    print(solution.tupleSameProduct(nums))
