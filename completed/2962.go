package main

import "fmt"

func countSubarrays(nums []int, k int) int64 {
    n := len(nums)

    max := 0
    for _, num := range nums {
        if num > max {
            max = num
        }
    }

    counts := make([]int, n + 1)
    for i, num := range nums {
        counts[i + 1] = counts[i]
        if num == max {
            counts[i + 1]++
        }
    }

    left := 0
    right := 1
    count := int64(0)
    prefix := int64(0)
    for right < n + 1 {
        if counts[right] - counts[left] == k {
            suffix := int64(n - right)
            count += (prefix + 1) * (suffix + 1)

            i := 1
            for left + i < right && nums[left + i] != max {
                i++
            }
            prefix = int64(i - 1)
            left += i
        } else {
            right++
        }
    }
    return count
}

func main() {
    nums := []int{1,3,2,3,3}
    k := 2
    fmt.Println(countSubarrays(nums, k))
}
