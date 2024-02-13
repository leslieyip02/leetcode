package main

import "fmt"

func isPalindrome(word string) bool {
    left := 0
    right := len(word) - 1
    for left < right {
        if word[left] != word[right] {
            return false
        }
        left++
        right--
    }
    return true
}

func firstPalindrome(words []string) string {
    for i := range words {
        if isPalindrome(words[i]) {
            return words[i]
        }
    }
    return ""
}

func main() {
    words := []string{"abc","car","ada","racecar","cool"}
    fmt.Println(firstPalindrome(words))
}
