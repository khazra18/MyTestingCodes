package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test3 {

    public static void main(String[] args) {

        List<AllUserOrderProductDetails> myList = new ArrayList<>();
        myList.add(new AllUserOrderProductDetails(1,1,1,1,"biscuit",10.0));
        myList.add(new AllUserOrderProductDetails(2,1,2,2,"biscuit2",15.0));
        myList.add(new AllUserOrderProductDetails(3,2,3,1,"biscui1",20.0));
        myList.add(new AllUserOrderProductDetails(4,2,4,1,"biscui1",25.0));
        myList.add(new AllUserOrderProductDetails(5,3,5,2,"biscui2",30.0));
        myList.add(new AllUserOrderProductDetails(6,4,6,3,"biscui3",35.0));
        myList.add(new AllUserOrderProductDetails(7,4,7,4,"biscui4",40.0));





    }




}

class AllUserOrderProductStructured{

    int id;
    int userId;
    int OrderId;
    List<Integer> productId;
    List< String> productNames;
    List<Double> productPrice;

    public AllUserOrderProductStructured() {
    }

    public AllUserOrderProductStructured(int id, int userId, int orderId, List<Integer> productId, List<String> productNames, List<Double> productPrice) {
        this.id = id;
        this.userId = userId;
        OrderId = orderId;
        this.productId = productId;
        this.productNames = productNames;
        this.productPrice = productPrice;
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

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public List<Integer> getProductId() {
        return productId;
    }

    public void setProductId(List<Integer> productId) {
        this.productId = productId;
    }

    public List<String> getProductNames() {
        return productNames;
    }

    public void setProductNames(List<String> productNames) {
        this.productNames = productNames;
    }

    public List<Double> getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(List<Double> productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "AllUserOrderProductStructured{" +
                "id=" + id +
                ", userId=" + userId +
                ", OrderId=" + OrderId +
                ", productId=" + productId +
                ", productNames=" + productNames +
                ", productPrice=" + productPrice +
                '}';
    }
}

class AllUserOrderProductDetails{

    int id;
    int userId;
    int OrderId;
    int productId;
    String productNames;
    Double productPrice;

    public AllUserOrderProductDetails() {
    }

    public AllUserOrderProductDetails(int id, int userId, int orderId, int productId, String productNames, Double productPrice) {
        this.id = id;
        this.userId = userId;
        this.OrderId = orderId;
        this.productId = productId;
        this.productNames = productNames;
        this.productPrice = productPrice;
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

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductNames() {
        return productNames;
    }

    public void setProductNames(String productNames) {
        this.productNames = productNames;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "AllUserOrderProductDetails{" +
                "id=" + id +
                ", userId=" + userId +
                ", OrderId=" + OrderId +
                ", productId=" + productId +
                ", productNames='" + productNames + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
