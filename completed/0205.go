package main

import "fmt"

func isIsomorphic(s string, t string) bool {
    x := make(map[byte]byte)
    y := make(map[byte]byte)
    for i := 0; i < len(s); i++ {
        _, p := x[s[i]]
        _, q := y[t[i]]
        if p && t[i] != x[s[i]] {
            return false
        } else if q && s[i] != y[t[i]] {
            return false
        }
        x[s[i]] = t[i]
        y[t[i]] = s[i]
    }
    return true
}

func main() {
    s := "paper"
    t := "title"
    fmt.Println(isIsomorphic(s, t))
}
