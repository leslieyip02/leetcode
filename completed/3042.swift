class Solution {
    func isPrefixAndSuffix(_ str1: String, _ str2: String) -> Bool {
        return str2.hasPrefix(str1) && str2.hasSuffix(str1)
    }

    func countPrefixSuffixPairs(_ words: [String]) -> Int {
        words.sorted(by: { $0.count < $1.count })
        var count = 0
        for i in 0 ..< words.count {
            for j in i + 1 ..< words.count {
                if isPrefixAndSuffix(words[i], words[j]) {
                    count += 1
                }
            }
        }
        return count
    }
}
