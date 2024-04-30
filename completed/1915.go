package main

import "fmt"

func wonderfulSubstrings(word string) int64 {
    frequencies := make(map[int]int64)
    frequencies[0] = 1

    current := 0
    count := int64(0)
    for _, c := range word {
        a := c - 97
        b := 1 << a
        current ^= b

        // check if the current mask exists
        // if so, then previous masks would cancel out the current mask
        // => number of odd characters = 0
        frequency, ok := frequencies[current]
        if ok {
            count += frequency
        }
        frequencies[current]++

        // check if its possible to flip any 1 character
        for i := 0; i < 10; i++ {
            frequency, ok := frequencies[current ^ (1 << i)]
            if ok {
                count += frequency
            }
        }
    }
    return count
}

func main() {
    word := "aba"
    fmt.Println(wonderfulSubstrings(word))
}
