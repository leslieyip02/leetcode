package main

import "fmt"

func productExceptSelf(nums []int) []int {
    n := len(nums)
    prefix := make([]int, n)
    suffix := make([]int, n)
    prefix[0] = nums[0]
    suffix[n - 1] = nums[n - 1]
    for i := 1; i < n; i++ {
        prefix[i] = nums[i] * prefix[i - 1]
        suffix[n - i - 1] = nums[n - i - 1] * suffix[n - i]
    }

    products := make([]int, n)
    products[0] = suffix[1]
    products[n - 1] = prefix[n - 2]
    for i := 1; i < n - 1; i++ {
        products[i] = prefix[i - 1] * suffix[i + 1]
    }
    return products
}

func main() {
    nums := []int{1, 2, 3, 4}
    fmt.Println(productExceptSelf(nums))
}
