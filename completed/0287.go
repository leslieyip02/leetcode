package main

import "fmt"

func findDuplicate(nums []int) int {
    slow := nums[nums[0]]
    fast := nums[nums[nums[0]]]
    for slow != fast {
        slow = nums[slow]
        fast = nums[nums[fast]]
    }
    slow = nums[0]
    for slow != fast {
        slow = nums[slow]
        fast = nums[fast]
    }
    return slow
}

func main() {
    nums := []int{3,1,3,4,2}
    fmt.Println(findDuplicate(nums))
}
