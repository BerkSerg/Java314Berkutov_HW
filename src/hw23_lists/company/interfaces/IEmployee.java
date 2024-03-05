package hw23_lists.company.interfaces;

public interface IEmployee extends Comparable<IEmployee>{
    double getMonthSalary();

    @Override
    default int compareTo(IEmployee o) {
        double delta = this.getMonthSalary() - o.getMonthSalary();
        if(delta > 0){
            return 1;
        } else if (delta < 0){
            return -1;
        }
        return 0;
    }
}
