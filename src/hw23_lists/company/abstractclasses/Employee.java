package hw23_lists.company.abstractclasses;

import hw23_lists.company.interfaces.IEmployee;

public abstract class Employee implements IEmployee, Comparable<IEmployee> {
    protected double salary;

    @Override
    public int compareTo(IEmployee o) {
        double delta = this.getMonthSalary() - o.getMonthSalary();
        if(delta > 0){
            return 1;
        } else if (delta < 0){
            return -1;
        }
        return 0;
    }
}
