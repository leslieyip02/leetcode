package main

import "fmt"

func numSubarrayProductLessThanK(nums []int, k int) int {
    current := 1
    left := 0
    right := 0
    count := 0
    for right < len(nums) {
        current *= nums[right]
        for left <= right && current >= k {
            current /= nums[left]
            left++
        }

        count += right - left + 1
        right++
    }
    return count
}

func main() {
    nums := []int{10,5,2,6}
    k := 100
    fmt.Println(numSubarrayProductLessThanK(nums, k))
}
