class Solution {
    func bitCountsToInt(_ bitCounts: [Int]) -> Int {
        var value = 0
        for (i, count) in bitCounts.enumerated() {
            if count > 0 {
                value |= (1 << i)
            }
        }
        return value
    }

    func updateBitCounts(_ bitCounts: inout [Int], _ num: Int, add: Bool) {
        var num = num
        var index = 0
        while num > 0 {
            if (num & 1) == 1 {
                bitCounts[index] += add ? 1 : -1
            }
            num >>= 1
            index += 1
        }
    }

    func minimumSubarrayLength(_ nums: [Int], _ k: Int) -> Int {
        if k == 0 {
            return 1
        }

        var left = 0
        var right = 0
        var currentOr = 0
        var bitCounts = Array(repeating: 0, count: 32)
        var minimumLength = nums.count + 1
        while right < nums.count {
            currentOr |= nums[right]
            updateBitCounts(&bitCounts, nums[right], add: true)

            while bitCountsToInt(bitCounts) >= k {
                minimumLength = min(right - left + 1, minimumLength)
                updateBitCounts(&bitCounts, nums[left], add: false)
                left += 1
            }

            right += 1
        }
        return minimumLength == nums.count + 1 ? -1 : minimumLength
    }
}
