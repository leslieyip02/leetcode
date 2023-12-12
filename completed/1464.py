class Solution:
    def maxProduct(self, nums):
        a, b = 0, 0
        for num in nums:
            if num >= a:
                b = a
                a = num
            elif num > b:
                b = num
        return (a - 1) * (b - 1)
