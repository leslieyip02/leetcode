class Solution {
    func findPairs(_ num: Int, _ nums: [Int], _ lower: Int, _ upper: Int) -> Int {
        var low = 0
        var high = nums.count
        while low < high {
            let mid = (low + high) / 2
            if num + nums[mid] < lower {
                low = mid + 1
            } else {
                high = mid
            }
        }
        let lowerBound = low

        low = 0
        high = nums.count
        while low < high {
            let mid = (low + high) / 2
            if num + nums[mid] <= upper {
                low = mid + 1
            } else {
                high = mid
            }
        }
        let upperBound = high

        var count = upperBound - lowerBound
        if num + num >= lower && num + num <= upper {
            count -= 1
        }
        return count
    }

    func countFairPairs(_ nums: [Int], _ lower: Int, _ upper: Int) -> Int {
        let nums = nums.sorted()
        let count = nums
            .map { findPairs($0, nums, lower, upper) }
            .reduce(0, { $0 + $1 })
        return count / 2
    }
}
