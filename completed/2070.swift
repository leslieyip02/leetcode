struct Item {
    var price = 0
    var beauty = 0
}

class Solution {
    func maximumBeauty(_ items: [[Int]], _ queries: [Int]) -> [Int] {
        let sorted = items
            .sorted { $0[0] < $1[0] }
            .map { Item(price: $0[0], beauty: $0[1]) }

        var maximums = Array(repeating: 0, count: sorted.count)
        maximums[0] = sorted[0].beauty
        for i in 1 ..< sorted.count {
            maximums[i] = max(sorted[i].beauty, maximums[i - 1])
        }

        var answer = Array(repeating: 0, count: queries.count)
        for (i, query) in queries.enumerated() {
            if query < sorted[0].price {
                continue
            }
            if query >= sorted[sorted.count - 1].price {
                answer[i] = maximums[sorted.count - 1]
                continue
            }

            var low = 0
            var high = sorted.count
            while low < high {
                var mid = (low + high) / 2
                if sorted[mid].price <= query {
                    answer[i] = max(maximums[mid], answer[i])
                    low = mid + 1
                } else {
                    high = mid
                }
            }
        }
        return answer
    }
}
