import java.util.*;

class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        if (n % 2 != 0) {
            return -1;
        }

        long sum = 0;
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum += skill[i];
            counts.put(skill[i], counts.getOrDefault(skill[i], 0) + 1);
        }


        if (sum % (n / 2) != 0) {
            return -1;
        }
        int target = (int) sum / (n / 2);

        long chemistry = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int count = entry.getValue();
            if (count == 0) {
                continue;
            }

            int key = entry.getKey();
            if (counts.getOrDefault(target - key, 0) != count) {
                return -1;
            }

            if (key == target - key) {
                count /= 2;
            }
            chemistry += (long) (key * (target - key)) * count;
            counts.put(key, 0);
            counts.put(target - key, 0);
        }
        return chemistry;
    }
}
