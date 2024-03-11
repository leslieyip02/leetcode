package main

import (
    "fmt"
    "strconv"
    "math"
)

func monotoneIncreasingDigits(n int) int {
    if n < 10 {
        return n
    }

    s := strconv.Itoa(n)
    digits := make([]int, len(s))
    min := make([]int, len(s))
    for i, c := range s {
        digits[i] = (int) (c - '0')
        min[i] = digits[i]
    }

    index := -1
    for i := len(s) - 1; i > 0; i-- {
        if min[i] < min[i - 1] {
            min[i - 1]--
            if min[i - 1] < 0 {
                min[i - 1] = 0
            }
            index = i - 1
        }
    }

    if index != -1 {
        digits[index] = (int) (s[index] - '0' - 1)
        for i := index + 1; i < len(s); i++ {
            digits[i] = 9
        }
    }

    sum := 0
    for i := 0; i < len(s); i++ {
        sum += digits[i] * int(math.Pow(10.0, float64(len(s) - i - 1.0)))
    }
    return sum
}

func main() {
    n := 120 
    fmt.Println(monotoneIncreasingDigits(n))
}
