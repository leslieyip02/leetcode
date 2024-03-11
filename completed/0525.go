package main

import "fmt"

func findMaxLength(nums []int) int {
    n := len(nums)
    prefix := make([]int, n + 1)
    lefts := make(map[int]int)
    lefts[0] = 0
    max := 0
    for i := 0; i < n; i++ {
        prefix[i + 1] = prefix[i]
        if nums[i] == 0 {
            prefix[i + 1]--
        } else {
            prefix[i + 1]++
        }

        left, exists := lefts[prefix[i + 1]]
        if exists {
            diff := i - left + 1
            if diff > max {
                max = diff
            }
        } else {
            lefts[prefix[i + 1]] = i + 1
        }
    }
    return max
}

func main() {
    nums := []int{0, 1, 0}
    fmt.Println(findMaxLength(nums))
}
