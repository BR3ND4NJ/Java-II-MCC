import java.util.Scanner;


class Car{
    private String plate;
    private int speed;

    public Car() {}
    public Car(Car other) {
        plate = other.getPlate();
        speed = other.getSpeed();
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public String getPlate() {
        return plate;
    }
    public int getSpeed() {
        return speed;
    }

}


class Street{
    private static int aSpeed;

    public Street() {}
    public Street(Street other) {
        other.setaSpeed(this.getaSpeed());
    }

    public void setaSpeed(int aSpeed) {
        this.aSpeed = aSpeed;
    }
    public int getaSpeed() {
        return aSpeed;
    }

    public static int speedCheck(int carSpeed) {
        return aSpeed - carSpeed;
    }

}


class Officer{
    private String name;
    private int badgeNum;

    public Officer() {}
    public Officer(Officer other) {
        name = other.name;
        badgeNum = other.badgeNum;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setBadgeNum(int badgeNum) {
        this.badgeNum = badgeNum;
    }
    public String getName() {
        return name;
    }
    public int getBadgeNum() {
        return badgeNum;
    }

    public boolean Speeding(int cs) {
        if (Street.speedCheck(cs) > 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public void ticket(int cs) {
        if (Speeding(cs) != false) {
            System.out.println("No ticket!");
        }
        else {
            System.out.println("Ticket Information:");
            System.out.println("Car Involved:");
            System.out.printf("License");
        }
    }

}


class Ticket{
    private Car c = new Car();
    private Street s = new Street();
    private Officer o = new Officer();
    private float fine = 100;

    public Ticket(Car c, Street s, Officer o) {
        this.c = new Car(c);
        this.s = new Street(s);
        this.o = new Officer(o);
    }

    public void setC(Car c) {
        this.c.setPlate(c.getPlate());
        this.c.setSpeed(c.getSpeed());
    }
    public void setO(Officer o) {
        this.o.setName(o.getName());
        this.o.setBadgeNum(o.getBadgeNum());
    }
    public void setFine(float num) {
        fine += -num;
    }

    public void getFine() {

        System.out.println("Ticket Information:");
        System.out.println("Car Involved:");
        System.out.printf("License Number: %s\nSpeed: %d\n\n",
                c.getPlate(), c.getSpeed());
        setFine(Street.speedCheck(c.getSpeed())*5);
        System.out.println("Officer issuing the ticket:");
        System.out.printf("Name: %s\nBadge Number: %d\n\n", o.getName(), o.getBadgeNum());
        System.out.println("Street:");
        System.out.printf("Speed Limit: %d\nFine: $%,.2f\n", s.getaSpeed(), fine);
    }

}


public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        Car c = new Car();
        Street s = new Street();
        Officer o = new Officer();

        System.out.println("Enter car's license plate:");
        c.setPlate(sn.nextLine());
        System.out.println("Enter car's current speed:");
        c.setSpeed(sn.nextInt());
        System.out.println("Enter Street's speed limit:");
        s.setaSpeed(sn.nextInt());
        sn.nextLine();
        System.out.println("Enter officer's name:");
        o.setName(sn.nextLine());
        System.out.println("Enter officer's badge number:");
        o.setBadgeNum(sn.nextInt());

        Ticket t = new Ticket(c, s, o);

        if (Street.speedCheck(c.getSpeed()) >= 0) {
            System.out.println("No ticket!");
        }
        else {
            t.getFine();
        }
    }
}