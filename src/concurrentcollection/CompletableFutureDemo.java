package concurrentcollection;

import java.util.concurrent.*;

public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //System.out.println(completableFutureGetMethod());
        //System.out.println(completableFutureSupplyAsyncMethod());
        completableFutureRunAsyncMethod();

    }

    static String completableFutureGetMethod() throws ExecutionException, InterruptedException {

        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        System.out.println(completableFuture.complete("Hello world"));
        return completableFuture.get();

    }

    static String completableFutureSupplyAsyncMethod() throws ExecutionException, InterruptedException {

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello world");
        return completableFuture.get();

    }

    static void completableFutureRunAsyncMethod() throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Runnable runnable = () -> System.out.println("this is Run async method");

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(runnable, executorService);

        voidCompletableFuture.complete(null);
        if (voidCompletableFuture.isDone())
            System.out.println("Method successfully ran");


    }


}
