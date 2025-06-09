class Foo {
private:
    mutex firstDone;
    mutex secondDone;

public:
    Foo() {
        firstDone.lock();
        secondDone.lock();
    }

    void first(function<void()> printFirst) {

        // printFirst() outputs "first". Do not change or remove this line.
        printFirst();
        firstDone.unlock();
    }

    void second(function<void()> printSecond) {
        firstDone.lock();

        // printSecond() outputs "second". Do not change or remove this line.
        printSecond();
        secondDone.unlock();
    }

    void third(function<void()> printThird) {
        secondDone.lock();
        
        // printThird() outputs "third". Do not change or remove this line.
        printThird();
    }
};
