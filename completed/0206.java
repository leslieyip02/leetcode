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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        Stack<ListNode> nodes = new Stack<>();
        nodes.push(head);
        while (nodes.peek().next != null) {
            nodes.push(nodes.peek().next);
        }

        ListNode newHead = nodes.pop();
        ListNode current = newHead;
        while (!nodes.empty()) {
            current.next = nodes.pop();
            current = current.next;
        }
        current.next = null;
        return newHead;
    }
}
