package main

import "fmt"

func countSubstrings(s string) int {
    n := len(s)
    c := n;
    for i0 := range s {
        // check odd
        for j := 1; i0 - j >= 0 && i0 + j < n; j++ {
            if s[i0 - j] == s[i0 + j] {
                c++
            } else {
                break
            }
        }

        // check even
        i1 := i0 + 1
        for j := 0; i0 - j >= 0 && i1 + j < n; j++ {
            if s[i0 - j] == s[i1 + j] {
                c++
            } else {
                break
            }
        }
    }
    return c
}

func main() {
    const s = "aaa"
    fmt.Println(countSubstrings(s))
}
