package hw23_lists.company.classes;

import hw23_lists.company.abstractclasses.Employee;

import static hw23_lists.company.Main.df;

public class Manager extends Employee {
    private double incomeForCompany;
    private double personalBonus = 5;

    public Manager(double salary, double incomeForCompany) {
        this.salary = salary;
        this.incomeForCompany = incomeForCompany;
    }

    @Override
    public double getMonthSalary() {
        return salary + ((incomeForCompany / 100) * personalBonus);
    }

    @Override
    public String toString() {
        return "Manager { оклад: " + df.format(salary) + " плюс бонус: " + df.format(((incomeForCompany / 100) * personalBonus)) + " }\n";
    }
}
