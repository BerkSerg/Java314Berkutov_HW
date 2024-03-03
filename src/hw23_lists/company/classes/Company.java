package hw23_lists.company.classes;

import hw23_lists.company.abstractclasses.Employee;

import java.util.*;

public class Company {
    private final String companyName;
    private final List<Employee> employees = new ArrayList<>();
    private double income;

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public int getEmployeesCount() {
        return employees.size();
    }

    public Employee getEmployeeByIndex(int index) {
        return employees.get(index);
    }

    public String hire(Employee employee) {
        String error = "";
        if (employees.contains(employee)) {
            error = "Сотрудник " + employee + " уже устроен в данной компании";
        }
        employees.add(employee);
        return error;
    }

    public List<String> hireAll(Collection<Employee> employeeList) {
        List<String> errors = new ArrayList<>();
        String error;
        for (Employee employee : employeeList) {
            error = hire(employee);
            if (!error.isEmpty()) {
                errors.add(error);
            }
        }
        return errors;
    }

    public String fire(Employee employee) {
        String error = "";
        if (!employees.contains(employee)) {
            error = "Сотрудник " + employee + " не работает в данной компании";
        }else {
            employees.remove(employee);
        }
        return error;
    }

    public double getIncome() {
        return income;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        Set<Employee> employeeSet = new TreeSet<>(employees).reversed();
        if (count > employees.size()) {
            return (List<Employee>) employeeSet;
        } else {
            List<Employee> resultList = new ArrayList<>();
            Iterator<Employee> it = employeeSet.iterator();
            for (int i = 0; i < count; i++) {
                resultList.add(it.next());
            }
            return resultList;
        }
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        Set<Employee> employeeSet = new TreeSet<>(employees);
        if (count > employees.size()) {
            return (List<Employee>) employeeSet;
        } else {
            List<Employee> resultList = new ArrayList<>();
            Iterator<Employee> it = employeeSet.iterator();
            for (int i = 0; i < count; i++) {
                resultList.add(it.next());
            }
            return resultList;
        }
    }
}

