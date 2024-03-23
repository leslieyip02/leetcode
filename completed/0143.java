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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        Deque<ListNode> nodes = new LinkedList<>();
        ListNode current = head;
        while (current != null) {
            nodes.add(current);
            current = current.next;
        }

        boolean front = true;
        Queue<ListNode> ordered = new LinkedList<>();
        while (!nodes.isEmpty()) {
            ordered.add(front ? nodes.pollFirst() : nodes.pollLast());
            front = !front;
        }

        current = ordered.poll();
        while (!ordered.isEmpty()) {
            current.next = ordered.poll();
            current = current.next;
        }
        current.next = null;
    }
}
