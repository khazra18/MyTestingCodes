package java8;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Java8OrderProductPractice {
    public static void main(String[] args) {

        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "krishanu"));
        userList.add(new User(2, "tirthankar"));
        userList.add(new User(3, "payel"));
        userList.add(new User(4, "suvodip"));

        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "biscuit", 1.5));
        productList.add(new Product(2, "maggie", 2));
        productList.add(new Product(3, "bhujia", 2.5));
        productList.add(new Product(4, "papad", 3));
        productList.add(new Product(5, "oil", 3.5));
        productList.add(new Product(6, "carrot", 4));
        productList.add(new Product(7, "cucumber", 4.5));
        productList.add(new Product(8, "bellpaper", 5.0));
        productList.add(new Product(9, "chilli", 5.5));

        List<Orders> ordersList = new ArrayList<>();
        ordersList.add(new Orders(1, 1, LocalDateTime.now()));
        ordersList.add(new Orders(2, 2, LocalDateTime.now()));
        ordersList.add(new Orders(3, 3, LocalDateTime.now()));
        ordersList.add(new Orders(4, 1, LocalDateTime.now()));
        ordersList.add(new Orders(5, 3, LocalDateTime.now()));
        ordersList.add(new Orders(6, 1, LocalDateTime.now()));

        List<OrdersProduct> ordersProductList = new ArrayList<>();
        ordersProductList.add(new OrdersProduct(1, 1));
        ordersProductList.add(new OrdersProduct(1, 2));
        ordersProductList.add(new OrdersProduct(1, 3));
        ordersProductList.add(new OrdersProduct(1, 4));
        ordersProductList.add(new OrdersProduct(2, 5));
        ordersProductList.add(new OrdersProduct(2, 6));
        ordersProductList.add(new OrdersProduct(2, 7));
        ordersProductList.add(new OrdersProduct(2, 1));
        ordersProductList.add(new OrdersProduct(2, 2));
        ordersProductList.add(new OrdersProduct(3, 6));
        ordersProductList.add(new OrdersProduct(3, 2));
        ordersProductList.add(new OrdersProduct(3, 7));
        ordersProductList.add(new OrdersProduct(3, 8));
        ordersProductList.add(new OrdersProduct(4, 1));
        ordersProductList.add(new OrdersProduct(4, 2));
        ordersProductList.add(new OrdersProduct(5, 5));
        ordersProductList.add(new OrdersProduct(5, 8));
        ordersProductList.add(new OrdersProduct(5, 2));
        ordersProductList.add(new OrdersProduct(5, 1));
        ordersProductList.add(new OrdersProduct(6, 6));
        ordersProductList.add(new OrdersProduct(6, 7));
        ordersProductList.add(new OrdersProduct(6, 8));
        ordersProductList.add(new OrdersProduct(6, 1));

        //Get all product names which was ordered by tirthankar
        //method1(userList,productList,ordersList,ordersProductList);

        //Find the names of all the products ordered in the ordersList.
        //method2(productList,ordersProductList);

        //Find the total number of products ordered in the ordersList.
        //method3(userList, productList, ordersList, ordersProductList);

        //Find the orders that contain the product with the name "maggie".
        //method4(userList, productList, ordersList, ordersProductList);

        //Find the total number of orders placed by each user in the userList.
        //method5(userList, productList, ordersList, ordersProductList);

        //list all the product names ordered in each order.
        //method6(userList, productList, ordersList, ordersProductList);

        //Find the most popular product (i.e., the product that has been ordered the most number of times).
        //method7(userList, productList, ordersList, ordersProductList);

        //Find the list of orders that have more than 3 products.
        //method8(userList, productList, ordersList, ordersProductList);

        //Find the user who has placed the maximum number of orders.
        //method9(userList, productList, ordersList, ordersProductList);

        //Find the users who have not placed any orders.
        //method10(userList, productList, ordersList, ordersProductList);

        //Get all the orders and product names ordered by all users into MyCustomClass
        //method11(userList, productList, ordersList, ordersProductList);

        //Get all the users name who have ordered more than 3 items in their orders
        //method12(userList, productList, ordersList, ordersProductList);

        //Get all the products which have been ordered by tirthankar and put it in mycustom class
        method13(userList, productList, ordersList, ordersProductList);

    }

    private static void method13(List<User> userList, List<Product> productList, List<Orders> ordersList, List<OrdersProduct> ordersProductList) {

        //Get all the products which have been ordered by tirthankar and put it in mycustom class

        String name = "payel";
        ordersList.stream().filter(ord -> userList.stream().anyMatch(u -> u.getName().equalsIgnoreCase(name) && u.getId() == ord.getUserId()))
                .map(orders -> {

                    OrderDTO orderDTO = new OrderDTO();
                    orderDTO.setUserName(name);
                    orderDTO.setOrderIds(Collections.singletonList(orders.getId()));
                    orderDTO.setProductNames(productList.stream()
                            .filter(p -> ordersProductList.stream().anyMatch(orp -> orp.getProductId() == p.getId() && orders.getId() == orp.getOrderId()))
                            .map(Product::getName).collect(Collectors.toList()));

                    return orderDTO;
                }).forEach(System.out::println);
    }

    private static void method12(List<User> userList, List<Product> productList, List<Orders> ordersList, List<OrdersProduct> ordersProductList) {

        //Get all the users name who have ordered more than 3 items in their orders
        List<Integer> collect = ordersProductList.stream()
                .collect(Collectors.groupingBy(OrdersProduct::getOrderId, Collectors.counting()))
                .entrySet().stream().filter(i -> i.getValue() > 3).map(Map.Entry::getKey).collect(Collectors.toList());


        userList.stream().filter(u -> ordersList.stream()
                        .anyMatch(o -> collect.stream().anyMatch(c -> c == o.getId() && u.getId() == o.getUserId())))
                .collect(Collectors.toList()).forEach(System.out::println);

    }

    private static void method11(List<User> userList, List<Product> productList, List<Orders> ordersList, List<OrdersProduct> ordersProductList) {

        //Get all the orders and product names ordered by all users into MyCustomClass
        List<MyCustomClass> result = ordersProductList.stream()
                // Group orders by user ID
                .collect(Collectors.groupingBy(op -> ordersList.stream()
                        .filter(o -> o.getId() == op.getOrderId())
                        .findFirst()
                        .orElseThrow(IllegalStateException::new)
                        .getUserId()))
                .entrySet().stream()
                // Convert grouped data into MyCustomClass instances
                .map(entry -> {
                    int userId = entry.getKey();
                    List<String> names = userList.stream()
                            .filter(user -> user.getId() == userId)
                            .map(User::getName)
                            .collect(Collectors.toList());

                    List<Integer> orderIds = entry.getValue().stream()
                            .map(OrdersProduct::getOrderId)
                            .distinct()
                            .collect(Collectors.toList());

                    List<String> productNames = entry.getValue().stream()
                            .map(op -> productList.stream()
                                    .filter(p -> p.getId() == op.getProductId())
                                    .findFirst()
                                    .orElseThrow(IllegalStateException::new)
                                    .getName())
                            .collect(Collectors.toList());

                    return new MyCustomClass(names, orderIds, productNames);
                })
                .collect(Collectors.toList());

    }


    private static void method10(List<User> userList, List<Product> productList, List<Orders> ordersList, List<OrdersProduct> ordersProductList) {

        //Find the users who have not placed any orders.
        List<User> collect = userList.stream()
                .filter(user -> ordersList.stream()
                        .noneMatch(orders -> orders.getUserId() == user.getId()))
                .collect(Collectors.toList());

        System.out.println(collect);
    }

    private static void method9(List<User> userList, List<Product> productList, List<Orders> ordersList, List<OrdersProduct> ordersProductList) {

        //Find the user who has placed the maximum number of orders.

        List<String> collect = userList.stream().filter(u -> u.getId() == ordersList.stream().collect(Collectors.groupingBy(Orders::getUserId, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey()).map(User::getName).collect(Collectors.toList());

        Integer value = ordersList.stream().collect(Collectors.groupingBy(Orders::getUserId, Collectors.counting()))
                .entrySet().stream().min(Map.Entry.comparingByValue()).get().getKey();
        System.out.println(collect);

    }

    private static void method8(List<User> userList, List<Product> productList, List<Orders> ordersList, List<OrdersProduct> ordersProductList) {

        //Find the list of orders that have more than 3 products.
        List<Map.Entry<Integer, Long>> collect = ordersProductList.stream().collect(Collectors.groupingBy(OrdersProduct::getOrderId, Collectors.counting()))
                .entrySet().stream().filter(i -> i.getValue() > 3).collect(Collectors.toList());

        System.out.println(collect);

    }

    static void method7(List<User> userList, List<Product> productList, List<Orders> ordersList, List<OrdersProduct> ordersProductList) {

        //Find the most popular product (i.e., the product that has been ordered the most number of times).
        Product product = ordersProductList
                .stream()
                .collect(Collectors.groupingBy(OrdersProduct::getProductId, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(i -> productList.get(i.getKey() - 1)).orElse(null);

        List<Product> collect = productList.stream().filter(p -> ordersProductList
                .stream()
                .collect(Collectors.groupingBy(OrdersProduct::getProductId, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey() == p.getId()).collect(Collectors.toList());


        System.out.println(collect);

    }

    static void method6(List<User> userList, List<Product> productList, List<Orders> ordersList, List<OrdersProduct> ordersProductList) {

        //list all the product names ordered in each order.
        Map<Integer, List<String>> myMap = ordersList
                .stream()
                .collect(Collectors.toMap(Orders::getId,
                        o -> productList
                                .stream()
                                .filter(p -> ordersProductList
                                        .stream()
                                        .anyMatch(orp -> orp.getProductId() == p.getId() && o.getId() == orp.getOrderId()))
                                .map(Product::getName)
                                .collect(Collectors.toList())));

        myMap.forEach((integer, products) -> System.out.println(integer + " - " + products));


    }

    static void method5(List<User> userList, List<Product> productList, List<Orders> ordersList, List<OrdersProduct> ordersProductList) {

        //Find the total number of orders placed by each user in the userList.
        Map<String, List<Orders>> myMap = userList
                .stream()
                .collect(Collectors.toMap(User::getName, user -> ordersList.stream().filter(o -> o.getUserId() == user.getId()).collect(Collectors.toList())));

        myMap.forEach((s, aLong) -> System.out.println(s + " - " + aLong));

    }

    static void method4(List<User> userList, List<Product> productList, List<Orders> ordersList, List<OrdersProduct> ordersProductList) {

        //Find the orders that contain the product with the name "maggie".
        Consumer<Orders> myConsumer = orders -> {
            System.out.println(orders.getId() + " " + orders.getUserId());
        };

        ordersList
                .stream()
                .filter(o -> ordersProductList
                        .stream()
                        .anyMatch(orp -> productList
                                .stream()
                                .anyMatch(p -> p.getName().equalsIgnoreCase("maggie")
                                        && p.getId() == orp.getProductId() && orp.getOrderId() == o.getId())))
                .forEach(myConsumer);

    }

    static void method3(List<User> userList, List<Product> productList, List<Orders> ordersList, List<OrdersProduct> ordersProductList) {

        //Find the total number of products ordered in the ordersList.
        long count = productList
                .stream()
                .filter(p -> ordersProductList
                        .stream()
                        .anyMatch(o -> o.getProductId() == p.getId()))
                .count();
        System.out.println("Total distinct product ordered : " + count);

        //Find the total number of products ordered in the ordersList with product names.
        Map<String, Long> collect = ordersProductList.stream().collect(Collectors.groupingBy(ordersProduct -> productList.stream()
                .filter(product -> product.getId() == ordersProduct.getProductId())
                .map(Product::getName)
                .findFirst().orElse(null), Collectors.counting()));

        collect.entrySet().forEach(System.out::println);


    }

    static void method2(List<Product> productList, List<OrdersProduct> ordersProductList) {

        //Find the names of all the products ordered in the ordersList.
        Consumer<Product> myConsumer = product -> {
            System.out.println(product.getId() + " " + product.getName());
        };

        productList
                .stream()
                .filter(p -> ordersProductList
                        .stream()
                        .anyMatch(o -> o.getProductId() == p.getId()))
                .forEach(myConsumer);

    }

    static void method1(List<User> userList, List<Product> productList, List<Orders> ordersList, List<OrdersProduct> ordersProductList) {

        //Get all product names which was ordered by tirthankar
        Consumer<Product> myConsumer = product -> {
            System.out.println(product.getId() + " " + product.getName());
        };

        productList
                .stream()
                .filter(p -> ordersProductList
                        .stream()
                        .anyMatch(o -> ordersList
                                .stream()
                                .anyMatch(ord -> userList
                                        .stream()
                                        .anyMatch(u -> u.getId() == 2
                                                && u.getId() == ord.getUserId()
                                                && ord.getId() == o.getOrderId()
                                                && o.getProductId() == p.getId())))).forEach(myConsumer);

    }

}


class User {

    int id;
    String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class Product {

    int id;
    String name;

    double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

class Orders {

    int id;
    int userId;
    LocalDateTime dateTime;

    public Orders(int id, int userId, LocalDateTime dateTime) {
        this.id = id;
        this.userId = userId;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", userId=" + userId +
                ", dateTime=" + dateTime +
                '}';
    }
}

class OrdersProduct {

    int orderId;
    int productId;

    public OrdersProduct(int orderId, int productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "OrdersProduct{" +
                "orderId=" + orderId +
                ", productId=" + productId +
                '}';
    }
}

class MyCustomClass {

    List<String> names;
    List<Integer> orderIds;
    List<String> productNames;

    public MyCustomClass(List<String> names, List<Integer> orderIds, List<String> productNames) {
        this.names = names;
        this.orderIds = orderIds;
        this.productNames = productNames;
    }

    public MyCustomClass() {
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<Integer> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<Integer> orderIds) {
        this.orderIds = orderIds;
    }

    public List<String> getProductNames() {
        return productNames;
    }

    public void setProductNames(List<String> productNames) {
        this.productNames = productNames;
    }

    @Override
    public String toString() {
        return "MyCustomClass{" +
                "names=" + names +
                ", orderIds=" + orderIds +
                ", productNames=" + productNames +
                '}';
    }
}

class OrderDTO {

    String userName;
    List<Integer> orderIds;
    List<String> productNames;

    public OrderDTO() {
    }

    public OrderDTO(String userName, List<Integer> orderIds, List<String> productNames) {
        this.userName = userName;
        this.orderIds = orderIds;
        this.productNames = productNames;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Integer> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<Integer> orderIds) {
        this.orderIds = orderIds;
    }

    public List<String> getProductNames() {
        return productNames;
    }

    public void setProductNames(List<String> productNames) {
        this.productNames = productNames;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "userName='" + userName + '\'' +
                ", orderIds=" + orderIds +
                ", productNames=" + productNames +
                '}';
    }
}