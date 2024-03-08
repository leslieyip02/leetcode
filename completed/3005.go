package main

import "fmt"

func maxFrequencyElements(nums []int) int {
    f := make(map[int]int)
    m := 0
    for _, num := range nums {
        f[num]++
        if f[num] > m {
            m = f[num]
        }
    }
    n := 0
    for _, v := range f {
        if v == m {
            n += v
        }
    }
    return n
}

func main() {
    nums := []int{1, 2, 2, 3, 1, 4}
    fmt.Println(maxFrequencyElements(nums))
}
