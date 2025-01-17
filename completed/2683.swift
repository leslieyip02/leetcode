class Solution {
    func trace(_ i: Int, _ original: inout [Int], _ derived: [Int]) -> Bool {
        if i == derived.count - 1 {
            return original[i] ^ original[0] == derived[i]
        }

        if original[i] ^ original[i + 1] == derived[i] {
            if trace(i + 1, &original, derived) {
                return true
            }
        }

        original[i + 1] = 1
        if original[i] ^ original[i + 1] == derived[i] {
            if trace(i + 1, &original, derived) {
                return true
            }
        }

        return false
    }

    func doesValidArrayExist(_ derived: [Int]) -> Bool {
        var original = Array(repeating: 0, count: derived.count)
        return trace(0, &original, derived)
    }
}
