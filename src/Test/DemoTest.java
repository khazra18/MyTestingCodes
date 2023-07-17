package Test;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class DemoTest {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(2);
        List<MyDemoCall> myDemoCalls = new ArrayList<>();
        for (int i = 0 ; i < 5 ; i++){
            MyDemoCall call = new MyDemoCall((i+1)*1000);
            myDemoCalls.add(call);
        }

        List<Future<String>> futures = service.invokeAll(myDemoCalls);
        service.shutdown();

        futures.forEach(stringFuture -> {
            try {
                System.out.println(stringFuture.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

    }

}
class MyDemoCall implements Callable<String>{

    int s;

    public MyDemoCall(int s) {
        this.s = s;
    }

    @Override
    public String call() throws Exception {
        System.out.println("working on a thread - " + Thread.currentThread().getName());
        Thread.sleep(s);
        return Thread.currentThread().getName();
    }
}
