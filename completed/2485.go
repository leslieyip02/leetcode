package main

import "fmt"

func pivotInteger(n int) int {
    total := n * (n + 1) / 2

    lo := 1
    hi := n + 1
    for lo < hi {
        mid := (lo + hi) / 2
        prefix := mid * (mid + 1) / 2
        suffix := total - prefix + mid

        if prefix == suffix {
            return mid
        } else if prefix < suffix {
            lo = mid + 1
        } else {
            hi = mid
        }
    }
    return -1
}

func main() {
    n := 8
    fmt.Println(pivotInteger(n))
}
