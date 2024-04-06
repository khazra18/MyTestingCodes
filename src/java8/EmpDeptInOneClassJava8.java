package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmpDeptInOneClassJava8 {

    public static void main(String[] args) {

        List<Employee1> employeeList = new ArrayList<>();
        employeeList.add(new Employee1(1,"krishanu",10000));
        employeeList.add(new Employee1(2,"killer",12000));
        employeeList.add(new Employee1(3,"lycan",8000));
        employeeList.add(new Employee1(4,"zshock",14000));
        employeeList.add(new Employee1(5,"khoka",5000));


        List<Department> departmentList = new ArrayList<>();
        departmentList.add(new Department(1,1,"IT"));
        departmentList.add(new Department(1,2,"IT"));
        departmentList.add(new Department(1,3,"IT"));
        departmentList.add(new Department(2,4,"HR"));
        departmentList.add(new Department(2,5,"HR"));


        departmentList.stream().collect(Collectors.groupingBy(Department::getDeptId))
                .values()
                .stream()
                .map(departments -> {

                    EmpInEachDept empInEachDept = new EmpInEachDept();
                    empInEachDept.setDeptId(departments.get(0).getDeptId());
                    empInEachDept.setDeptName(departments.get(0).getDeptName());

                    List<Employee1> collect = employeeList.stream().filter(employee -> departments.stream()
                            .anyMatch(department -> employee.getEmpId() == department.getEmpId())).collect(Collectors.toList());

                    empInEachDept.setEmployeeList(collect);
                    return empInEachDept;
                }).collect(Collectors.toList()).forEach(System.out::println);

    }

}

class EmpInEachDept{
    private int deptId;
    private String deptName;
    private List<Employee1> employeeList;

    @Override
    public String toString() {
        return "EmpInEachDept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Employee1> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee1> employeeList) {
        this.employeeList = employeeList;
    }

    public EmpInEachDept() {
    }

    public EmpInEachDept(int deptId, String deptName, List<Employee1> employeeList) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.employeeList = employeeList;
    }
}

class Department{

    private int deptId;
    private int empId;
    private String deptName;

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", empId=" + empId +
                ", deptName='" + deptName + '\'' +
                '}';
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Department() {
    }

    public Department(int deptId, int empId, String deptName) {
        this.deptId = deptId;
        this.empId = empId;
        this.deptName = deptName;
    }
}

class Employee1 {

    private int empId;
    private String empName;
    private long salary;

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", salary=" + salary +
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

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Employee1() {
    }

    public Employee1(int empId, String empName, long salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }
}