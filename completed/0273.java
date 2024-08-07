import java.util.*;

class Solution {
    private static final String[] U20 = new String[]{
        "One",
        "Two",
        "Three",
        "Four",
        "Five",
        "Six",
        "Seven",
        "Eight",
        "Nine",
        "Ten",
        "Eleven",
        "Twelve",
        "Thirteen",
        "Fourteen",
        "Fifteen",
        "Sixteen",
        "Seventeen",
        "Eighteen",
        "Nineteen"
    };

    private static final String[] TENS = new String[]{
        "Ten",
        "Twenty",
        "Thirty",
        "Forty",
        "Fifty",
        "Sixty",
        "Seventy",
        "Eighty",
        "Ninety"
    };

    private static final int HUNDRED = (int) 1e2;
    private static final int THOUSAND = (int) 1e3;
    private static final int MILLION = (int) 1e6;
    private static final int BILLION = (int) 1e9;

    private List<String> helper(int num) {
        List<String> segments = new ArrayList<>();

        if (num >= BILLION) {
            segments.add(U20[num / BILLION - 1]);
            segments.add("Billion");
        }

        if (num >= MILLION) {
            int mod = (num / MILLION) % 1000;
            if (mod > 0) {
                segments.addAll(helper(mod));
                segments.add("Million");
            }
        }

        if (num >= THOUSAND) {
            int mod = (num / THOUSAND) % 1000;
            if (mod > 0) {
                segments.addAll(helper(mod));
                segments.add("Thousand");
            }
        }

        if (num >= HUNDRED) {
            int index = (num / 100) % 10 - 1;
            if (index >= 0) {
                segments.add(U20[index]);
                segments.add("Hundred");
            }
        }

        num %= 100;
        if (num >= 20) {
            segments.add(TENS[(num / 10) % 10 - 1]);
            if (num % 10 != 0) {
                segments.add(U20[num % 10 - 1]);
            }
        } else if (num > 0) {
            segments.add(U20[num - 1]);
        }

        return segments;
    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        List<String> segments = helper(num);
        return String.join(" ", segments);
    }
}
