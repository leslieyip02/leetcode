class Solution {
    func findNumbers(_ nums: [Int]) -> Int {
        var count = 0
        for num in nums {
            if String(num).count % 2 == 0 {
                count += 1
            }
        }
        return count
    }
}
