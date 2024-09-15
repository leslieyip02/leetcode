class Solution {
    private int updateMask(int mask, char vowel) {
        switch (vowel) {
            case 'a':
                mask ^= 1;
                break;
            case 'e':
                mask ^= 2;
                break;
            case 'i':
                mask ^= 4;
                break;
            case 'o':
                mask ^= 8;
                break;
            case 'u':
                mask ^= 16;
                break;
            default:
                break;
        }
        return mask;
    }

    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> masks = new HashMap<>();
        masks.put(0, -1);
        int mask = 0;
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            mask = updateMask(mask, s.charAt(i));
            if (!masks.containsKey(mask)) {
                masks.put(mask, i);
            }
            longest = Math.max(i - masks.get(mask), longest);
        }
        return longest;
    }
}
