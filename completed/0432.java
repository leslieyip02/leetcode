import java.util.*;

class AllOne {
    private class Node {
        int frequency;
        Node prev;
        Node next;
        Set<String> keys;

        public Node(int frequency) {
            this.frequency = frequency;
            this.keys = new HashSet<>();
        }
    }

    private Node head;
    private Node tail;
    private Map<String, Node> nodes;

    public AllOne() {
        this.head = new Node(-1);
        this.tail = new Node(-1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.nodes = new HashMap<>();
    }

    public void inc(String key) {
        if (nodes.containsKey(key)) {
            Node current = nodes.get(key);
            int frequency = current.frequency;
            current.keys.remove(key);

            Node next = current.next;
            if (next == tail || next.frequency != frequency + 1) {
                Node newNode = new Node(frequency + 1);
                newNode.keys.add(key);

                current.next = newNode;
                newNode.prev = current;

                newNode.next = next;
                next.prev = newNode;

                nodes.put(key, newNode);
            } else {
                next.keys.add(key);
                nodes.put(key, next);
            }

            if (current.keys.isEmpty()) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
        } else {
            Node first = head.next;
            if (head.next == tail || head.next.frequency != 1) {
                Node newNode = new Node(1);
                newNode.keys.add(key);

                head.next = newNode;
                newNode.prev = head;

                newNode.next = first;
                first.prev = newNode;

                nodes.put(key, newNode);
            } else {
                first.keys.add(key);
                nodes.put(key, first);
            }
        }
    }

    public void dec(String key) {
        if (!nodes.containsKey(key)) {
            return;
        }

        Node current = nodes.get(key);
        int frequency = current.frequency;
        current.keys.remove(key);

        if (frequency == 1) {
            nodes.remove(key);
        } else {
            Node prev = current.prev;
            if (prev == head || prev.frequency != frequency - 1) {
                Node newNode = new Node(frequency - 1);
                newNode.keys.add(key);

                current.prev = newNode;
                newNode.prev = prev;

                newNode.next = current;
                prev.next = newNode;

                nodes.put(key, newNode);
            } else {
                prev.keys.add(key);
                nodes.put(key, prev);
            }
        }

        if (current.keys.isEmpty()) {
            current.next.prev = current.prev;
            current.prev.next = current.next;
        }
    }

    public String getMaxKey() {
        if (tail.prev == head) {
            return "";
        }
        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if (head.next == tail) {
            return "";
        }
        return head.next.keys.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
