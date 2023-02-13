package examples;

public class ImmutableDemo {

    public static void main(String[] args) {

        Address address1 = new Address("jessore road",700055);
        Address address2 = new Address("jessore road1",700056);

        Employee employee1 = new Employee(1,"krishanu",address1);
        Employee employee2 = new Employee(2,"krishanu1",address2);

        System.out.println("Employee 1 : " + employee1);
        System.out.println("Employee 2 : " + employee2);

        address1.setZipCode(700000);
        address2.setZipCode(700001);

        System.out.println("Employee 1 : " + employee1);
        System.out.println("Employee 2 : " + employee2);


    }

}

final class Employee{

    private final int id;
    private final String name;
    private final Address address;

    public Employee(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}

class Address{

    private String streetName;
    private long zipCode;

    public Address(String streetName, long zipCode) {
        this.streetName = streetName;
        this.zipCode = zipCode;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setZipCode(long zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public long getZipCode() {
        return zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}