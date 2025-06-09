class FooBar {
private:
    int n;

    mutex fooLock;
    mutex barLock;

public:
    FooBar(int n) {
        this->n = n;

        barLock.lock();
    }

    void foo(function<void()> printFoo) {
        
        for (int i = 0; i < n; i++) {
            fooLock.lock();

        	// printFoo() outputs "foo". Do not change or remove this line.
        	printFoo();
            barLock.unlock();
        }
    }

    void bar(function<void()> printBar) {
        
        for (int i = 0; i < n; i++) {
            barLock.lock();

        	// printBar() outputs "bar". Do not change or remove this line.
        	printBar();
            fooLock.unlock();
        }
    }
};
