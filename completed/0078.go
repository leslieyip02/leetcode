package main

import "fmt"

func subsets(nums []int) [][]int {
    n := 1 << len(nums)
    results := make([][]int, n)
    for i := 0; i < n; i++ {
        subset := make([]int, 0)
        k := 0
        for j := i; j > 0; j >>= 1 {
            if j & 1 == 1 {
                subset = append(subset, nums[k])
            }
            k++
        }
        results[i] = subset
    }
    return results
}

func main() {
    nums := []int{1, 2, 3}
    fmt.Println(subsets(nums))
}
