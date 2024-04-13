import java.util.*;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int left = 0;
        int right = 0;
        int top = 0;
        int bottom = 0;
        int largest = 0;
        while (top < matrix.length) {
            if (matrix[top][left] == '1') {
                right = left + 1;
                while (right < matrix[top].length && matrix[top][right] == '1') {
                    right++;
                }
                largest = Math.max(right - left, largest);

                bottom = top + 1;
                while (bottom < matrix.length) {
                    boolean ok = true;
                    for (int i = left; i < right; i++) {
                        if (matrix[bottom][i] != '1') {
                            largest = Math.max((right - left) * (bottom - top), largest);
                            right = i;
                            break;
                        }
                    }
                    if (left == right) {
                        break;
                    }
                    bottom++;
                }
                largest = Math.max((right - left) * (bottom - top), largest);
            }

            if (left + 1 >= matrix[top].length) {
                left = 0;
                top++;
            } else {
                left++;
            }
        }
        return largest;
    }
}
