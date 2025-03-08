class MyCircularQueue {

    int[] values;

    int front;
    int back;
    int size;

    public MyCircularQueue(int k) {
        this.values = new int[k];
        Arrays.fill(this.values, -1);

        this.front = 0;
        this.back = -1;
        this.size = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        back = (back + 1) % values.length;
        values[back] = value;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        values[front] = -1;
        front = (front + 1) % values.length;
        size--;
        return true;
    }
    
    public int Front() {
        return values[front];
    }
    
    public int Rear() {
        return back == -1 ? -1 : values[back];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == values.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
