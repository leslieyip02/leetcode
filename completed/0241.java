import java.util.*;
import java.util.stream.*;

class Solution {
    private int compute(int a, int b, char op) {
        int c = a;
        switch (op) {
        case '+':
            c += b;
            break;
        case '-':
            c -= b;
            break;
        case '*':
            c *= b;
            break;
        case '/':
            c /= b;
            break;
        default:
            c = -1;
            break;
        }
        return c;
    }

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> results = new ArrayList<>();

        boolean isAllNumeric = true;
        for (int i = 0; i < expression.length(); i++) {
            if (!Character.isDigit(expression.charAt(i))) {
                isAllNumeric = false;
                break;
            } 
        }
        if (isAllNumeric) {
            results.add(Integer.parseInt(expression));
            return results;
        }

        int leftIndex = 0;
        while (leftIndex < expression.length()) {
            char current = expression.charAt(leftIndex);
            if (!Character.isDigit(current)) {
                String leftExpression = expression.substring(0, leftIndex);
                String rightExpression = expression.substring(leftIndex + 1);
                List<Integer> left = diffWaysToCompute(leftExpression);
                List<Integer> right = diffWaysToCompute(rightExpression);
                for (int i = 0; i < left.size(); i++) {
                    for (int j = 0; j < right.size(); j++) {
                        results.add(compute(left.get(i), right.get(j), current));
                    }
                }
            }
            leftIndex++;
        }
        return results;
    }
}
