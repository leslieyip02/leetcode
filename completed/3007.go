package main

import "fmt"

func price(num int64, x int) int64 {
    if num == 1 {
        if x == 1 {
            return 1
        } else {
            return 0
        }
    }

    b := 0
    c := num
    for c != 0 {
        c >>= 1
        b++
    }

    sum := int64(0)
    y := x - 1
    for y < b {
        size := int64(1 << (y + 1))
        ones := size >> 1

        chunks := (num + 1) / size
        sum += chunks * ones

        remainder := (num + 1) % size
        if remainder > ones {
            sum += remainder - ones
        }

        y += x
    }

    return sum
}

func findMaximumNumber(k int64, x int) int64 {
    lo := int64(0)
    hi := int64(1 << 53 - 1)
    mid := lo + (hi - lo) / 2
    for lo < hi {
        if price(mid, x) <= k {
            lo = mid + 1
        } else {
            hi = mid
        }
        mid = lo + (hi - lo) / 2
    }
    if price(mid, x) > k {
        mid--
    }
    return mid
}

func main() {
    k := int64(3278539330613)
    x := 5
    fmt.Println(findMaximumNumber(k, x))
}
