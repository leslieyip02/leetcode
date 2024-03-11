package main

import (
    "fmt"
    "sort"
    "unicode"
)

func lettersOf(word string) map[rune]int {
    f := make(map[rune]int)
    for _, c := range word {
        if unicode.IsLetter(c) {
            f[unicode.ToUpper(c)]++
        }
    }
    return f
}

func shortestCompletingWord(licensePlate string, words []string) string {
    sort.SliceStable(words, func(i int, j int) bool {
        return len(words[i]) < len(words[j])
    })

    target := lettersOf(licensePlate)
    for _, word := range words {
        current := lettersOf(word)
        ok := true
        for letter, target_count := range target {
            count, present := current[letter]
            if !present || count < target_count {
                ok = false
                break
            }
        }
        if ok {
            return word
        }
    }
    return ""
}

func main() {
    licensePlate := "1s3 456"
    words := []string{"looks","pest","stew","show"}
    fmt.Println(shortestCompletingWord(licensePlate, words))
}
