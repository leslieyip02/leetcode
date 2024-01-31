class DataStream {

    private int value;
    private int k;
    private int c;
    private Queue<Boolean> values;

    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
        this.c = 0;
        this.values = new LinkedList<>();
    }
    
    public boolean consec(int num) {
        if (this.values.size() == this.k) {
            boolean top = this.values.poll();
            if (top) {
                this.c--;
            }
        }
        if (num == this.value) {
            this.c++;
        }
        this.values.add(num == this.value);
        return this.c == this.k;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */
