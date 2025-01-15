package Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {

    private static List<Employee> employeeList1 = new ArrayList<>();

    public static void main(String[] args) {

        employeeList1.add(new Employee(1,"aaa","cs","080"));
        employeeList1.add(new Employee(2,"bbb","it","002"));
        employeeList1.add(new Employee(1,"aaa","cs","090"));
        employeeList1.add(new Employee(2,"bbb","del","040"));
        employeeList1.add(new Employee(3,"ccc","test","001"));

        List<Emp> emps = employeeList1.stream()
                .collect(Collectors.groupingBy(Employee::getEmp_id))
                .entrySet().stream()
                .map(entry -> {
                    Integer id = entry.getKey();
                    List<Employee> groupData = entry.getValue();
                    String name = groupData.get(0).getName();
                    List<String> dept = groupData.stream().map(Employee::getDept)
                            .collect(Collectors.toList());
                    List<String> phone = groupData.stream().map(Employee::getPhone)
                            .collect(Collectors.toList());
                    Emp emp = new Emp();
                    emp.setId(id);
                    emp.setName(name);
                    emp.setDept(dept);
                    emp.setPhone(phone);
                    return emp;
                })
                .collect(Collectors.toList());

        System.out.println(emps);

        //System.out.println(myMap);

        Map<Integer, Set<String>> groupByGenderAndFirstNameSet
                = employeeList1.stream().collect(Collectors.groupingBy(Employee::getEmp_id,
                Collectors.mapping(Employee::getDept, Collectors.toSet())));

        System.out.println(groupByGenderAndFirstNameSet);



        /*Map<Integer, Employee> grouped = employeeList1.stream()
                .collect(Collectors.groupingBy(Employee::getEmp_id,
                        Collectors.collectingAndThen(
                                Collectors.reducing((e1, e2) -> new Employee(
                                        e1.getEmp_id(),
                                        e1.getName(),
                                        Stream.concat(Stream.of(e1.getDept()), Stream.of(e2.getDept()))
                                                .distinct()
                                                .toArray(String[]::new),
                                        Stream.concat(Stream.of(e1.getPhone()), Stream.of(e2.getPhone()))
                                                .distinct()
                                                .toArray(String[]::new))),
                                Optional::get)));*/

    }

}

class Emp{

    private int id;
    private String name;
    List<String> dept;
    List<String> phone;

    public Emp(int id, String name, List<String> dept, List<String> phone) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.phone = phone;
    }

    public Emp() {
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

    public List<String> getDept() {
        return dept;
    }

    public void setDept(List<String> dept) {
        this.dept = dept;
    }

    public List<String> getPhone() {
        return phone;
    }

    public void setPhone(List<String> phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept=" + dept +
                ", phone=" + phone +
                '}';
    }
}

class Employee{

    private int emp_id;
    private String name;
    private String dept;
    private String phone;

    public Employee() {
    }

    public Employee(int emp_id, String name, String dept, String phone) {
        this.emp_id = emp_id;
        this.name = name;
        this.dept = dept;
        this.phone = phone;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}