package main

import "fmt"

func rearrangeArray(nums []int) []int {
    n := len(nums)
    pos := make([]int, n / 2)
    neg := make([]int, n / 2)

    p, q := 0, 0
    for i := range nums {
        if nums[i] > 0 {
            pos[p] = nums[i]
            p++
        } else {
            neg[q] = nums[i]
            q++
        }
    }

    for i := 0; i < n / 2; i++ {
        nums[i * 2] = pos[i]
        nums[i * 2 + 1] = neg[i]
    }
    return nums
}

func main() {
    nums := []int{3,1,-2,-5,2,-4}
    fmt.Println(rearrangeArray(nums))
}
