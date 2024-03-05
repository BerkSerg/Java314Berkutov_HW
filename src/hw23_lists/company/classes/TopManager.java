package hw23_lists.company.classes;

import hw23_lists.company.interfaces.IEmployee;

import static hw23_lists.company.Main.df;

public class TopManager implements IEmployee, Comparable<IEmployee> {
    private double salary;
    Company company;
    private final double personalBonus = 1.5;

    public TopManager(double salary, Company company) {
        this.salary = salary;
        this.company = company;
    }

    @Override
    public double getMonthSalary() {
        return (company.getIncome() < 10_000_000) ? salary : salary + (salary * personalBonus);
    }

    @Override
    public String toString() {
        if (company.getIncome() < 10_000_000) {
            return "Top manager { оклад: " + df.format(salary) + " }\n";
        } else {
            return "Top manager { оклад: " + df.format(salary) + " плюс бонус: " + df.format(salary * personalBonus) + " }\n";
        }
    }
}
