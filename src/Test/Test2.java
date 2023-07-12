package Test;

import java.util.*;
import java.util.stream.Collectors;

public class Test2 {

    public static void main(String[] args) {

        List<DemoEmp> empList = new ArrayList<>();
        empList.add(new DemoEmp("A", 10000));
        empList.add(new DemoEmp("A", 15000));
        empList.add(new DemoEmp("A", 20000));
        empList.add(new DemoEmp("A", 24000));
        empList.add(new DemoEmp("A", 25000));

        empList.stream().sorted(Comparator.comparing(DemoEmp::getSalary).reversed()).skip(1).limit(1)
                .collect(Collectors.toList()).forEach(System.out::println);


        List<String> stringList = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i"));
        List<String> tempList = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {

            if (i % 2 == 0)
                tempList.add(stringList.get(i));

        }
        System.out.println(tempList);
    }

}

class DemoEmp {

    private String name;
    private int salary;

    public DemoEmp() {
    }

    public DemoEmp(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "DemoEmp{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
