class Solution {
    let directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

    func visit(_ r: Int, _ c: Int, _ grid: [[Int]], _ visited: inout [[Bool]]) -> Int {
        if r < 0 || r >= grid.count || c < 0 || c >= grid[r].count {
            return 0
        }
        if visited[r][c] || grid[r][c] == 0 {
            return 0
        }
        visited[r][c] = true
        return grid[r][c] + directions
            .map { (dr, dc) in visit(r + dr, c + dc, grid, &visited) }
            .reduce(0, +)
    }

    func findMaxFish(_ grid: [[Int]]) -> Int {
        let m = grid.count
        let n = grid[0].count
        var visited = Array(repeating: Array(repeating: false, count: n), count: m)
        return (0 ..< m)
            .flatMap { r in (0 ..< n).map { c in visit(r, c, grid, &visited) } }
            .reduce(0, max)
    }
}
