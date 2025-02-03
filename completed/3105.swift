class Solution {
    func longestMonotonicSubarray(_ nums: [Int]) -> Int {
        var longest = 1

        var current = 0
        var increasing = false
        var decreasing = false
        for i in 1 ..< nums.count {
            if nums[i] > nums[i - 1] {
                if increasing {
                    current += 1
                } else {
                    longest = max(current, longest)
                    increasing = true
                    decreasing = false
                    current = 2
                }
            } else if nums[i] < nums[i - 1] {
                if decreasing {
                    current += 1
                } else {
                    longest = max(current, longest)
                    increasing = false
                    decreasing = true
                    current = 2
                }
            } else {
                longest = max(current, longest)
                increasing = false
                decreasing = false 
                current = 0
            }
        }
        return max(current, longest)
    }
}
