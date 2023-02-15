package java8;

import data.Customer;
import data.DemoData;

import java.util.function.Consumer;

public class Java8ConsumerExamples {

    public static void main(String[] args) {
        DemoData data = new DemoData();
        consumerExample(data.getCustomerList().get(0));
    }

    private static void consumerExample(Customer customer){

        Consumer<Customer> myConsumer = System.out::println;
        myConsumer.accept(customer);

    }

}
