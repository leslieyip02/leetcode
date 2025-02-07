class Solution {
    func queryResults(_ limit: Int, _ queries: [[Int]]) -> [Int] {
        var colors: [Int: Int] = [:]
        var counts: [Int: Int] = [:]
        var distinct = 0
        return queries.map { query in
            let ball = query[0]
            let color = query[1]

            if let current = colors[ball] {
                counts[current]! -= 1
                if counts[current]! == 0 {
                    distinct -= 1
                }
            }

            colors[ball] = color
            if counts[color, default: 0] == 0 {
                counts[color] = 0
                distinct += 1
            }
            counts[color]! += 1
            return distinct
        }
    }
}
