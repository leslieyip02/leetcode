import Collections

class Solution {
    func addSpaces(_ s: String, _ spaces: [Int]) -> String {
        var indices = Set<Int>()
        for index in spaces {
            indices.insert(index)
        }
        var modified: [Character] = []
        for (i, c) in s.enumerated() {
            if indices.contains(i) {
                modified.append(" ")
            }
            modified.append(c)
        }
        return String(modified)
    }
}
