class Solution {
    func prefixCount(_ words: [String], _ pref: String) -> Int {
        return words.reduce(0, { x, y in x + (y.hasPrefix(pref) ? 1 : 0) })
    }
}
