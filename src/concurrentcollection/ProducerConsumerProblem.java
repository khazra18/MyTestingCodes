package concurrentcollection;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerProblem {

    public static void main(String[] args) {

        ArrayList<Integer> myList = new ArrayList<>();
        final int SIZE = 5;

        Thread producer = new Thread(new Producer(myList, SIZE), "Producer");
        Thread consumer = new Thread(new Consumer(myList, SIZE), "Consumer");

        producer.start();
        consumer.start();

    }

}

class Producer implements Runnable {

    private final ArrayList<Integer> myList;
    private final int SIZE;

    private int count = 0;

    public Producer(ArrayList<Integer> myList, int SIZE) {
        this.myList = myList;
        this.SIZE = SIZE;
    }

    @Override
    public void run() {

        while (true){
            count++;
            System.out.println("Produced " + count);
            try {
                produce(count);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void produce(int i) throws InterruptedException {

        while (myList.size() == SIZE) {
            synchronized (myList) {
                System.out.println("The Queue is Full " + Thread.currentThread().getName() + " is waiting, current size is " + myList.size());
                myList.wait();
            }
        }

        synchronized (myList) {
            myList.add(i);
            myList.notifyAll();
        }

    }
}

class Consumer implements Runnable {

    private final ArrayList<Integer> myList;
    private final int SIZE;

    public Consumer(ArrayList<Integer> myList, int SIZE) {
        this.myList = myList;
        this.SIZE = SIZE;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed " + consume());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int consume() throws InterruptedException {

        while (myList.size() == 0) {
            synchronized (myList) {
                System.out.println("The Queue is empty " + Thread.currentThread().getName() + " is waiting, current size is " + myList.size());
                myList.wait();
            }
        }

        synchronized (myList) {
            myList.notifyAll();
            return myList.remove(0);
        }

    }
}
