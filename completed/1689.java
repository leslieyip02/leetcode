class Solution {
    public int minPartitions(String n) {
        int min = 0;
        for (int i = 0; i < n.length(); i++) {
            min = Math.max((int) n.charAt(i) - '0', min);
        }
        return min;
    }
}
