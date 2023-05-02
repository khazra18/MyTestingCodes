package concurrentcollection;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExample1 {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        System.out.println("Adding to list start time : " + LocalTime.now());
        List<Task1> myList = new ArrayList<>();

        for (int i = 0 ; i < 100 ; i++){
            myList.add(new Task1(i));
        }

        System.out.println("Adding to list end time : " + LocalTime.now());
        List<Future<String>> futures = executorService.invokeAll(myList);
        futures.forEach(stringFuture -> {
            try {
                System.out.println(stringFuture.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.shutdown();

    }

}

class Task1 implements Callable<String>{

    int taskID;

    public Task1(int taskID) {
        this.taskID = taskID;
    }

    @Override
    public String call() throws Exception {
        return "Task id :" + taskID + " current thread : " + Thread.currentThread().getName();
    }
}