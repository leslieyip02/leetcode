class Solution {
    func generateIsPrime(_ max: Int) -> [Bool] {
        var isPrime = Array(repeating: true, count: max + 1)
        isPrime[0] = false
        isPrime[1] = false

        var i = 2
        while i * i <= max {
            if !isPrime[i] {
                i += 1
                continue
            }

            var j = i * i
            while j <= max {
                isPrime[j] = false
                j += i
            }
            i += 1
        }
        return isPrime
    }

    func primeSubOperation(_ nums: [Int]) -> Bool {
        var isPrime = generateIsPrime(1000)

        var previous = 0
        for num in nums {
            var minimum = num - previous - 1

            var ok = false
            for j in stride(from: minimum, to: 0, by: -1) {
                if isPrime[j] {
                    previous = num - j
                    ok = true
                    break
                }
            }

            if !ok {
                if num <= previous {
                    return false
                }

                previous = num
            }
        }
        return true
    }
}
