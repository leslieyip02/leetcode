class Solution {
    func minimumLength(_ s: String) -> Int {
        var counts = Array(repeating: 0, count: 26)
        for character in s {
            let index = Int(character.asciiValue!) - 97
            counts[index] += 1
        }

        var length = 0
        for count in counts {
            length += min(count % 2 == 1 ? 1 : 2, count)
        }
        return length
    }
}
