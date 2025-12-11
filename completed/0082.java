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

        ListNode next = current.next;
        if (next == null) {
            return current;
        }

        if (next.val == current.val) {
            while (next != null && next.val == current.val) {
                next = next.next;
            }
            return helper(next);
        }

        current.next = helper(next);
        return current;
    }

    public ListNode deleteDuplicates(ListNode head) {
        return helper(head);
    }
}
