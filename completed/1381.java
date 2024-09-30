import java.util.*;

class CustomStack {
    private int[] values;
    private int length;

    public CustomStack(int maxSize) {
        this.values = new int[maxSize];
        this.length = 0;
    }

    public void push(int x) {
        if (length == values.length) {
            return;
        }
        values[length] = x;
        length++;
    }

    public int pop() {
        if (length == 0) {
            return -1;
        }
        length--;
        return values[length];
    }

    public void increment(int k, int val) {
        for (int i = 0; i < k && i < length; i++) {
            values[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
