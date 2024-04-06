package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeWithMultiplePhoneAndDept{

    public static void main(String[] args) {

        List<EmployeeNew> employeeList = new ArrayList<>();
        employeeList.add(new EmployeeNew(1,"krishanu","IT","12345"));
        employeeList.add(new EmployeeNew(2,"tirthankar","HR","12445"));
        employeeList.add(new EmployeeNew(3,"killer","BPO","12234"));
        employeeList.add(new EmployeeNew(4,"lycan","IT","11145"));
        employeeList.add(new EmployeeNew(5,"khoka","HR","14323"));
        employeeList.add(new EmployeeNew(1,"krishanu","BPO","12345"));
        employeeList.add(new EmployeeNew(2,"tirthankar","IT","124456"));

        employeeList.stream().collect(Collectors.groupingBy(EmployeeNew::getEmpId))
                .values()
                .stream()
                .map(employees -> {
                    EmployeeUpdated employeeUpdated = new EmployeeUpdated();
                    employeeUpdated.setEmpId(employees.get(0).getEmpId());
                    employeeUpdated.setEmpName(employees.get(0).getEmpName());
                    List<String> phoneNumberList = employees.stream().map(EmployeeNew::getPhoneNumber).distinct().collect(Collectors.toList());
                    List<String> deptList = employees.stream().map(EmployeeNew::getDept).distinct().collect(Collectors.toList());
                    employeeUpdated.setDeptList(deptList);
                    employeeUpdated.setPhoneNumberList(phoneNumberList);
                    return employeeUpdated;
                }).forEach(System.out::println);

        /*List<EmployeeUpdated> employeeUpdatedList = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getEmpId))
                .values().stream()
                .map(employeeGroup -> {
                    EmployeeUpdated employeeUpdated = new EmployeeUpdated();
                    employeeUpdated.setEmpId(employeeGroup.get(0).getEmpId());
                    employeeUpdated.setEmpName(employeeGroup.get(0).getEmpName());
                    List<String> deptList = employeeGroup.stream().map(Employee::getDept).collect(Collectors.toList());
                    List<String> phoneList = employeeGroup.stream().map(Employee::getPhoneNumber).collect(Collectors.toList());
                    employeeUpdated.setDeptList(deptList);
                    employeeUpdated.setPhoneNumberList(phoneList);
                    return employeeUpdated;
                })
                .collect(Collectors.toList());

        System.out.println(employeeUpdatedList);*/

    }
}

class EmployeeUpdated{

    private int empId;
    private String empName;
    private List<String> deptList;
    private List<String> phoneNumberList;

    @Override
    public String toString() {
        return "EmployeeUpdated{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", deptList=" + deptList +
                ", phoneNumberList=" + phoneNumberList +
                '}';
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public List<String> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<String> deptList) {
        this.deptList = deptList;
    }

    public List<String> getPhoneNumberList() {
        return phoneNumberList;
    }

    public void setPhoneNumberList(List<String> phoneNumberList) {
        this.phoneNumberList = phoneNumberList;
    }

    public EmployeeUpdated() {
    }

    public EmployeeUpdated(int empId, String empName, List<String> deptList, List<String> phoneNumberList) {
        this.empId = empId;
        this.empName = empName;
        this.deptList = deptList;
        this.phoneNumberList = phoneNumberList;
    }
}

class EmployeeNew{

    private int empId;
    private String empName;
    private String dept;
    private String phoneNumber;

    public EmployeeNew() {
    }

    public EmployeeNew(int empId, String empName, String dept, String phoneNumber) {
        this.empId = empId;
        this.empName = empName;
        this.dept = dept;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", dept='" + dept + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}