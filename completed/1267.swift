class Solution {
    func countServers(_ grid: [[Int]]) -> Int {
        let m = grid.count
        let n = grid[0].count
        let rowSums = grid.map { row in row.reduce(0, +) }
        let colSums = (0 ..< n).map { index in
            grid.map { row in row[index] }.reduce(0, +)
        }

        var count = 0
        for i in 0 ..< m {
            for j in 0 ..< n {
                if grid[i][j] == 0 {
                    continue
                }
                if rowSums[i] > 1 || colSums[j] > 1 {
                    count += 1
                }
            }
        }
        return count
    }
}

