class Solution {
    func maximumSum(_ nums: [Int]) -> Int {
        var top: [Int: (Int, Int)] = [:]
        for num in nums {
            var digitSum = 0
            var copy = num
            while copy > 0 {
                digitSum += copy % 10
                copy /= 10
            }

            if top[digitSum] == nil {
                top[digitSum] = (0, 0)
            }
            let (a, b) = top[digitSum]!
            if num > a {
                top[digitSum] = (num, a)
            } else if num > b {
                top[digitSum] = (a, num)
            }
        }

        var maximum = -1
        for (_, (a, b)) in top {
            if a == 0 || b == 0 {
                continue
            }
            maximum = max(a + b, maximum)
        }
        return maximum
    }
}

