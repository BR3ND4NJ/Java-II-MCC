import java.util.ArrayList;
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

    public Customer() {
        this(null, null, null, null, false);
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


class PreferredCustomer extends Customer {
    private float moneySpent;
    private float discount;

    public PreferredCustomer(String name, String address, String num, String customerID, boolean mail,
                             float moneySpent, float discount) {
        super(name, address, num, customerID, mail);
        this.moneySpent = moneySpent;
        this.discount = discount;
    }

    public PreferredCustomer() {
        this(null, null, null, null, false, 0, 0);
    }

    public PreferredCustomer(String name, String customerID) {
        super(name, customerID);
    }

    public PreferredCustomer(String name, String customerID, float moneySpent) {
        this(name, customerID);
        this.moneySpent = moneySpent;
        getdiscount();
    }

    public float getdiscount() {
        if (moneySpent < 500) {
            discount = 5;
        }
        else if (moneySpent >= 500){
            discount = 10;
        }
        return discount;
    }

    public String toString() {
        String str = super.toString();
        str += String.format("\nAmount Spent: $%,.2f", moneySpent);
        str += String.format("\nDiscount: %.1f%%", discount);
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

        ArrayList<Customer> a = new ArrayList<>();

        System.out.println("Enter customer 1's name:");
        String n1 = sn.nextLine();
        System.out.println("Enter customer 1's id:");
        String id1 = sn.nextLine();
        Customer c1 = new Customer(n1, id1);
        a.add(c1);

        System.out.println("Enter customer 2's name:");
        String n2 = sn.nextLine();
        System.out.println("Enter customer 2's id:");
        String id2 = sn.nextLine();
        System.out.println("Enter customer 2's address:");
        String ad2 = sn.nextLine();
        System.out.println("Enter customer 2's phone number:");
        String num2 = sn.nextLine();
        System.out.println("Would customer 2 like to be added to the mailing list?");
        String mail2 = sn.nextLine();
        Customer c2 = new Customer(n2, ad2, num2, id2, mail(mail2));
        a.add(c2);


        System.out.println("Enter preferred customer 1's name:");
        String pn1 = sn.nextLine();
        System.out.println("Enter preferred customer 1's id:");
        String pid1 = sn.nextLine();
        System.out.println("Enter preferred customer 1's amount spent:");
        float amount1 = sn.nextFloat();
        sn.nextLine();
        PreferredCustomer pc1 = new PreferredCustomer(pn1, pid1, amount1);
        a.add(pc1);

        System.out.println("Enter preferred customer 2's name:");
        String pn2 = sn.nextLine();
        System.out.println("Enter preferred customer 2's id:");
        String pid2 = sn.nextLine();
        System.out.println("Enter preferred customer 2's amount spent:");
        float amount2 = sn.nextFloat();
        PreferredCustomer pc2 = new PreferredCustomer(pn2, pid2, amount2);
        a.add(pc2);

        System.out.println(a.toString());

        System.out.println("Preferred Customers:");
        for (Customer c : a) {
            if (c instanceof PreferredCustomer) {
                System.out.println(c.getName());
            }
        }
    }
}