class Solution {
    func canDistribute(_ x: Int, _ n: Int, _ quantities: [Int]) -> Bool {
        var remaining = n
        for quantity in quantities {
            remaining -= Int(ceil(Float(quantity) / Float(x)))
            if remaining < 0 {
                return false
            }
        }
        return true
    }

    func minimizedMaximum(_ n: Int, _ quantities: [Int]) -> Int {
        var low = 1
        var high = Int(1e5)
        while low < high {
            var mid = (low + high) / 2
            if !canDistribute(mid, n, quantities) {
                low = mid + 1
            } else {
                high = mid
            }
        }
        return low
    }
}
