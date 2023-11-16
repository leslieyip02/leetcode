import java.util.*;
import java.util.stream.*;

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int length = nums[0].length();
        HashSet<Integer> existing = Stream.of(nums)
            .map(num -> Integer.parseInt(num, 2))
            .collect(Collectors.toCollection(HashSet::new));
        int different = 0;
        while (existing.contains(different)) {
            different++;
        }
        String binary = Integer.toBinaryString(different);
        return String.format("%" + length + "s", binary)
            .replace(' ', '0');
    }

    public static void main(String[] args) {
        String[] nums = { "01", "10" };

        Solution solution = new Solution();
        System.out.println(solution.findDifferentBinaryString(nums));
    }
}
