import java.util.ArrayList;
import java.util.Scanner;


class Car{
    private enum CarColor {RED, BLACK, BLUE, SILVER};
    private enum CarType {PORSCHE, FERRARI, JAGUAR};


    private CarColor cc;
    private CarType ct;
    private static int carsCreated = 0;


    public Car() {
        carsCreated++;
    }


    public Car(CarColor cc, CarType ct) {
        this.cc = cc;
        this.ct = ct;
        carsCreated++;
    }


    public Car(Car other) {
        this.cc = other.cc;
        this.ct = other.ct;
        carsCreated++;
    }


    public boolean isCarColor(String s) {
        for (CarColor c : CarColor.values()) {
            if (c.toString().equals(s)) {
                return true;
            }
        }
        return false;
    }


    public boolean isCarType(String s) {
        for (CarType c : CarType.values()) {
            if (c.toString().equals(s)) {
                return true;
            }
        }
        return false;
    }


    public void setCc(String cc) { this.cc = CarColor.valueOf(cc); }
    public void setCt(String ct) { this.ct = CarType.valueOf(ct); }
    public CarColor getCc() { return cc; }
    public CarType getCt() { return ct; }
    public static int getCarsCreated() { return carsCreated; }


    public String toString() {
        String str = "Car: ";
        str += this.getCc() + " " + this.getCt();
        return str;
    }
}


class carGarage{
    private ArrayList<Car> g;
    private Car c;


    public carGarage() {
        g = new ArrayList<>();
    }

    public void setG(int num, String s) {
        Car c = g.get(num);
        if (c.isCarColor(s)) {
            c.setCc(s);
        }
        else if (c.isCarType(s)) {
            c.setCt(s);
        }
        else {
            System.out.println("Not a valid choice :(");
        }
    }

    public String getG() {
        return g.toString();
    }

    public void makeCopies() {
        int currSize = g.size();
        for (int i = 0; i < currSize; i++) {
            newCar(g.get(i));
        }
    }

    public void newCar() {
        Car c = new Car();
        g.add(c);
    }


    public void newCar(Car other) {
        Car copy = new Car(other);
        g.add(copy);
    }


    public String toString() {
        StringBuilder str = new StringBuilder("The cars that are in the garage are:\n");
        str.append(getG());

        return str.toString();
    }
}


public class Main{
    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);

        carGarage g = new carGarage();
        g.newCar();
        g.newCar();
        g.newCar();

        System.out.println("Enter color of car 1:");
        g.setG(0, sn.nextLine());
        System.out.println("Enter type of car 1:");
        g.setG(0, sn.nextLine());
        System.out.println("Enter color of car 2:");
        g.setG(1, sn.nextLine());
        System.out.println("Enter type of car 2:");
        g.setG(1, sn.nextLine());
        System.out.println("Enter color of car 3:");
        g.setG(2, sn.nextLine());
        System.out.println("Enter type of car 3:");
        g.setG(2, sn.nextLine());

        g.makeCopies();

        System.out.println(g.toString());

        for (int i = 0; i < Car.getCarsCreated()/2; i++) {
            g.setG(i, "RED");
        }

        System.out.println(g.toString());
    }
}