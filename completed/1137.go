package main

import "fmt"

func tribonacci(n int) int {
    if n == 0 {
        return 0
    } else if n <= 2 {
        return 1
    }

    a, b, c := 0, 1, 1
    n -= 2
    for n > 0 {
        p := b
        q := c

        c += a + b
        a += b
        a = p
        b = q
        n--
    }
    return c
}

func main() {
    n := 25
    fmt.Println(tribonacci(n))
}
