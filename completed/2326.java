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
    private static final int[][] DIRECTIONS = {{ 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }};

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(matrix[i], -1);
        }

        int x = 0;
        int y = 0;
        int directionIndex = 0;
        while (head != null) {
            int dx = DIRECTIONS[directionIndex][0];
            int dy = DIRECTIONS[directionIndex][1];
            if (x + dx == n || x + dx == -1 || matrix[y][x + dx] != -1) {
                directionIndex = (directionIndex + 1) % DIRECTIONS.length;
            }
            if (y + dy == m || y + dy == -1 || matrix[y + dy][x] != -1) {
                directionIndex = (directionIndex + 1) % DIRECTIONS.length;
            }

            matrix[y][x] = head.val;
            dx = DIRECTIONS[directionIndex][0];
            dy = DIRECTIONS[directionIndex][1];
            x += dx;
            y += dy;
            head = head.next;
        }
        return matrix;
    }
}
