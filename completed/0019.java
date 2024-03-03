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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> nodes = new Stack<>();
        ListNode current = head;
        while (current.next != null) {
            nodes.push(current);
            current = current.next;
        }
        nodes.push(current);

        for (int i = 0; i < n; i++) {
            current = nodes.pop();
        }
        if (nodes.empty()) {
            return current.next;
        } else {
            nodes.peek().next = current.next;
            return head;
        }
    }
}
