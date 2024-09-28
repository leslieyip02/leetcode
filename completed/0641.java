import java.util.*;

class MyCircularDeque {
    private static final int EMPTY = -1;

    private int[] values;
    private int left;
    private int right;
    private int length;
    private int capacity;

    public MyCircularDeque(int k) {
        this.values = new int[k * 2];
        Arrays.fill(this.values, EMPTY);

        this.left = k;
        this.right = k;
        this.length = 0;
        this.capacity = k;
    }

    public boolean insertFront(int value) {
        if (length == capacity) {
            return false;
        }

        values[left] = value;
        if (left == right) {
            right++;
        }
        left--;
        length++;
        return true;
    }

    public boolean insertLast(int value) {
        if (length == capacity) {
            return false;
        }

        values[right] = value;
        if (left == right) {
            left--;
        }
        right++;
        length++;
        return true;
    }

    public boolean deleteFront() {
        if (values[left + 1] == EMPTY) {
            return false;
        }

        left++;
        values[left] = EMPTY;
        length--;
        return true;
    }

    public boolean deleteLast() {
        if (values[right - 1] == EMPTY) {
            return false;
        }

        right--;
        values[right] = EMPTY;
        length--;
        return true;

    }

    public int getFront() {
        return values[left + 1];
    }

    public int getRear() {
        return values[right - 1];
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
