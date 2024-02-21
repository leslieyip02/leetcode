package main

import "fmt"

func mostSignificantBit(n int) int {
    x := 0;
    for n > 0 {
        x++
        n >>= 1
    }
    return x;
}

func rangeBitwiseAnd(left int, right int) int {
    x := mostSignificantBit(left)
    y := mostSignificantBit(right)
    if x != 0 && x == y {
        c := (1 << x) - 1
        for i := left; i <= right; i++ {
            c &= i;
        }
        return c
    } else {
        return 0
    }
}

func main() {
    left := 5
    right := 7
    fmt.Println(rangeBitwiseAnd(left, right))
}
