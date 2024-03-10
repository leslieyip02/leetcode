package main

import "fmt"

func intersection(nums1 []int, nums2 []int) []int {
    m := make(map[int]bool)
    for _, num := range nums1 {
        m[num] = true
    }

    s := make([]int, 0)
    for _, num := range nums2 {
        a, b := m[num]
        if a && b {
            s = append(s, num)
            m[num] = false
        }
    }
    return s
}

func main() {
    nums1 := []int{4, 9, 5}
    nums2 := []int{9, 4, 9, 8, 4}
    fmt.Println(intersection(nums1, nums2))
}
