class Solution {
    public int findComplement(int num) {
        int result = 0;
        int index = 0;
        while (num > 0) {
            if ((num & 1) == 0) {
                result |= (1 << index);
            }
            index++;
            num >>= 1;
        }
        return result;
    }
}
