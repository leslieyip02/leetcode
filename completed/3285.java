import java.util.*;

class Solution {
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > threshold) {
                answer.add(i);
            }
        }
        return answer;
    }
}
