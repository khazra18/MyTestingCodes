package java8;

import data.Customer;
import data.DemoData;

import java.util.function.Supplier;

public class Java8SupplierExample {

    public static void main(String[] args) {

        DemoData data = new DemoData();
        supplierExample(data.getCustomerList().get(0));

    }

    private static void supplierExample(Customer data){

        Supplier<Integer> mySupplier = data::getTier;
        System.out.println(mySupplier.get());

    }

}
