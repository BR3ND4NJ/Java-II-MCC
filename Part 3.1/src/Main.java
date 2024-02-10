import java.util.Scanner;


class Person {
    private String name;
    private String address;
    private String num;

    public Person(String name, String address, String num) {
        this.name = name;
        this.address = address;
        this.num = num;
    }
    public Person() {
        this(null, null, null);
    }
    public Person(String name) {
        this.name = name;
    }

    public final void setName(String name) { this.name = name; }
    public final void setAddress(String address) { this.address = address; }
    public final void setNum(String num) { this.num = num; }
    public final String getName() { return name; }
    public final String getAddress() { return address; }
    public final String getNum() { return num; }

    public String toString() {
        String str = "Name: " + name;
        str += "\nAddress: " + address;
        str += "\nPhone Number: " + num + "\n";
        return str;
    }
}


class Customer extends Person{
    private String customerID;
    private boolean mail;

    public Customer(String name, String address, String num, String customerID, boolean mail) {
        super(name, address, num);
        this.customerID = customerID;
        this.mail = mail;
    }
    public Customer(String name, String customerID) {
        this(name, null, null, customerID, false);
    }

    public void setCustomerID(String customerID) { this.customerID = customerID; }
    public void setMail(boolean mail) { this.mail = mail; }
    public String getCustomerID() { return customerID; }
    public boolean getMail() { return mail; }

    public String toString() {
        String str = super.toString();
        str += "Customer ID: " + customerID;
        str += "\nMailing List: " + mail;
        return str;
    }

}


public class Main {
    public static boolean mail(String r) {
        if (r.toLowerCase().equals("yes")) {
            return true;
        }
        else {
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        System.out.println("Enter customer 1's name:");
        String n1 = sn.nextLine();
        System.out.println("Enter customer 1's id:");
        String i1 = sn.nextLine();
        Customer c1 = new Customer(n1, i1);

        System.out.println("Enter customer 2's name:");
        String n2 = sn.nextLine();
        System.out.println("Enter customer 2's id:");
        String i2 = sn.nextLine();
        System.out.println("Enter customer 2's address:");
        String a2 = sn.nextLine();
        System.out.println("Enter customer 2's phone number:");
        String phone2 = sn.nextLine();
        System.out.println("Would customer 2 like to be added to the mailing list?");
        String m2 = sn.nextLine();
        Customer c2 = new Customer(n2, a2, phone2, i2, mail(m2));

        System.out.println(c1.toString());
        System.out.println(c2.toString());

    }
}