package hw23_lists.company.classes;

import hw23_lists.company.interfaces.IEmployee;

import static hw23_lists.company.Main.df;

public class Operator implements IEmployee, Comparable<IEmployee> {
    protected double salary;
    public Operator(double salary) {
        this.salary = salary;
    }

    @Override
    public double getMonthSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Operator { оклад: " + df.format(salary) + " }\n";
    }
}
