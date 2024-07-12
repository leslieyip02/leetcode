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
    public ListNode swapNodes(ListNode head, int k) {
        Stack<ListNode> nodes = new Stack<>();

        ListNode current = head;
        ListNode front = new ListNode();
        ListNode back = new ListNode();
        while (current != null) {
            nodes.push(current);
            if (nodes.size() == k) {
                front = current;
            }
            current = current.next;
        }

        for (int i = 0; i < k - 1; i++) {
            nodes.pop();
        }
        back = nodes.pop();

        int tmp = front.val;
        front.val = back.val;
        back.val = tmp;
        return head;
    }
}
