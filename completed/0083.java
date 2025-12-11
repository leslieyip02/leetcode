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
        if (current == null) {
            return null;
        }

        ListNode next = helper(current.next);
        if (next != null && next.val == current.val) {
            return next;
        }

        current.next = next;
        return current;
    }

    public ListNode deleteDuplicates(ListNode head) {
        return helper(head);
    }
}
