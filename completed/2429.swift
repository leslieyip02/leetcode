class Solution {
    func minimizeXor(_ num1: Int, _ num2: Int) -> Int {
        var bits = Array(repeating: false, count: 32)
        var shift = 0
        var num1 = num1
        while num1 > 0 {
            bits[shift] = (num1 & 1) == 1 
            shift += 1
            num1 >>= 1
        }

        var setBits = 0
        var num2 = num2
        while num2 > 0 {
            if (num2 & 1) == 1 {
                setBits += 1
            }
            num2 >>= 1
        }

        var minimized = 0
        for i in bits.indices.reversed() {
            if bits[i] && setBits > 0 {
                minimized |= (1 << i)
                setBits -= 1
            }
        }
        for i in bits.indices {
            if setBits == 0 {
                break
            }

            if (minimized & (1 << i)) == 0 {
                minimized |= (1 << i)
                setBits -= 1
            }
        }
        return minimized
    }
}

