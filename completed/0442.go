package main

import "fmt"

func findDuplicates(nums []int) []int {
    d := make([]int, 0)
    for _, num := range nums {
        if num > 0 {
            if nums[num - 1] < 0 {
                d = append(d, num)
            } else {
                nums[num - 1] *= -1
            }
        } else {
            if nums[num * -1 - 1] < 0 {
                d = append(d, num * -1)
            } else {
                nums[num * -1 - 1] *= -1
            }
        }
    }
    return d
}

func main() {
    nums := []int{4,3,2,7,8,2,3,1}
    fmt.Println(findDuplicates(nums))
}
