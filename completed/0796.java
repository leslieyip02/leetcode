class Solution {
    public boolean rotateString(String s, String goal) {
        String ss = s + s;
        return goal.length() == s.length() && ss.contains(goal);
    }
}
