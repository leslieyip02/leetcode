package main

import (
    "fmt"
    "strings"
)

func lengthOfLastWord(s string) int {
    words := strings.Fields(s)
    return len(words[len(words) - 1])
}

func main() {
    s := "Hello World"
    fmt.Println(lengthOfLastWord(s))
}
