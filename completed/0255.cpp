#include <iostream>
#include <queue>
using namespace std;

class MyStack {
private:
    queue<int> values;
    queue<int> tmp;

public:
    MyStack() {
        return;
    }
    
    void push(int x) {
        values.push(x);
    }
    
    int pop() {
        if (values.empty()) {
            return -1;
        }

        while (values.size() > 1) {
            tmp.push(values.front());
            values.pop();
        }
        int value = values.front();
        values.pop();

        while (!tmp.empty()) {
            values.push(tmp.front());
            tmp.pop();
        }
        return value;
    }
    
    int top() {
        return values.back();
    }
    
    bool empty() {
        return values.empty();
    }
};

int main() {
    MyStack myStack;
    myStack.push(1);
    myStack.push(2);
    myStack.push(3);
    cout << myStack.top() << endl;
    cout << myStack.pop() << endl;
    cout << myStack.pop() << endl;
    cout << myStack.pop() << endl;
    cout << (myStack.empty() ? "true" : "false") << endl;
    return 0;
}