import java.util.*;
import java.util.stream.*;

class Solution {
    public String largestNumber(int[] nums) {
        return IntStream.of(nums).allMatch((num) -> num == 0)
            ? "0"
            : IntStream.of(nums)
                .mapToObj((num) -> num + "")
                .sorted((num0, num1) -> (num1 + num0).compareTo(num0 + num1))
                .reduce(
                    new StringBuilder(),
                    (accumulator, current) -> accumulator.append(current),
                    (accumulator1, accumulator2) -> accumulator1.append(accumulator2)
                )
                .toString();
    }
}
