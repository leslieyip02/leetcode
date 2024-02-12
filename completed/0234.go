package main

import "fmt"

type ListNode struct {
    Val int
    Next *ListNode
}

func isPalindrome(head *ListNode) bool {
    var values []int
    length := 0
    current := head
    for current != nil {
        values = append(values, current.Val)
        length++
        current = current.Next
    }
    for i := 0; i < length / 2; i++ {
        if values[i] != values[length - 1 - i] {
            return false
        }
    }
    return true
}

func main() {
    n3 := ListNode{1,nil}
    n2 := ListNode{2,&n3}
    n1 := ListNode{2,&n2}
    n0 := ListNode{1,&n1}
    fmt.Println(isPalindrome(&n0))
}
