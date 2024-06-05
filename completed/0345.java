class Solution {
    private boolean isVowel(char c) {
        char u = Character.toUpperCase(c);
        return u == 'A' || u == 'E' || u == 'I' || u == 'O' || u == 'U';
    }

    public String reverseVowels(String s) {
        int left = 0;
        int right  = s.length() - 1;

        char[] buffer = s.toCharArray();
        while (left < right) {
            if (!isVowel(buffer[left])) {
                left++;
            } else if (!isVowel(buffer[right])) {
                right--;
            } else {
                char tmp = buffer[left];
                buffer[left] = buffer[right];
                buffer[right] = tmp;
                left++;
                right--;
            }
        }
        return new String(buffer);
    }
}
