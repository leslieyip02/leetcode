class Solution {
    let inf = 1000 * 1000
    let directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

    func highestPeak(_ isWater: [[Int]]) -> [[Int]] {
        var heights: [[Int]] = isWater.map { row in
            row.map { col in col == 1 ? 0 : inf }
        }
        var queue: Deque<(Int, Int)> = []
        for r0 in 0 ..< isWater.count {
            for c0 in 0 ..< isWater[r0].count {
                if isWater[r0][c0] != 1 {
                    continue
                }
                queue.append((r0, c0))
            }
        }
        while let (r0, c0) = queue.popFirst() {
            for direction in directions {
                let r1 = r0 + direction.0
                let c1 = c0 + direction.1
                if r1 < 0 || r1 >= heights.count || c1 < 0 || c1 >= heights[r0].count {
                    continue
                }

                if heights[r1][c1] <= heights[r0][c0] + 1 {
                    continue
                }

                heights[r1][c1] = heights[r0][c0] + 1
                queue.append((r1, c1))
            }
        }
        return heights
    }
}

