package data;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DemoData {

    public List<Product> getProductList(){

        List<Product> myList = new ArrayList<>();
        Product product1 = new Product(1,"Britannia good day","Biscuit",15);
        Product product2 = new Product(2,"Sunfeast Digestive","Biscuit",20);
        Product product3 = new Product(3,"Sprite","Drinks",85);
        Product product4 = new Product(4,"Amul gold","Dairy",32);

        myList.add(product1);
        myList.add(product2);
        myList.add(product3);
        myList.add(product4);

        return myList;
    }

    public List<Customer> getCustomerList(){

        List<Customer> customerList = new ArrayList<>();
        Customer customer1 = new Customer(1,"Krishanu",1);
        Customer customer2 = new Customer(2,"Tirthankar",2);
        Customer customer3 = new Customer(3,"Suvodip",3);

        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);

        return customerList;
    }

    public List<Order> getOrdersList(){

        List<Order> orderList = new ArrayList<>();

        List<Customer> customerList = new ArrayList<>(getCustomerList());
        List<Product> productList = new ArrayList<>(getProductList());

        Order order1 = new Order();
        order1.setId(1);
        order1.setStatus("Not Delivered");
        order1.setOrderDate(LocalDate.parse("25/11/2022",DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        order1.setDeliveryDate(LocalDate.parse("30/11/2022",DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        order1.setCustomer(customerList.get(0));

        List<Product> orderedProduct1 = new ArrayList<>();
        orderedProduct1.add(productList.get(0));
        orderedProduct1.add(productList.get(2));

        order1.setOrderedProducts(orderedProduct1);


        Order order2 = new Order();
        order2.setId(2);
        order2.setStatus("Delivered");
        order2.setOrderDate(LocalDate.parse("26/11/2022",DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        order2.setDeliveryDate(LocalDate.parse("28/11/2022",DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        order2.setCustomer(customerList.get(1));

        List<Product> orderedProduct2 = new ArrayList<>();
        orderedProduct2.add(productList.get(1));
        orderedProduct2.add(productList.get(2));
        orderedProduct2.add(productList.get(3));

        order2.setOrderedProducts(orderedProduct2);

        orderList.add(order1);
        orderList.add(order2);

        return orderList;

    }

}
