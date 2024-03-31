package main

import "fmt"

func countSubarrays(nums []int, minK int, maxK int) int64 {
    left := 0
    right := 0
    localMinIndex := 0
    localMaxIndex := 0
    result := int64(0)
    for right < len(nums) {
        if nums[right] <= nums[localMinIndex] {
            localMinIndex = right
        }
        if nums[right] >= nums[localMaxIndex] {
            localMaxIndex = right
        }

        if nums[localMinIndex] == minK && nums[localMaxIndex] == maxK {
            leftmost := localMinIndex
            if localMaxIndex < localMinIndex {
                leftmost = localMaxIndex
            }
            result += int64(leftmost - left + 1)
        }

        if nums[right] < minK || nums[right] > maxK {
            left = right + 1
            localMinIndex = left
            localMaxIndex = left
        }
        right++
    }
    return result
}

func main() {
    nums := []int{1,3,5,2,7,5}
    minK := 1
    maxK := 5
    fmt.Println(countSubarrays(nums, minK, maxK))
}
