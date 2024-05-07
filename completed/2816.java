import java.util.*;

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
    public ListNode doubleIt(ListNode head) {
        Stack<ListNode> nodes = new Stack<>();
        nodes.push(head);
        while (head.next != null) {
            head = head.next;
            nodes.push(head);
        }

        int carry = 0;
        ListNode doubled = null;
        while (!nodes.empty()) {
            int n = nodes.pop().val * 2 + carry;
            doubled = new ListNode(n % 10, doubled);
            carry = n / 10;
        }
        if (carry != 0) {
            doubled = new ListNode(1, doubled);
        }
        return doubled;
    }
}
