class Solution {
    func canChoose(_ groups: [[Int]], _ nums: [Int]) -> Bool {
        let n = groups.count
        let upper = nums.count - groups.reduce(0) { x, y in x + y.count }

        var i = 0 
        var j = 0
        while i < nums.count {
            if nums[i] != groups[j].first! {
                i += 1
                continue
            }

            let k = i + groups[j].count
            if k > nums.count {
                return false
            }
            let same = zip(nums[i ..< k], groups[j]).allSatisfy { (a, b) in a == b }
            if same {
                i += groups[j].count
                j += 1
                if j == n {
                    return true
                }
            } else {
                i += 1
            }
        }
        return false
    }
}
