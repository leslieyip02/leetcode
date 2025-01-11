class Solution {
   func canConstruct(_ s: String, _ k: Int) -> Bool {
        if k > s.count {
            return false
        }

        var state = 0
        for letter in s {
            let index = Int(letter.asciiValue!) - 97
            state ^= (1 << index)
        }

        var on = 0
        while state > 0 {
            if state & 1 == 1 {
                on += 1
            }
            state >>= 1
        }
        return on <= k
   }
}
