class Solution {
    func dfs(_ current: Int, _ target: Int, _ parents: [[Int]], _ memo: inout [[Int]]) -> Bool {
        if memo[current][target] == -1 {
            memo[current][target] = (current == target || parents[current].contains(where: {
                dfs($0, target, parents, &memo)
            })) ? 1 : 0
        }
        return memo[current][target] == 1
    }

    func checkIfPrerequisite(_ numCourses: Int, _ prerequisites: [[Int]], _ queries: [[Int]]) -> [Bool] {
        var parents: [[Int]] = Array(repeating: [], count: numCourses)
        prerequisites.forEach { parents[$0[0]].append($0[1]) }

        var memo: [[Int]] = Array(repeating: Array(repeating: -1, count: numCourses), count: numCourses)
        return queries.map{ dfs($0[0], $0[1], parents, &memo) }
    }
}
