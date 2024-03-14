package main

import "fmt"

func numSubarraysWithSum(nums []int, goal int) int {
    count := 0

    prefix := make([]int, len(nums))
    previous := make(map[int]int)
    previous[0] = 1
    for i := 0; i < len(nums); i++ {
        prefix[i] = nums[i]
        if i > 0 {
            prefix[i] += prefix[i - 1]
        }

        c, ok := previous[prefix[i] - goal]
        if ok {
            count += c
        }
        previous[prefix[i]]++
    }
    return count
}

func main() {
    nums := []int{1, 0, 1, 0, 1}
    goal := 2
    fmt.Println(numSubarraysWithSum(nums, goal))
}
