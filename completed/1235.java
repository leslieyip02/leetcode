import java.util.*;

class Solution {
    public class Job implements Comparable<Job> {
        int startTime;
        int endTime;
        int profit;

        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }

        @Override
        public int compareTo(Job other) {
            return this.startTime - other.startTime;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs);

        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int j = Arrays.binarySearch(jobs, i + 1, n, new Job(jobs[i].endTime, -1, -1));
            if (j < 0) {
                j = -(j + 1);
            }
            while (j > 0 && jobs[j - 1].startTime == jobs[i].endTime) {
                j--;
            }
            dp[i] = Math.max(jobs[i].profit + dp[j], dp[i + 1]);
        }
        return dp[0];
    }
}
