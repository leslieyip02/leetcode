import java.util.*;

class Solution {
    private class Node {
        boolean isTerminal;
        Map<String, Node> nextNodes;

        Node() {
            this.nextNodes = new HashMap<>();
        }

        boolean add(String[] components, int index) {
            if (index == components.length) {
                return true;
            }

            String component = components[index];
            Node nextNode = nextNodes.get(component);
            if (nextNode == null) {
                nextNode = new Node();
                nextNode.isTerminal = (index == components.length - 1);
                nextNodes.put(component, nextNode);
            } else if (nextNode.isTerminal) {
                return false;
            }
            return nextNode.add(components, index + 1);
        }
    }

    public List<String> removeSubfolders(String[] folder) {
        Node root = new Node();
        List<String> results = new ArrayList<>();
        Arrays.sort(folder);
        for (String path : folder) {
            String[] components = path.split("/");
            if (root.add(components, 0)) {
                results.add(path);
            }
        }
        return results;
    }
}
