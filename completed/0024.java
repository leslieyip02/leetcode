/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode helper(ListNode current) {
        if (current == null || current.next == null) {
            return current;
        }

        ListNode newCurrent = current.next;
        current.next = helper(current.next.next);
        newCurrent.next = current;
        return newCurrent;
    }

    public ListNode swapPairs(ListNode head) {
        return helper(head);
    }
}
