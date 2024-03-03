package hw23_lists.company.classes;

import hw23_lists.company.abstractclasses.Employee;

import static hw23_lists.company.Main.df;

public class Operator extends Employee {
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
