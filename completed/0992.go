package main

import "fmt"

func subarraysWithAtMostKDistinct(nums []int, k int) int {
    counts := make(map[int]int)
    left := 0
    right := 0
    result := 0
    for right < len(nums) {
        counts[nums[right]]++
        for len(counts) > k {
            counts[nums[left]]--
            if counts[nums[left]] == 0 {
                delete(counts, nums[left])
            }
            left++
        }
        result += right - left + 1
        right++
    }
    return result
}

func subarraysWithKDistinct(nums []int, k int) int {
    return subarraysWithAtMostKDistinct(nums, k) - subarraysWithAtMostKDistinct(nums, k - 1)
}

func main() {
    nums := []int{1,2,1,2,3}
    k := 2
    fmt.Println(subarraysWithKDistinct(nums, k))
}
