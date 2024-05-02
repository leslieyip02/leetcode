package main

import "fmt"

func findMaxK(nums []int) int {
    t := make(map[int]bool)
    m := -1
    for _, n := range nums {
        _, ok := t[-n]
        if ok {
            if n > m {
                m = n
            } else if -n > m {
                m = -n
            }
        }
        t[n] = true
    }
    return m
}

func main() {
    nums := []int{-1,2,-3,3}
    fmt.Println(findMaxK(nums))
}
