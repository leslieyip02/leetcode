import java.util.*;

class Solution {
    public String countOfAtoms(String formula) {
        Stack<HashMap<String, Integer>> counts = new Stack<>();
        counts.push(new HashMap<>());

        int i = 0;
        while (i < formula.length()) {
            char c = formula.charAt(i);
            if (c == '(') {
                counts.push(new HashMap<>());
                i++;
                continue;
            } else if (c == ')') {
                int j = i + 1;
                while (j < formula.length() && Character.isDigit(formula.charAt(j))) {
                    j++;
                }
                int multiplier = (j == i + 1) ? 1 : Integer.parseInt(formula.substring(i + 1, j));

                Map<String, Integer> recent = counts.pop();
                Map<String, Integer> current = counts.peek();
                for (Map.Entry<String, Integer> entry : recent.entrySet()) {
                    String element = entry.getKey();
                    int count = entry.getValue();
                    current.put(element, current.getOrDefault(element, 0) + count * multiplier);
                }

                i = j;
                continue;
            }

            int j = i + 1;
            while (j < formula.length() && Character.isLowerCase(formula.charAt(j))) {
                j++;
            }
            String element = formula.substring(i, j);

            i = j;
            while (j < formula.length() && Character.isDigit(formula.charAt(j))) {
                j++;
            }
            int count = (j == i) ? 1 : Integer.parseInt(formula.substring(i, j));

            Map<String, Integer> current = counts.peek();
            current.put(element, current.getOrDefault(element, 0) + count);
            i = j;
        }

        Map<String, Integer> current = counts.peek();
        List<String> elements = new ArrayList<>(current.keySet());
        Collections.sort(elements);
        StringBuilder result = new StringBuilder();
        for (String element : elements) {
            result.append(element);
            int count = current.get(element);
            if (count > 1) {
                result.append(count);
            }
        }
        return result.toString();
    }
}
