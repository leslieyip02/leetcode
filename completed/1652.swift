class Solution {
    func decrypt(_ code: [Int], _ k: Int) -> [Int] {
        let n = code.count

        var decrypted = Array(repeating: 0, count: n)
        if k == 0 {
            return decrypted
        }

        var left = k > 0 ? 1 : n + k
        var right = k > 0 ? k : n - 1
        for i in left ... right {
            decrypted[0] += code[i]
        }
        for i in 1 ..< n {
            decrypted[i] = decrypted[i - 1]
            decrypted[i] -= code[left]
            left = (left + 1) % n
            right = (right + 1) % n
            decrypted[i] += code[right]
        }
        return decrypted
    }
}
