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
    public ListNode reverseKGroup(ListNode head, int k) {
        return traverse(head, k);
    }

    ListNode traverse(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        Stack<ListNode> accumulated = new Stack<>();
        ListNode current = head;
        while (current!= null && accumulated.size() < k) {
            accumulated.push(current);
            current = current.next;
        }

        if (accumulated.size() == k) {
            head = reverse(accumulated);
            ListNode next = head;
            for (int i = 0; i < k - 1; i++) {
                next = next.next;
            }

            if (next != null) {
                next.next = traverse(next.next, k);
            }
        }
        return head;
    }

    ListNode reverse(Stack<ListNode> accumulated) {
        ListNode next = accumulated.peek().next;

        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while (!accumulated.empty()) {
            ListNode current = accumulated.pop();
            head.next = current;
            head = current;
        }
        head.next = next;
        return dummy.next;
    }
}
