package main

import (
    "fmt"
    "sort"
)

func findLeastNumOfUniqueInts(arr []int, k int) int {
    f := make(map[int]int)
    for _, n := range arr {
        f[n]++
    }

    c := make([]int, len(f))
    i := 0
    for _, n := range f {
        c[i] = n
        i++
    }
    sort.Slice(c, func(i int, j int) bool {
        return c[i] < c[j]
    })

    u := len(c)
    for i = 0; i < len(c); i++ {
        k -= c[i]
        if k < 0 {
            break
        }
        u--;
    }
    return u
}

func main() {
    arr := []int{2,1,1,3,3,3}
    k := 3
    fmt.Println(findLeastNumOfUniqueInts(arr, k))
}
