class Solution {
    func wordToLetterCounts(_ word: String) -> [Int] {
        var counts = Array(repeating: 0, count: 26)
        for letter in word {
            counts[Int(letter.asciiValue!) - 97] += 1
        }
        return counts
    }

    func isSubset(_ counts1: [Int], _ counts2: [Int]) -> Bool {
        return zip(counts1, counts2)
            .allSatisfy({ (count1, count2) in count2 <= count1 })
    }

    func wordSubsets(_ words1: [String], _ words2: [String]) -> [String] {
        var universal = Array<String>()
        var counts2 = words2.map(wordToLetterCounts)
            .reduce(Array(repeating: 0, count: 26), { current, next in
                zip(current, next)
                    .map({ (currentCount, nextCount) in max(currentCount, nextCount) })
            })
        for word in words1 {
            let counts1 = wordToLetterCounts(word)
            if isSubset(counts1, counts2) {
                universal.append(word)
            }
        }
        return universal
    }
}
