package java8;

import java.util.ArrayList;
import java.util.List;

public class Java8PeekExample {

    public static void main(String[] args) {

        List<Address> addressList = new ArrayList<>();
        addressList.add(new Address(350,"jessore road","700055"));
        addressList.add(new Address(351,"jessore road 1","700056"));
        addressList.add(new Address(352,"jessore road 2","700057"));
        addressList.add(new Address(353,"jessore road 3","700058"));

        addressList.stream().peek(address -> address.setStreetName(address.getStreetName() + " Hazra para"))
                .forEach(System.out::println);

    }

}

class Address{

    private int flatNumber;
    private String streetName;
    private String pinCode;

    public Address() {
    }

    public Address(int flatNumber, String streetName, String pinCode) {
        this.flatNumber = flatNumber;
        this.streetName = streetName;
        this.pinCode = pinCode;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "flatNumber=" + flatNumber +
                ", streetName='" + streetName + '\'' +
                ", pinCode='" + pinCode + '\'' +
                '}';
    }
}