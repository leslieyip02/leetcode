class ZeroEvenOdd {
private:
    int n;

    mutex zeroLock;
    mutex oddLock;
    mutex evenLock;

public:
    ZeroEvenOdd(int n) {
        this->n = n;

        oddLock.lock();
        evenLock.lock();
    }

    // printNumber(x) outputs "x", where x is an integer.
    void zero(function<void(int)> printNumber) {
        for (int i = 1; i <= n; i++) {
            zeroLock.lock();
            printNumber(0);
            if (i % 2 == 0) {
                evenLock.unlock();
            } else {
                oddLock.unlock();
            }
        }
    }

    void even(function<void(int)> printNumber) {
        for (int i = 2; i <= n; i += 2) {
            evenLock.lock();
            printNumber(i);
            zeroLock.unlock();
        }
    }

    void odd(function<void(int)> printNumber) {
        for (int i = 1; i <= n; i += 2) {
            oddLock.lock();
            printNumber(i);
            zeroLock.unlock();
        }
    }
};
