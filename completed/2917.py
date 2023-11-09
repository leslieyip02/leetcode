class Solution:
    def findKOr(self, nums, k):
        largest = max(nums)
        masks = [0]
        current = 1
        while current <= largest:
            masks.append(current)
            current <<= 1

        kOr = 0
        for mask in masks:
            count = 0
            for num in nums:
                if num & mask == mask:
                    count += 1
            if count >= k:
                kOr += mask
        return kOr
        

if __name__ == "__main__":
    nums =  [ 7, 12, 9, 8, 9, 15 ]
    k = 4

    solution = Solution()
    print(solution.findKOr(nums, k))
