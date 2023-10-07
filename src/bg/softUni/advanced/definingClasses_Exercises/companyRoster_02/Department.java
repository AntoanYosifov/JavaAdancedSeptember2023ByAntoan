package bg.softUni.advanced.definingClasses_Exercises.companyRoster_02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Department {
    private String name;

    private List<Employee> employees;

    public Department() {
        this.employees = new ArrayList<>();
    }

    public Department(String name) {
        this();

        this.name = name;
    }

    public double getAverageSalary() {
        double totalSalary = 0.0;
        for (Employee employee : this.employees) {
            totalSalary += employee.getSalary();
        }
        return totalSalary / this.employees.size();
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void sortEmployeesDescendingOrder() {
        this.employees = this.employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).collect(Collectors.toList());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(System.lineSeparator());

        for (Employee employee : employees) {
            sb.append(employee.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
