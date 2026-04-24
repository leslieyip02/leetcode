class MinStack {
public:
    MinStack() {}
    
    void push(int val) {
        data.push_back(val);
        if (history.empty()) {
            history.push_back(val);
        } else {
            history.push_back(min(val, history.back()));
        }
    }
    
    void pop() {
        data.pop_back();
        history.pop_back();
    }
    
    int top() {
        return data.back();
    }
    
    int getMin() {
        return history.back();
    }

private:
    vector<int> data;
    vector<int> history;
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
