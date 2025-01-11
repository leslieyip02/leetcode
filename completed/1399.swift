class Solution {
    func countLargestGroup(_ n: Int) -> Int {
        var groupSizes: [Int: Int] = [:]
        for i in 1 ... n {
            var sum = 0
            var num = i
            while num > 0 {
                sum += num % 10
                num /= 10
            }
            groupSizes[sum, default: 0] += 1
        }

        var maxSize = groupSizes.values.reduce(0, { x, y in
            max(x, y)
        })
        var count = 0
        return groupSizes.values.reduce(0, { x, y in
            x + (y == maxSize ? 1 : 0)
        })
    }
}
