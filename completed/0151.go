package main

import (
    "fmt"
    "strings"
)

func reverseWords(s string) string {
    words := strings.Fields(s)
    length := len(words)
    reversed := make([]string, length)
    for i, word := range words {
        reversed[length - 1 - i] = word
    }
    return strings.Join(reversed, " ")
}

func main() {
    s := "the sky is blue"
    fmt.Println(reverseWords(s))
}
