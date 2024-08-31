class FrequencyTracker {
    private static final int MAX_N = (int) 1e5;

    private int[] counts;
    private int[] frequencyCounts;

    public FrequencyTracker() {
        this.counts = new int[MAX_N + 1];
        this.frequencyCounts = new int[MAX_N + 1];
        frequencyCounts[0] = 1;
    }
    
    public void add(int number) {
        frequencyCounts[counts[number]]--;
        counts[number]++;
        frequencyCounts[counts[number]]++;
    }
    
    public void deleteOne(int number) {
        if (counts[number] == 0) {
            return;
        }
        frequencyCounts[counts[number]]--;
        counts[number]--;
        frequencyCounts[counts[number]]++;
    }
    
    public boolean hasFrequency(int frequency) {
        return frequencyCounts[frequency] != 0;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */
