package Test;

import com.sun.org.apache.xpath.internal.operations.Or;
import data.Customer;
import data.DemoData;
import data.Order;
import data.Product;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Java8CodingExamples1 {

    public static void main(String[] args) {

        DemoData data = new DemoData();
        List<Product> productList = new ArrayList<>(data.getProductList());
        List<Customer> customerList = new ArrayList<>(data.getCustomerList());
        List<Order> orderList = new ArrayList<>(data.getOrdersList());

        System.out.println(" list of products belongs to category “Biscuit” with price > 15 ::::: " + findProductByCategoryAndPrice(productList));
        System.out.println(" list of products belongs to category “Drinks” ::::: " + findProductByCategoryDrinks(productList));
        System.out.println(" findProductByCategoryDrinksThenApplyDiscount ::::: " + findProductByCategoryDrinksThenApplyDiscount(productList));
        System.out.println(" list of products ordered by customer of tier 2 before 26 NOV 2022 ::::: " + findProductByCustomerTierAndOrderedDate(orderList));
        System.out.println(" Get the cheapest products of “Biscuit” category ::::: " + getLowestPriceForCategory(productList));

    }

    //Obtain a list of products belongs to category “Biscuit” with price > 10
    private static List<Product> findProductByCategoryAndPrice(List<Product> list) {

        return list.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("Biscuit"))
                .filter(product -> product.getPrice() > 15)
                .collect(Collectors.toList());
    }

    //list of order with products belong to category “Drinks”
    private static List<Product> findProductByCategoryDrinks(List<Product> list) {

        return list.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("Drinks"))
                .collect(Collectors.toList());
    }

    private static List<Product> findProductByCategoryDrinksThenApplyDiscount(List<Product> list) {

        return list.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("Drinks"))
                .peek(product -> {
                    double temp = product.getPrice();
                    temp = temp* 0.9;
                    product.setPrice(temp);
                })
                .collect(Collectors.toList());
    }

    //Obtain a list of products ordered by customer of tier 2 before 26 NOV
    private static List<Order> findProductByCustomerTierAndOrderedDate(List<Order> list) {

        return list.stream()
                .filter(order -> order.getCustomer().getTier() == 2)
                .filter(order -> order.getOrderDate().isAfter(LocalDate.parse("25/11/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy"))))
                .collect(Collectors.toList());
    }

    //Get the cheapest products of “Biscuit” category
    private static List<Product> getLowestPriceForCategory(List<Product> list) {

        return list.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("Biscuit"))
                .sorted(Comparator.comparing(Product::getPrice))
                .limit(1)
                .collect(Collectors.toList());
    }



}
