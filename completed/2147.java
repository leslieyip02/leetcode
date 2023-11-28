import java.util.*;

class Solution {
    public int numberOfWays(String corridor) {
        List<Integer> sections = new ArrayList<>();
        int seats = 0;
        int plants = 0;
        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') {
                if (seats != 0 && seats % 2 == 0) {
                    if (plants != 0) {
                        sections.add(plants);
                        plants = 0;
                    }
                }
                seats++;
            } else if (seats != 0 && seats % 2 == 0) {
                // don't count plants that are between 2 seats
                // since they can't be divided anyways
                plants++;
            }
        }
        long ways = seats % 2 != 0 || seats == 0 ? 0 : 1;
        for (var section : sections) {
            ways *= (section + 1);
            ways %= (long) 1e9 + 7;
        }
        return (int) ways;
    }

    public static void main(String[] args) {
        String corridor = "SSPPSPS";
        // String corridor = "PPSPSP";

        Solution solution = new Solution();
        System.out.println(solution.numberOfWays(corridor));
    }
}
