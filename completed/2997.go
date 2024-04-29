package main

import "fmt"

func minOperations(nums []int, k int) int {
    for _, num := range nums {
        k ^= num
    }
    n := 0
    for k > 0 {
        if k & 1 == 1 {
            n++;
        }
        k >>= 1
    }
    return n
}

func main() {
    nums := []int{ 2, 1, 3, 4 }
    k := 1
    fmt.Println(minOperations(nums, k))
}
