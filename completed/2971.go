package main

import (
    "fmt"
    "sort"
)

func largestPerimeter(nums []int) int64 {
    sort.Slice(nums, func(i int, j int) bool {
        return nums[i] < nums[j]
    })

    largest := int64(-1)
    current := int64(nums[0] + nums[1])
    for i := 2; i < len(nums); i++ {
        ok := current > int64(nums[i])
        current += int64(nums[i])
        if ok {
            largest = current
        }
    }
    return largest
}

func main() {
    nums := []int{1,12,1,2,5,50,3}
    fmt.Println(largestPerimeter(nums))
}
