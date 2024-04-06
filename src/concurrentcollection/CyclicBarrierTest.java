package concurrentcollection;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> System.out.println("Inside cyclic barrier"));

        Thread thread1 = new Thread(new MyThread("Thread1",10000,cyclicBarrier));
        Thread thread2 = new Thread(new MyThread("Thread2",5000,cyclicBarrier));
        Thread thread3 = new Thread(new MyThread("Thread3",3000,cyclicBarrier));

        thread1.start();
        thread2.start();
        thread3.start();

    }

}

class MyThread implements Runnable {

    String name;
    int time;
    CyclicBarrier barrier;

    public MyThread(String name, int time, CyclicBarrier barrier) {
        this.name = name;
        this.time = time;
        this.barrier = barrier;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(time);
            System.out.println(name + " waiting on barrier");
            barrier.await();
            System.out.println(name + " crossed the barrier");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
