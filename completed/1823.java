import java.util.*;

class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> circle = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            circle.add(i);
        }

        int index = 0;
        while (circle.size() > 1) {
            index = (index + k - 1) % circle.size();
            circle.remove(index);
        }
        return circle.get(0);
    }
}
