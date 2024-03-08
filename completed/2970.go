package main

import "fmt"

func incremovableSubarrayCount(nums []int) int {
    x := 0
    n := len(nums)
    for i := 0; i < n; i++ {
        for j := 0; j < n - i; j++ {
            p := -1
            ok := true
            for k := 0; k < n; k++ {
                if k >= i && k <= i + j {
                    continue
                }

                if nums[k] <= p {
                    ok = false
                    break
                }
                p = nums[k]
            }
            if ok {
                x++
            }
        }
    }
    return x
}

func main() {
    nums := []int{6, 5, 7, 8}
    fmt.Println(incremovableSubarrayCount(nums))
}
