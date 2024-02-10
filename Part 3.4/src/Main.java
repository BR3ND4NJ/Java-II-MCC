import java.util.Locale;
import java.util.Scanner;


abstract class BankAccount {
    private float balance;

    public void setBalance(float balance) {
        this.balance = balance;
    }
    public float getBalance() {
        return balance;
    }

    public abstract void deposit(float amount);
    public abstract void withdraw(float amount);
}

class SavingsAccount extends BankAccount {
    boolean active;

    public SavingsAccount(float balance) {
        setBalance(balance);
        setActive();
    }
    public SavingsAccount() {
        setBalance(0);
        setActive();
    }

    public void setActive() {
        if (getBalance() > 25) {
            active = true;
        }
        else {
            active = false;
        }
    }
    public void deposit(float amount) {
        setBalance(getBalance() + amount);
        System.out.printf("Deposited $%,.2f, new balance: $%,.2f\n", amount, getBalance());
    }
    public void withdraw(float amount) {
        setActive();
        if (active == true) {
            if (getBalance() - amount > 0){
                setBalance(getBalance() - amount);
                System.out.printf("Withdrew $%,.2f, new balance: $%,.2f\n", amount, getBalance());
            }
            else {
                System.out.printf("Cannot withdraw $%,.2f!\n", amount);
            }
        }
        else {
            System.out.printf("Cannot withdraw $%,.2f!\n", amount);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        System.out.println("Enter starting balance:");
        SavingsAccount s = new SavingsAccount(sn.nextFloat());
        sn.nextLine();

        System.out.println("Choose an option:");
        System.out.println("D: Deposit");
        System.out.println("W:Withdraw");
        System.out.println("E:Exit");
        char c = sn.nextLine().toLowerCase().charAt(0);

        while (c != 'e') {
            switch(c) {
                case 'd' -> {
                    System.out.println("Enter amount:");
                    s.deposit(sn.nextFloat());
                }
                case 'w' -> {
                    System.out.println("Enter amount:");
                    s.withdraw(sn.nextFloat());
                }
                default -> System.out.println("Invalid Option");
            }
            sn.nextLine();
            System.out.println("Choose an option:");
            System.out.println("D: Deposit");
            System.out.println("W:Withdraw");
            System.out.println("E:Exit");
            c = sn.nextLine().toLowerCase().charAt(0);
        }

    }
}