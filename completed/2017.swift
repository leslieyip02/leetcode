class Solution {
    func gridGame(_ grid: [[Int]]) -> Int {
        let prefixSums = grid.map { row in
            var current = 0
            return row.map { col in
               current += col
               return current
            }
        }

        var minimum = prefixSums[0].last! + prefixSums[1].last!
        for i in 0 ..< grid[0].count {
            let top = prefixSums[0].last! - prefixSums[0][i]
            let bottom = i > 0 ? prefixSums[1][i - 1] : 0
            minimum = min(max(top, bottom), minimum)
        }
        return minimum
    }
}
