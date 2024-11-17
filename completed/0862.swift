import Collections

class Solution {
    func shortestSubarray(_ nums: [Int], _ k: Int) -> Int {
        var prefixSums = Array(repeating: 0, count: nums.count + 1)
        for i in 1 ... nums.count {
            prefixSums[i] = nums[i - 1] + prefixSums[i - 1]
        }

        var shortest = prefixSums.count + 1
        var indices: Deque<Int> = []
        for i in 0 ... nums.count {
            while !indices.isEmpty && prefixSums[i] - prefixSums[indices.first!] >= k {
                var start = indices.popFirst()!
                shortest = min(i - start, shortest)
            }

            while !indices.isEmpty && prefixSums[indices.last!] >= prefixSums[i] {
                indices.popLast()
            }

            indices.append(i)
        }
        return shortest == prefixSums.count + 1 ? -1 : shortest
    }
}
