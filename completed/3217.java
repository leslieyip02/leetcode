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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while (head != null) {
            if (!set.contains(head.val)) {
                current.next = head;
                current = current.next;
            }
            head = head.next;
        }
        current.next = null;
        return dummy.next;
    }
}
