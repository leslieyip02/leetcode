package main

import "fmt"

func majorityElement(nums []int) int {
    m := make(map[int]int)
    for i := range nums {
        n := nums[i]
        _, p := m[n]
        if !p {
            m[n] = 0
        }
        m[n]++
    }
    majority := nums[0]
    for k, v := range m {
        if v > m[majority] {
            majority = k
        }
    }
    return majority
}

func main() {
    nums := []int{2,2,1,1,1,2,2}
    fmt.Println(majorityElement(nums))
}
