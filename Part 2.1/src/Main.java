import java.util.Scanner;


class car {
    private String make;
    private int year;
    private static int carsCreated = 0;


    public car() {
        carsCreated++;
    }


    public car(String make, int year) {
        this.make = make;
        this.year = year;
        carsCreated++;
    }


    public car(car other) {
        this.make = other.make;
        this.year = other.year;
        carsCreated++;
    }


    public void setMake(String m) { make = m;}
    public void setYear(int y) { year = y; }
    public String getMake() { return make; }
    public int getYear() { return year; }
    public static int getCarsCreated() { return carsCreated; }


    public boolean equals (car other) {
        if (make.equals(other.make) && year == other.year) {
            return true;
        }
        return false;
    }


    public String toString() {
        String str = "Make: " + this.make;
        str += "\nYear: " + this.year;
        return str;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        car c1 = new car();
        car c2 = new car();

        System.out.println("Enter make of car 1:");
        c1.setMake(sn.nextLine());
        System.out.println("Enter year of car 1:");
        c1.setYear(sn.nextInt());
        sn.nextLine();
        System.out.println("Enter make of car 2:");
        c2.setMake(sn.nextLine());
        System.out.println("Enter year of car 2:");
        c2.setYear(sn.nextInt());

        car copy = new car(c2);

        System.out.print("Is Car copy equivalent to Car c2? ");
        System.out.println(c2.equals(copy));
        System.out.print("Is Car c1 equivalent to Car c2? ");
        System.out.println(c2.equals(c1));

        System.out.println("Car c1:");
        System.out.println(c1.toString());
        System.out.println("Car c2:");
        System.out.println(c2.toString());
        System.out.println("Car copy:");
        System.out.println(copy.toString());

        System.out.printf("Cars Created: %d", car.getCarsCreated());
    }
}