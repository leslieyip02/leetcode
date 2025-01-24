class Solution {
    func dfs(_ current: Int, _ graph: [[Int]], _ visited: inout [Bool], _ safe: inout [Bool]) -> Bool {
        if !visited[current] {
            visited[current] = true
            safe[current] = graph[current].allSatisfy { dfs($0, graph, &visited, &safe) }
        }
        return safe[current];
    }

    func eventualSafeNodes(_ graph: [[Int]]) -> [Int] {
        let n = graph.count
        var visited = Array(repeating: false, count: n)
        var safe = Array(repeating: false, count: n)
        for i in 0 ..< n {
            if graph[i].isEmpty {
                visited[i] = true
                safe[i] = true
            }
        }
        for i in 0 ..< n {
            safe[i] = dfs(i, graph, &visited, &safe);
        }
        return (0 ..< n).filter { safe[$0] }
    }
}
