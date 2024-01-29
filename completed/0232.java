import java.util.*;

class MyQueue {

    private Stack<Integer> values;

    public MyQueue() {
        this.values = new Stack<>();
    }
    
    public void push(int x) {
        this.values.push(x);
    }
    
    public int pop() {
        Stack<Integer> tmp = new Stack<>();
        while (!this.values.empty()) {
            tmp.push(this.values.pop());
        }
        int top = tmp.pop();
        while (!tmp.empty()) {
            this.values.push(tmp.pop());
        }
        return top;
    }
    
    public int peek() {
        Stack<Integer> tmp = new Stack<>();
        while (!this.values.empty()) {
            tmp.push(this.values.pop());
        }
        int top = tmp.peek();
        while (!tmp.empty()) {
            this.values.push(tmp.pop());
        }
        return top;
    }
    
    public boolean empty() {
        return this.values.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
