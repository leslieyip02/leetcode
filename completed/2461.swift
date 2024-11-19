import Collections

class Solution {
    func maximumSubarraySum(_ nums: [Int], _ k: Int) -> Int {
        var seen = Set<Int>()
        var left = 0
        var right = 0
        var maximum = 0
        var current = 0
        while right < nums.count {
            while right - left >= k || seen.contains(nums[right]) {
                seen.remove(nums[left])
                current -= nums[left]
                left += 1
            }

            seen.insert(nums[right])
            current += nums[right]
            if seen.count == k {
                maximum = max(current, maximum)
            }
            right += 1
        }
        return maximum
    }
}
