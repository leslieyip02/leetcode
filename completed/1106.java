import java.util.*;

class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> operators = new Stack<>();
        Stack<Stack<Boolean>> values = new Stack<>();
        values.push(new Stack<>());

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == ',' || c == ' ') {
                continue;
            }

            if (c == '!' || c == '&' || c == '|') {
                operators.push(c);
                continue;
            }

            if (c == '(') {
                values.push(new Stack<>());
                continue;
            }

            if (c == ')') {
                Stack<Boolean> current = values.pop();
                boolean evaluated = current.pop();
                char operator = operators.pop();

                if (operator == '!') {
                    values.peek().push(!evaluated);
                    continue;
                }

                boolean isAnd = operator == '&';
                while (!current.empty()) {
                    if (isAnd) {
                        evaluated &= current.pop();
                    } else {
                        evaluated |= current.pop();
                    }
                }

                values.peek().push(evaluated);
                continue;
            }

            values.peek().push(c == 't');
        }

        return values.pop().pop();
    }
}
