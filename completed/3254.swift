class Solution {
    func resultsArray(_ nums: [Int], _ k: Int) -> [Int] {
        var i = 0
        var results = Array(repeating: -1, count: nums.count - k + 1)
        while i < results.count {
            var increasing = true
            for j in 1 ..< k {
                if nums[i + j] != nums[i + j - 1] + 1 {
                    increasing = false
                    i += j - 1
                    break
                }
            }
            if increasing {
                results[i] = nums[i + k - 1]
            }
            i += 1
        }
        return results
    }
}
