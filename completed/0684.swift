import Collections

class Solution {
    func isConnected(_ edges: [[Int]], _ skip: Int) -> Bool {
        let n = edges.count
        var adjacencies: [[Int]] = Array(repeating: [], count: n)
        for i in 0 ..< n {
            if i == skip {
                continue
            }
            let a = edges[i][0] - 1
            let b = edges[i][1] - 1
            adjacencies[a].append(b)
            adjacencies[b].append(a)
        }

        var nodes: Deque<Int> = []
        nodes.append(0)
        var visited = Array(repeating: false, count: n)     
        visited[0] = true;
        while !nodes.isEmpty {
            let current = nodes.popFirst()!
            for adjacent in adjacencies[current] {
                if visited[adjacent] {
                    continue
                }
                nodes.append(adjacent)
                visited[adjacent] = true
            }
        }
        return visited.allSatisfy { $0 }
    }

    func findRedundantConnection(_ edges: [[Int]]) -> [Int] {
        let n = edges.count
        for i in (0 ..< n).reversed() {
            if isConnected(edges, i) {
                return edges[i]
            }
        }
        return []
    }
}
