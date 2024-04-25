package main

import "fmt"

func longestIdealString(s string, k int) int {
    n := len(s)
    dp := make([]int, n)
    for i := range s {
        dp[i] = 1
    }
    last := make([]int, 26)
    for i := 0; i < 26; i++ {
        last[i] = -1
    }

    m := 1
    for i := range s {
        c := int(s[i]) - 97
        for j := 0; j <= k; j++ {
            left := c - j
            if left >= 0 && last[left] != -1 {
                if dp[last[left]] >= dp[i] {
                    dp[i] = dp[last[left]] + 1
                    if dp[i] > m {
                        m = dp[i]
                    }
                }
            }

            right := c + j
            if right < 26 && last[right] != -1 {
                if dp[last[right]] >= dp[i] {
                    dp[i] = dp[last[right]] + 1
                    if dp[i] > m {
                        m = dp[i]
                    }
                }
            }
        }
        last[c] = i
    }
    return m
}

func main() {
    s := "acfgbd"
    k := 2
    fmt.Println(longestIdealString(s, k))
}
