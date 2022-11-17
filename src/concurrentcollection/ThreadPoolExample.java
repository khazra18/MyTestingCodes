package concurrentcollection;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0 ; i < 100 ; i++){
            executorService.submit(new Task(i));
        }

        executorService.shutdown();
    }

}

class Task implements Runnable{

    private int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task id : " + taskId + " Performed by : " + Thread.currentThread().getName());
    }
}