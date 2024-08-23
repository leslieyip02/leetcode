import java.util.*;

class Solution {
    private class Fraction {
        int numerator;
        int denominator;

        Fraction(String expression) {
            String[] tokens = expression.split("/");
            this.numerator = Integer.parseInt(tokens[0]);
            this.denominator = Integer.parseInt(tokens[1]);
        }

        public String toString() {
            if (numerator == 0) {
                return "0/1";
            }

            int divisor = gcd(numerator, denominator);
            numerator /= divisor;
            denominator /= divisor;
            if (denominator < 0) {
                numerator *= -1;
                denominator *= -1;
            }
            return numerator + "/" + denominator;
        }
    }

    private int gcd(int x, int y) {
        if (x == 0 || y == 0) {
            return x + y;
        }

        x = Math.abs(x);
        y = Math.abs(y);
        if (x > y) {
            int tmp = x;
            x = y;
            y = tmp;
        } 
        return gcd(y % x, x);
    }

    private int lcm(int x, int y) {
        return (x * y) / gcd(x, y);
    }

    public String fractionAddition(String expression) {
        String[] tokens = expression.split("[\\+\\-]");
        List<Fraction> fractions = new ArrayList<>();
        for (String token : tokens) {
            if (token == "") {
                continue;
            }
            fractions.add(new Fraction(token));
        }
        if (fractions.size() == 1) {
            return expression;
        }

        int multiple = lcm(fractions.get(0).denominator, fractions.get(1).denominator);
        for (int i = 2; i < fractions.size(); i++) {
            multiple = lcm(fractions.get(i).denominator, multiple);
        }

        int i = 0;
        if (!expression.startsWith("-")) {
            expression = "+" + expression;
        }
        Fraction result = new Fraction("0/" + multiple);
        for (int j = 0; j < expression.length(); j++) {
            if (expression.charAt(j) != '+' && expression.charAt(j) != '-') {
                continue;
            }

            int factor = multiple / fractions.get(i).denominator * (expression.charAt(j) == '+' ? 1 : -1);
            result.numerator += fractions.get(i).numerator * factor;
            i++;
        }

        return result.toString();
    }
}
