package main

import "fmt"

func singleNumber(nums []int) int {
    n := 0
    for _, num := range nums {
        n ^= num
    }
    return n
}

func main() {
    nums := []int{ 2, 2, 1 }
    fmt.Println(singleNumber(nums))
}
