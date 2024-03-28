package main

import "fmt"

func maxSubarrayLength(nums []int, k int) int {
    counts := make(map[int]int)
    left := 0
    right := 0
    max := 0
    for right < len(nums) {
        _, ok := counts[nums[right]]
        if ok {
            for counts[nums[right]] == k {
                counts[nums[left]]--
                left++
            }
        }
        counts[nums[right]]++
        current := right - left + 1
        if current > max {
            max = current;
        }
        right++
    }
    return max
}

func main() {
    nums := []int{3,1,1}
    k := 1
    fmt.Println(maxSubarrayLength(nums, k))
}
