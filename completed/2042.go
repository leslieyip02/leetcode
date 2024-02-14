package main

import (
    "fmt"
    "strings"
)

func isNumber(word string) bool {
    for _, r := range word {
        v := int(r - '0')
        if v < 0 || v > 9 {
            return false
        }
    }
    return true
}

func toNumber(word string) int {
    v := 0
    for _, r := range word {
        v *= 10
        v += int(r - '0')
    }
    return v
}

func areNumbersAscending(s string) bool {
    words := strings.Fields(s)
    current := -1
    for i := range words {
        if isNumber(words[i]) {
            v := toNumber(words[i])
            if v <= current {
                return false
            } else {
                current = v
            }
        }
    }
    return true
}

func main() {
    // s := "1 box has 3 blue 4 red 6 green and 12 yellow marbles"
    s := "sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"
    fmt.Println(areNumbersAscending(s))
}
