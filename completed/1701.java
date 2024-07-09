import java.util.*;

class Solution {
    public double averageWaitingTime(int[][] customers) {
        double total = 0;
        int available = customers[0][0];
        for (int customer[] : customers) {
            int arrival = customer[0];
            int time = customer[1];

            if (arrival < available) {
                total += available - arrival;
            } else {
                available = arrival;
            }

            total += time;
            available += time;
        }
        return total / customers.length;
    }
}
