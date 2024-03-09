package main

import "fmt"

func encode(word string) int {
    mask := 0
    for _, c := range word {
        mask |= 1 << (c - 97)
    }
    return mask
}

func similarPairs(words []string) int {
    masks := make(map[int]int)
    for _, word := range words {
        mask := encode(word)
        masks[mask]++
    }

    p := 0
    for _, c := range masks {
        p += c * (c - 1) / 2
    }
    return p
}

func main() {
    words := []string{"aba","aabb","abcd","bac","aabc"}
    fmt.Println(similarPairs(words))
}
