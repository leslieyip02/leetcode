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
    private boolean isCritical(int previous, int current, int next) {
        return (current < previous && current < next) || (current > previous && current > next);
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int leftMost = -1;
        int rightMost = -1;
        int minDistance = -1;
        int maxDistance = -1;

        Queue<Integer> nodes = new LinkedList<>();
        for (int i = 0; i < 2; i++) {
            nodes.add(head.val);
            head = head.next;
        }

        int index = 1;
        while (head != null) {
            int previous = nodes.remove();
            int current = nodes.peek();
            int next = head.val;

            if (isCritical(previous, current, next)) {
                if (leftMost == -1) {
                    leftMost = index;
                }

                if (rightMost != -1) {
                    int distance = index - rightMost;
                    if (minDistance == -1 || distance < minDistance) {
                        minDistance = distance;
                    }
                }
                rightMost = index;
            }

            nodes.add(head.val);
            head = head.next;
            index++;
        }

        if (leftMost != -1 && rightMost != -1 && leftMost != rightMost) {
            maxDistance = rightMost - leftMost;
        }

        return new int[]{ minDistance, maxDistance };
    }
}
