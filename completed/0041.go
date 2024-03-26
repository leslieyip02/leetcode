package main

import "fmt"

func firstMissingPositive(nums []int) int {
    for _, num := range nums {
        if num > 0 {
            mark(nums, num)
        }
    }

    for i, num := range nums {
        if num != i + 1 {
            return i + 1
        }
    }
    return len(nums) + 1
}

func mark(nums []int, num int) {
    if num > 0 && num <= len(nums) {
        if num == nums[num - 1] {
            return
        }

        current := nums[num - 1]
        nums[num - 1] = num
        mark(nums, current)
    }
}

func main() {
    nums := []int{1,2,0}
    fmt.Println(firstMissingPositive(nums))
}
