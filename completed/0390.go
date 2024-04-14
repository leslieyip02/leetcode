package main

import "fmt"

func lastRemaining(n int) int {
    head := 1
    step := 1
    left := true
    for n > 1 {
        if left || n % 2 == 1 {
            head += step
        }
        n /= 2
        step *= 2
        left = !left
    }
    return head
}

func main() {
    n := 9
    fmt.Println(lastRemaining(n))
}
