class Solution {
    func maximum69Number (_ num: Int) -> Int {
        var digits = Array(String(num))
        for (i, digit) in digits.enumerated() {
            if digit == "6" {
                digits[i] = "9"
                break
            }
        }
        return Int(String(digits)) ?? -1
    }
}
