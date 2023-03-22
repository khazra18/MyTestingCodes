package java8;

import java.util.function.*;
import java.util.stream.IntStream;

public class Java8PredefinedFuncInterfaceExamples {

    public static void main(String[] args) {

        //Predicate interface
        Predicate<Employee> myPredicate = e -> e.getName().equalsIgnoreCase("krishanu");
        System.out.println(myPredicate.test(new Employee(111, "krishanu", 32, "Female", "HR", 2011, 25000.0)));

        //Function interface
        Function<Employee,Integer> myFunction = Employee::getAge;
        System.out.println(myFunction.apply(new Employee(111, "krishanu", 32, "Female", "HR", 2011, 25000.0)));

        //Consumer Interface
        Consumer<Employee> myConsumer = System.out::println;
        myConsumer.accept(new Employee(111, "krishanu", 32, "Female", "HR", 2011, 25000.0));

        //Supplier Interface
        Supplier<Integer> mySupplier = () -> 1;
        System.out.println(mySupplier.get());

        //BiConsumer example
        BiConsumer<Integer,Integer> myBiConsumer = (a,b) -> System.out.println(a+b);
        myBiConsumer.accept(1,2);

        //BiPredicate Interface
        BiPredicate<Integer, String> biPredicate = (n, s) -> n == Integer.parseInt(s);
        System.out.println(biPredicate.test(2, "2"));

        //BiFunction Interface
        BiFunction<Integer, Integer, Integer> add = Integer::sum;
        System.out.println(add.apply(2, 3));

    }

}
