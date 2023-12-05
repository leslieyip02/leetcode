import java.util.*;

class Solution {
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean lowercase = false;
        boolean uppercase = false;
        boolean digit = false;
        boolean special = false;
        String specials = "!@#$%^&*()-+";
        boolean consecutive = false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            lowercase |= Character.isLowerCase(c);
            uppercase |= Character.isUpperCase(c);
            digit |= Character.isDigit(c);
            special |= specials.contains(c + "");
            consecutive |= (i > 0 && c == password.charAt(i - 1));
        }
        return lowercase && uppercase && digit && special && !consecutive;
    }

    public static void main(String[] args) {
        String password = "IloveLe3tcode!";

        Solution solution = new Solution();
        System.out.println(solution.strongPasswordCheckerII(password));
    }
}
