class Solution {
    func maxAscendingSum(_ nums: [Int]) -> Int {
        var result = 0
        var current = nums.first!
        for i in 1 ..< nums.count {
            if nums[i] > nums[i - 1] {
                current += nums[i]
            } else {
                result = max(current, result)
                current = nums[i]
            }
        } 
        return max(current, result)
    }
}
