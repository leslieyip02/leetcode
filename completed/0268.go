package main

import "fmt"

func missingNumber(nums []int) int {
    n := len(nums)
    target := n * (n + 1) / 2
    sum := 0
    for i := range nums {
        sum += nums[i]
    }
    return target - sum
}

func main() {
    nums := []int{3, 0, 1}
    fmt.Println(missingNumber(nums))
}
