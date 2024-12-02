class Solution {
    func isPrefixOfWord(_ sentence: String, _ searchWord: String) -> Int {
        for (i, word) in sentence.components(separatedBy: " ").enumerated() {
            if word.hasPrefix(searchWord) {
                return i + 1;
            }
        }
        return -1;
    }
}
