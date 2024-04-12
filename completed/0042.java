import java.util.*;

class Solution {
    public int trap(int[] height) {
        Stack<Integer> left = new Stack<>();
        int water = 0;
        for (int i = 0; i < height.length; i++) {
            int bottom = 0;
            while (!left.empty() && height[i] >= height[left.peek()]) {
                water += (i - left.peek() - 1) * (height[left.peek()] - bottom);
                bottom = height[left.peek()];
                left.pop();
            }
            if (!left.empty()) {
                water += (i - left.peek() - 1) * (height[i] - bottom);
            }
            left.push(i);
        }
        return water;
    }
}
