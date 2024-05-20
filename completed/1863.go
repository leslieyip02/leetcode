package main

import "fmt"

func choose(nums []int, index int, current int) int {
    if index == len(nums) {
        i := 0
        v := 0
        for current > 0 {
            if current & 1 == 1 {
                v ^= nums[i]
            }
            current >>= 1
            i++
        }
        return v
    }

    // don't choose
    x := choose(nums, index + 1, current)

    // choose
    current |= 1 << index
    y := choose(nums, index + 1, current)

    return x + y
}

func subsetXORSum(nums []int) int {
    return choose(nums, 0, 0)
}

func main() {
    nums := []int{2,4,4}
    fmt.Println(subsetXORSum(nums))
}
