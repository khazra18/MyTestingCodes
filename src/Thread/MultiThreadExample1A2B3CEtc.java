package Thread;

import java.util.ArrayList;
import java.util.Arrays;

public class MultiThreadExample1A2B3CEtc {

    public static void main(String[] args) throws InterruptedException {

        MultiThreadDemo multiThreadDemo = new MultiThreadDemo();
        Thread t1 = new Thread(() -> {
            try {
                multiThreadDemo.showAlphabetMethod();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Alphabet Thread");
        Thread t2 = new Thread(() -> {
            try {
                multiThreadDemo.showNumberMethod();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Number Thread");


        t1.start();
        t2.start();

    }

}

class MultiThreadDemo{

    ArrayList<String> alphabetList = new ArrayList<>(Arrays.asList("A","B","C","D","E","F","G","H","I","J"));
    ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

    final Object lock = new Object();

    int numberCounter = 0;
    int alphabetCounter = 0;

    boolean isAlphabetShowing = false;

    public void showAlphabetMethod() throws InterruptedException {

        while (alphabetCounter < 10){
            synchronized (lock){
                while (isAlphabetShowing){
                    lock.wait();
                }

                System.out.println("Thread name : " + Thread.currentThread().getName() + " - " + alphabetList.get(alphabetCounter));
                alphabetCounter++;
                isAlphabetShowing = true;
                lock.notify();
                Thread.sleep(1000);
            }
        }
    }

    public void showNumberMethod() throws InterruptedException {
        while (numberCounter < 10){
            synchronized (lock){
                while (!isAlphabetShowing){
                    lock.wait();
                }

                System.out.println("Thread name : " + Thread.currentThread().getName() + " - " + numberList.get(numberCounter));
                numberCounter++;
                isAlphabetShowing = false;
                lock.notify();
                Thread.sleep(1000);
            }
        }
    }

}

