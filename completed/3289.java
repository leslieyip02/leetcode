import java.util.*;

class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int[] answer = new int[2];
        int answerIndex = 0;
        for (int num : nums) {
            if (seen.contains(num)) {
                answer[answerIndex] = num;
                answerIndex++;
                if (answerIndex == 2) {
                    break;
                }
            }
            seen.add(num);
        }
        return answer;
    }
}
