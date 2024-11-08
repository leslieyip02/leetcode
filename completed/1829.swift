class Solution {
    func getMaximumXor(_ nums: [Int], _ maximumBit: Int) -> [Int] {
        var answer: [Int] = Array(repeating: 0, count: nums.count)
        var current: Int = 0
        var maximum: Int = (1 << maximumBit) - 1
        for (i, num) in nums.enumerated() {
            current ^= num
            let k = maximum ^ current
            answer[nums.count - 1 - i] = k
        }
        return answer
    }
}
