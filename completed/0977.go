package main

import (
    "fmt"
    "sort"
)

func sortedSquares(nums []int) []int {
    s := make([]int, len(nums))
    for i := range nums {
        s[i] = nums[i] * nums[i]
    }
    sort.Ints(s)
    return s
}

func main() {
    nums := []int{-4, -1, 0, 3, 10}
    fmt.Println(sortedSquares(nums))
}
