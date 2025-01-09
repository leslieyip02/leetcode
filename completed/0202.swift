class Solution {
    var seen = Set<Int>()

    func isHappy(_ n: Int) -> Bool {
        if n == 1 {
            return true
        }

        if seen.contains(n) {
            return false
        }
        seen.insert(n)

        var sum = 0
        var current = n
        while current > 0 {
            let digit = current % 10
            sum += digit * digit
            current /= 10
        }
        return isHappy(sum)
    }
}
