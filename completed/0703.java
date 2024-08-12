import java.util.*;

class KthLargest {

    int k;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>((i, j) -> i - j);
        for (int num : nums) {
            this.pq.add(num);
            if (this.pq.size() > this.k) {
                this.pq.poll();
            }
        }
    }
    
    public int add(int val) {
        this.pq.add(val);
        if (this.pq.size() > this.k) {
            this.pq.poll();
        }
        return this.pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
