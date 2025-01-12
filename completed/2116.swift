class Solution {
    func canBeValid(_ s: String, _ locked: String) -> Bool {
        if s.count % 2 != 0 {
            return false
        }

        var lockedOpen: [Int] = []
        var unlocked: [Int] = []
        let isLocked = Array(locked).map { $0 == "1" }
        for (offset, character) in s.enumerated() {
            if character == "(" {
                if isLocked[offset] {
                    lockedOpen.append(offset)
                } else {
                    unlocked.append(offset)
                }
            } else {
                if isLocked[offset] {
                    if !lockedOpen.isEmpty {
                        lockedOpen.removeLast()
                    } else if !unlocked.isEmpty {
                        unlocked.removeLast()
                    } else {
                        return false
                    }
                } else {
                    unlocked.append(offset)
                }
            }
        }

        var i = lockedOpen.count - 1
        var j = unlocked.count - 1
        while i >= 0 {
            if j < 0 {
                return false
            }

            if lockedOpen[i] > unlocked[j] {
                return false
            }

            i -= 1
            j -= 1
        }
        return true
    }
}
