package main

import "fmt"

func maxDepth(s string) int {
    c := 0
    m := 0
    for _, r := range s {
        if r == '(' {
            c++
            if c > m {
                m = c
            }
        } else if r == ')' {
            c--
        }
    }
    return m
}

func main() {
    s := "(1+(2*3)+((8)/4))+1"
    fmt.Println(maxDepth(s))
}
