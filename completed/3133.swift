class Solution {
    func minEnd(_ n: Int, _ x: Int) -> Int {
        var min = x
        var x = x
        var n = n - 1

        var shift = 0
        while n > 0 {
            if (x & 1) == 1 {
                min |= (1 << shift)
            } else {
                if (n & 1) == 1 {
                    min |= (1 << shift)
                }
                n >>= 1
            }
            x >>= 1
            shift += 1
        }
        return min
    }
}
