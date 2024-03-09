package main

import "fmt"

func getCommon(nums1 []int, nums2 []int) int {
    m := make(map[int]bool)
    for _, num := range nums1 {
        m[num] = true
    }

    c := -1
    for i, num := range nums2 {
        _, ok := m[num]
        if ok {
            if c == -1 || num < nums2[c] {
                c = i
            }
        }
    }
    if c == -1 {
        return -1
    } else {
        return nums2[c]
    }
}

func main() {
    nums1 := []int{1, 2, 3, 6}
    nums2 := []int{2, 3, 4, 5}
    fmt.Println(getCommon(nums1, nums2))
}
