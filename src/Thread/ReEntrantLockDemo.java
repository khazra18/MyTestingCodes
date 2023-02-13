package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLockDemo {

    public static void main(String[] args) {
        final SharedClass s1 = new SharedClass(new ReentrantLock());
        Thread t1 = new Thread(s1::increment);
        Thread t2 = new Thread(s1::decrement);
        t1.start();
        t2.start();
    }
}

class SharedClass {
    static int i = 10;

    private Lock myLock;

    public SharedClass(Lock myLock) {
        this.myLock = myLock;
    }

    void increment() {
        myLock.lock();
        try {
            for (int j = 0; j < 1000000; j++) {
                // incrementing value of i\
                i = i + 1;
                System.out.println("i after increment " + i);
            }
        }finally {
            myLock.unlock();
        }
    }

    void decrement() {
        myLock.lock();
        try {
            for (int j = 0; j < 1000000; j++) {
                // decrementing value of i
                i = i - 1;
                System.out.println("i after decrement " + i);
            }
        }finally {
            myLock.unlock();
        }
    }
}
