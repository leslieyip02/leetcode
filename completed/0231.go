func isPowerOfTwo(n int) bool {
    one := false
    for n > 0 {
        if n & 1 != 0 {
            if one {
                return false
            } else {
                one = true
            }
        }
        n >>=1
    }
    return one
}
