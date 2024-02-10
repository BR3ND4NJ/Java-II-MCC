import java.util.Scanner;


class Car {
    private Maker m;
    private static int carsCreated = 0;


    public Car() {
        this.m = new Maker();
        carsCreated++;
    }


    public Car(String make, int year) {
        this.m = new Maker();
        m.setMake(make);
        m.setYear(year);
        carsCreated++;
    }


    public Car(Car other) {
        this.m = new Maker();
        this.setMake(other.getMake());
        this.setYear(other.getYear());
        carsCreated++;
    }


    public void setMake(String make) { m.setMake(make); }
    public void setYear(int y) { m.setYear(y); }
    public String getMake() { return m.getMake(); }
    public int getYear() { return m.getYear(); }
    public static int getCarsCreated() { return carsCreated; }


    public boolean equals (Car other) {
        if (m.getMake().equals(other.m.getMake())) {
            return true;
        }
        return false;
    }


    public String toString() {
        String str = "Make: " + this.m.getMake();
        str += "\nYear: " + this.m.getYear();
        return str;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        Car c1 = new Car();
        Car c2 = new Car();

        System.out.println("Enter make of car 1:");
        c1.setMake(sn.nextLine());
        System.out.println("Enter year of car 1:");
        c1.setYear(sn.nextInt());
        sn.nextLine();
        System.out.println("Enter make of car 2:");
        c2.setMake(sn.nextLine());
        System.out.println("Enter year of car 2:");
        c2.setYear(sn.nextInt());

        Car copy = new Car(c2);

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

        System.out.printf("Cars Created: %d", Car.getCarsCreated());
    }
}