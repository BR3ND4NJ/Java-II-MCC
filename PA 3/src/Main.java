import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


abstract class Employee implements Comparable<Employee> {
    private String name;
    private int id;
    private static int nextID = 0;
    private int year;

    public Employee(String name, int year) {
        this.name = name;
        this.year = year;
        id = nextID;
        nextID++;
    }
    public Employee() {
        this(null, 0);
        id = nextID;
    }
    public Employee(Employee o) {
        this(o.getName(), o.getYear());
        id = nextID;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public int getYear() {
        return year;
    }

    public String toString() {
        String s = String.format("Name: %s, id: %d, hire year: %d", name, id, year);
        return s;
    }
    public int compareTo(Employee o) {
        return this.getName().compareToIgnoreCase(o.getName());
    }

    public boolean equals(Employee o) {
        if (this.name.equals(o.name) && this.year == o.year) {
            return true;
        }
        else {
            return false;
        }
    }

    public abstract float getWeeklyCheckAmount();
}


abstract class HourlyWorker extends Employee {
    private float rate;
    private int hoursWorked;

    public void setRate(float rate) {
        this.rate = rate;
    }
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    public float getRate() {
        return rate;
    }
    public int getHoursWorked() {
        return hoursWorked;
    }

    public boolean equals(HourlyWorker o) {
        if (super.equals(o)) {
            if (this.rate == o.rate && this.hoursWorked == o.hoursWorked) {
                return true;
            }
        }
        return false;
    }
}


abstract class SalariedWorker extends Employee {
    private float salary;

    public void setSalary(float salary) {
        this.salary = salary;
    }
    public float getSalary() {
        return salary;
    }

    public boolean equals(SalariedWorker o) {
        if (super.equals(o)) {
            if (this.salary == o.salary) {
                return true;
            }
        }
        return false;
    }
}


class Secretary extends HourlyWorker {
    private float weeklyBonus;

    public Secretary(String name, int year, float rate, int hoursWorked, float weeklyBonus) {
        setName(name);
        setYear(year);
        setRate(rate);
        setHoursWorked(hoursWorked);
        this.weeklyBonus = weeklyBonus;
    }

    public Secretary() {
        this(null, 0, 0, 0, 0);
    }

    public void setWeeklyBonus(float weeklyBonus) {
        this.weeklyBonus = weeklyBonus;
    }
    public float getWeeklyBonus() {
        return weeklyBonus;
    }

    public String toString () {
        String s = String.format("Name: %s, id: %d, hire year: %d, " +
                "Weekly check amount: %,.1f, hourly rate: %,.1f, " +
                "hours worked: %d, bonus: %,.1f", getName(), getId(), getYear(),
                getWeeklyCheckAmount(), getRate(), getHoursWorked(), weeklyBonus);
        return s;
    }

    public float getWeeklyCheckAmount() {
        return (getRate() * getHoursWorked()) + weeklyBonus;
    }

    public boolean equals(Secretary o) {
        if (super.equals(o)) {
            if (this.weeklyBonus == o.weeklyBonus) {
                return true;
            }
        }
        return false;
    }
}


class SalesWorker extends HourlyWorker {
    private int numOfSales;
    private float commission;

    public SalesWorker(String name, int year, float rate, int hoursWorked,
                       int numOfSales, float commission) {
        setName(name);
        setYear(year);
        setRate(rate);
        setHoursWorked(hoursWorked);
        this.numOfSales = numOfSales;
        this.commission = commission;
    }

    public SalesWorker() {
        this(null, 0, 0, 0, 0, 0);
    }

    public void setNumOfSales(int numOfSales) {
        this.numOfSales = numOfSales;
    }
    public void setCommission(float commission) {
        this.commission = commission;
    }
    public int getNumOfSales() {
        return numOfSales;
    }
    public float getCommission() {
        return commission;
    }
    public String toString () {
        String s = String.format("Name: %s, id: %d, hire year: %d, " +
                        "Weekly check amount: %,.1f, hourly rate: %,.1f, " +
                        "hours worked: %d, salesCount: %d, commission: %,.1f",
                getName(), getId(), getYear(), getWeeklyCheckAmount(), getRate(),
                getHoursWorked(), numOfSales, commission);
        return s;
    }

    public float getWeeklyCheckAmount() {
        return (getRate()*getHoursWorked()) + (numOfSales*commission);
    }

    public boolean equals(SalesWorker o) {
        if (super.equals(o)) {
            if (this.numOfSales == o.numOfSales && this.commission == o.commission) {
                return true;
            }
        }
        return false;
    }
}


class Manager extends SalariedWorker {
    private ArrayList<Employee> a = new ArrayList<>();

    public Manager(String name, int year, float salary) {
        setName(name);
        setYear(year);
        setSalary(salary);
    }

    public ArrayList<Employee> getA() {
        return a;
    }

    public void addEmployee(Employee e) {
        a.add(e);
    }

    public float getWeeklyCheckAmount() {
        return getSalary();
    }

    public boolean equals(Manager o) {
        if (!super.equals(o)) {
            return false;
        }
        else if (this.a.size() != o.a.size()){
            return false;
        }
        else {
            for (int i = 0; i < this.a.size(); i++) {
                if (!this.a.get(i).equals(o.a.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        System.out.println("Enter the first Manager's name:");
        String name = sn.nextLine();
        System.out.println("What year was the manager hired?");
        int year = sn.nextInt();
        System.out.println("What is the manager's annual salary?");
        float salary = sn.nextFloat();
        Manager m1 = new Manager(name, year, salary);

        System.out.println("How many employees are working under this manager?");
        int numOfEmployees = sn.nextInt();


        for (int i = 0; i < numOfEmployees; i++) {
            System.out.println("Enter 1 for Secretary and 2 for Sales Worker?");
            int choice = sn.nextInt();
            sn.nextLine();

            if (choice == 1) {
                System.out.println("Enter secretary's name: ");
                name = sn.nextLine();
                System.out.println("Enter hire year: ");
                year = sn.nextInt();
                System.out.println("Enter hourly rate:");
                float rate = sn.nextFloat();
                System.out.println("Enter number of hours a week:");
                int hoursWorked = sn.nextInt();
                System.out.println("Enter weekly bonus:");
                float weeklyBonus = sn.nextFloat();
                m1.addEmployee(new Secretary(name, year, rate, hoursWorked, weeklyBonus));
            }
            else if (choice == 2) {
                System.out.println("Enter sales worker's name: ");
                name = sn.nextLine();
                System.out.println("Enter hire year: ");
                year = sn.nextInt();
                System.out.println("Enter hourly rate:");
                float rate = sn.nextFloat();
                System.out.println("Enter number of hours a week:");
                int hoursWorked = sn.nextInt();
                System.out.println("Enter weekly sales made:");
                int numOfSales = sn.nextInt();
                System.out.println("Enter commission per sale:");
                float commission = sn.nextFloat();
                m1.addEmployee(new SalesWorker(name, year, rate,
                        hoursWorked, numOfSales, commission));
            }
        }
        sn.nextLine();

        System.out.println("Enter the second Manager's name:");
        name = sn.nextLine();
        System.out.println("What year was the manager hired?");
        year = sn.nextInt();
        System.out.println("What is the manager's annual salary?");
        salary = sn.nextFloat();
        Manager m2 = new Manager(name, year, salary);

        System.out.println("How many employees are working under this manager?");
        numOfEmployees = sn.nextInt();

        for (int i = 0; i < numOfEmployees; i++) {
            System.out.println("Enter 1 for Secretary and 2 for Sales Worker?");
            int choice = sn.nextInt();
            sn.nextLine();

            if (choice == 1) {
                System.out.println("Enter secretary's name: ");
                name = sn.nextLine();
                System.out.println("Enter hire year: ");
                year = sn.nextInt();
                System.out.println("Enter hourly rate:");
                float rate = sn.nextFloat();
                System.out.println("Enter number of hours a week:");
                int hoursWorked = sn.nextInt();
                System.out.println("Enter weekly bonus:");
                float weeklyBonus = sn.nextFloat();
                m2.addEmployee(new Secretary(name, year, rate, hoursWorked, weeklyBonus));
            }
            else if (choice == 2) {
                System.out.println("Enter sales worker's name: ");
                name = sn.nextLine();
                System.out.println("Enter hire year: ");
                year = sn.nextInt();
                System.out.println("Enter hourly rate:");
                float rate = sn.nextFloat();
                System.out.println("Enter number of hours a week:");
                int hoursWorked = sn.nextInt();
                System.out.println("Enter weekly sales made:");
                int numOfSales = sn.nextInt();
                System.out.println("Enter commission per sale:");
                float commission = sn.nextFloat();
                m2.addEmployee(new SalesWorker(name, year, rate,
                        hoursWorked, numOfSales, commission));
            }
        }
        sn.nextLine();
        System.out.println();

        if (m1.equals(m2)) {
            System.out.println("---- Managers entered are equal!");
        }
        else {
            System.out.println("---- Managers entered are NOT equal!");
        }
        System.out.println();

        System.out.println("**** Secretary Employees:");
        for (Employee e : m1.getA()) {
            if (e instanceof Secretary) {
                System.out.println("    " + e.toString());;
            }
        }

        System.out.println("**** Sales Employees:");
        for (Employee e : m1.getA()) {
            if (e instanceof SalesWorker) {
                System.out.println("    " + e.toString());
            }
        }
        System.out.println();

        System.out.println("---- Employees sorted alphabetically:");
        Collections.sort(m1.getA(), Comparator.comparing(Employee::getName));
        for (Employee e : m1.getA()) {
            System.out.println(e);
        }
        System.out.println();

        System.out.println("---- Employees sorted on weekly check:");
        Collections.sort(m1.getA(), Comparator.comparing(
                Employee::getWeeklyCheckAmount));
        for (Employee e : m1.getA()) {
            System.out.println(e);
        }
        System.out.println();

        System.out.println("---- Employees sorted on hire year:");
        Collections.sort(m1.getA(), Comparator.comparing(
                Employee::getYear));
        for (Employee e : m1.getA()) {
            System.out.println(e);
        }
    }
}