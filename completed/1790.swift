class Solution {
    func areAlmostEqual(_ s1: String, _ s2: String) -> Bool {
        var diff: [Character] = []
        var swapped = false
        for (c1, c2) in zip(s1, s2) {
            if c1 != c2 {
                if swapped {
                    return false
                }

                if diff.isEmpty {
                    diff = [c1, c2]
                } else {
                    if diff[0] != c2 || diff[1] != c1 {
                        return false
                    }

                    diff = []
                    swapped = true
                }
            }
        }
        return diff.isEmpty
    }
}
