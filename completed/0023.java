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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            pq.add(list);
        }

        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll();
            current.next = new ListNode(smallest.val);
            current = current.next;

            ListNode next = smallest.next;
            if (next != null) {
                pq.add(next);
            }
        }
        return dummy.next;
    }
}
