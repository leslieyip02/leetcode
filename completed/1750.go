package main

import "fmt"

func minimumLength(s string) int {
    left := 0
    right := len(s) - 1
    current := len(s)
    for left < right {
        c := s[left]
        x := 1
        for left + x < right && s[left + x] == c {
            x++
        }
        ok := false
        y := 0
        for s[right - y] == c {
            ok = true
            if right - y < left + x {
                break
            }
            y++
        }
        if !ok {
            break
        }
        current -= x + y
        left += x
        right -= y
    }
    return current
}

func main() {
    s := "ca"
    fmt.Println(minimumLength(s))
}
