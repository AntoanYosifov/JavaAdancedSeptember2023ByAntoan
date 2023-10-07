package bg.softUni.advanced.definingClasses_Exercises.companyRoster_02;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Department> departmentMap = new HashMap<>();
        fillDepartmentMap(departmentMap, scanner, n);
        Department highestAvgSalDep = getHighestAvgDep(departmentMap);
        highestAvgSalDep.sortEmployeesDescendingOrder();

        System.out.println("Highest Average Salary: " + highestAvgSalDep);

    }

    private static void fillDepartmentMap(Map<String, Department> departmentMap, Scanner scanner, int n) {
        for (int i = 0; i < n; i++) {
            String[] employeeData = scanner.nextLine().split("\\s+");

            String employeeName = employeeData[0];
            double employeeSalary = Double.parseDouble(employeeData[1]);
            String employeePosition = employeeData[2];
            String employeeDepartment = employeeData[3];
            String employeeEmail = "";
            int employeeAge = 0;

            if (employeeData.length < 5) {

                employeeEmail = "n/a";
                employeeAge = -1;


            } else if (employeeData.length == 5) {
                String emailOrAge = employeeData[4];
                if (emailOrAge.matches("\\d+")) {
                    employeeAge = Integer.parseInt(emailOrAge);
                    employeeEmail = "n/a";
                } else {
                    employeeEmail = emailOrAge;
                    employeeAge = -1;
                }
            } else {
                employeeEmail = employeeData[4];
                employeeAge = Integer.parseInt(employeeData[5]);
            }
            Employee employee = new Employee(employeeName, employeeSalary,
                    employeePosition, employeeDepartment, employeeEmail, employeeAge);


            departmentMap.putIfAbsent(employeeDepartment, new Department(employeeDepartment));

            Department currentDepartment = departmentMap.get(employeeDepartment);
            currentDepartment.addEmployee(employee);

        }
    }

    public static Department getHighestAvgDep(Map<String, Department> departmentMap) {
        String nameOfHighestAvgDep = "";
        double highestAvgSalary = -1.0;
        for (Map.Entry<String, Department> department : departmentMap.entrySet()) {
            double currentAvgSalary = department.getValue().getAverageSalary();
            if (currentAvgSalary > highestAvgSalary) {
                highestAvgSalary = currentAvgSalary;
                nameOfHighestAvgDep = department.getKey();
            }
        }
        return departmentMap.get(nameOfHighestAvgDep);
    }
}
