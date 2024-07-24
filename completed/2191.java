import java.util.*;

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer, Long> mapped = new HashMap<>();
        for (int num : nums) {
            long value = mapping[num % 10];
            int copy = num / 10;
            int pow = 1;
            while (copy > 0) {
                value += mapping[copy % 10] * Math.pow(10, pow);
                copy /= 10;
                pow++;
            }
            mapped.put(num, value);
        }

        return Arrays.stream(nums)
            .boxed()
            .sorted((i, j) -> (int) (mapped.get(i) - mapped.get(j)))
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
