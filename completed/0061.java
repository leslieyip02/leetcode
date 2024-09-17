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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode tail = head;
        Stack<ListNode> nodes = new Stack<>();
        while (current != null) {
            nodes.push(current);
            tail = current;
            current = current.next;
        }

        k %= nodes.size();
        if (k == 0) {
            return head;
        }

        tail.next = head;
        while (k > 0) {
            head = nodes.pop();
            k--;
        }
        nodes.peek().next = null;
        return head;
    }
}
