package hw23_lists.company.classes;

import hw23_lists.company.interfaces.IEmployee;

import java.util.*;

public class Company {
    private final String companyName;
    private final List<IEmployee> employees = new ArrayList<>();
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

    public IEmployee getEmployeeByIndex(int index) {
        return employees.get(index);
    }

    public String hire(IEmployee employee) {
        String error = "";
        if (employees.contains(employee)) {
            error = "Сотрудник " + employee + " уже устроен в данной компании";
        }
        employees.add(employee);
        return error;
    }

    public List<String> hireAll(Collection<IEmployee> employeeList) {
        List<String> errors = new ArrayList<>();
        String error;
        for (IEmployee employee : employeeList) {
            error = hire(employee);
            if (!error.isEmpty()) {
                errors.add(error);
            }
        }
        return errors;
    }

    public String fire(IEmployee employee) {
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

    public List<IEmployee> getTopSalaryStaff(int count) {
        Set<IEmployee> employeeSet = new TreeSet<>(employees).reversed();
        if (count > employees.size()) {
            return (List<IEmployee>) employeeSet;
        } else {
            List<IEmployee> resultList = new ArrayList<>();
            Iterator<IEmployee> it = employeeSet.iterator();
            for (int i = 0; i < count; i++) {
                resultList.add(it.next());
            }
            return resultList;
        }
    }

    public List<IEmployee> getLowestSalaryStaff(int count) {
        Set<IEmployee> employeeSet = new TreeSet<>(employees);
        if (count > employees.size()) {
            return (List<IEmployee>) employeeSet;
        } else {
            List<IEmployee> resultList = new ArrayList<>();
            Iterator<IEmployee> it = employeeSet.iterator();
            for (int i = 0; i < count; i++) {
                resultList.add(it.next());
            }
            return resultList;
        }
    }
}

