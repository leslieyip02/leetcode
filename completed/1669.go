/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeInBetween(list1 *ListNode, a int, b int, list2 *ListNode) *ListNode {
    tail := list2
    for tail.Next != nil {
        tail = tail.Next
    }

    index := 0
    current := list1
    for index < a - 1 {
        current = current.Next;
        index++
    }
    start := current
    current = current.Next
    for index < b {
        current = current.Next
        index++
    }
    start.Next = list2
    tail.Next = current
    return list1
}
