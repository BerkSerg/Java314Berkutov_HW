package hw23_lists.company;

import hw23_lists.company.abstractclasses.Employee;
import hw23_lists.company.classes.Company;
import hw23_lists.company.classes.Manager;
import hw23_lists.company.classes.Operator;
import hw23_lists.company.classes.TopManager;

import java.text.DecimalFormat;
import java.util.*;


/** TODO
 * Создайте класс компании Company, содержащей сотрудников и реализующей методы:
 * •	найм одного сотрудника — hire(Employee employee),
 * •	найм списка сотрудников – hireAll(Collection<Employee> employes),
 * •	увольнение сотрудника – fire(Employee employee),
 * •	получение значения дохода компании – getIncome().
 *
 *
 *   Доход компании - рандомный, поэтому топ-менеджеры могут остаться без бонуса при разных запусках
 *
 */
public class Main {
    private final static Random rnd = new Random();
    public static final DecimalFormat df = new DecimalFormat("#,###,###,##0.00");

    public static void main(String[] args) {
        Company company = new Company("Drink & go");
        initCompany(company);

        System.out.println();
        System.out.println("Список самых высоких зарплат(убывание):");
        System.out.println(company.getTopSalaryStaff(15));

        System.out.println();
        System.out.println("Список самых низких зарплат(возрастание):");
        System.out.println(company.getLowestSalaryStaff(20));

        System.out.println();
        System.out.println("Сокращение 50% персонала, рандом");

        System.out.println("Количество персонала до сокращения: " + company.getEmployeesCount());
        int employeeToFireCount = company.getEmployeesCount() / 2;
        for(int i = 0; i < employeeToFireCount; i++){
            company.fire(company.getEmployeeByIndex(rnd.nextInt(0, company.getEmployeesCount())));
        }
        System.out.println("Количество персонала после сокращения: " + company.getEmployeesCount());

        System.out.println();
        System.out.println("Список самых высоких зарплат(убывание):");
        System.out.println(company.getTopSalaryStaff(15));

        System.out.println();
        System.out.println("Список самых низких зарплат(возрастание):");
        System.out.println(company.getLowestSalaryStaff(20));

    }

    private static void initCompany(Company company) {
        String error;

        System.out.println("==================");
        System.out.println(company.getCompanyName());

        company.setIncome(rnd.nextInt(900, 1100) * 10000);
        System.out.println("Доход компании: " + df.format(company.getIncome()));
        System.out.println("==================");

        // hire operators
        for (int i = 0; i < 180; i++) {
            error = company.hire(new Operator(rnd.nextInt(500, 700) * 100));
            if (!error.isEmpty()) {
                System.out.println(error);
            }
        }

        // hire managers with hireAll
        List<Employee> managersToHire = new ArrayList<>();
        for (int i = 0; i < 80; i++) {
            managersToHire.add(new Manager(rnd.nextInt(700, 1300) * 100, rnd.nextInt(115, 140) * 1000));
        }
        List<String> errors = company.hireAll(managersToHire);
        for(String err : errors){
            System.out.println(err);
        }

        //hire top managers
        for (int i = 0; i < 10; i++) {
            error = company.hire(new TopManager(rnd.nextInt(1200, 1500) * 100, company));
            if (!error.isEmpty()) {
                System.out.println(error);
            }
        }
    }
}
