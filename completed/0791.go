package main

import (
    "fmt"
    "sort"
)

func customSortString(order string, s string) string {
    weights := make([]int, 26)
    for i := range weights {
        weights[i] = 27
    }

    for i, c := range order {
        weights[c - 97] = i
    }

    runes := make([]rune, len(s))
    for i, c := range s {
        runes[i] = c
    }
    sort.Slice(runes, func(i int, j int) bool {
        return weights[runes[i] - 97] < weights[runes[j] - 97]
    })
    return string(runes)
}

func main() {
    order := "bcafg"
    s := "abcd"
    fmt.Println(customSortString(order, s))
}
