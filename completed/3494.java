class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;

        long[] completionTimes = new long[n];
        completionTimes[0] = skill[0] * mana[0];
        for (int i = 1; i < n; i++) {
            completionTimes[i] = skill[i] * mana[0] + completionTimes[i - 1];
        }

        for (int j = 1; j < m; j++) {
            long[] option1 = new long[n];
            for (int i = 0; i < n; i++) {
                option1[i] = skill[i] * mana[j] + completionTimes[i];
            }

            long[] option2 = new long[n];
            option2[n - 1] = option1[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                option2[i] = option2[i + 1] - skill[i + 1] * mana[j];
            }

            long lag = 0;
            for (int i = 0; i < n; i++) {
                lag = Math.max(option1[i] - option2[i], lag);
            }

            for (int i = 0; i < n; i++) {
                completionTimes[i] = option2[i] + lag;
            }
        }
        return completionTimes[n - 1];
    }
}
