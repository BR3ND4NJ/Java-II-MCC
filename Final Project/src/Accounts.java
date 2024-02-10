import java.util.ArrayList;

class Accounts {
    ArrayList<Customer> al;

    public Accounts() {
        al = new ArrayList<Customer>();
    }

    public boolean CustomerExist(int ssn) {
        for (Customer c: al) {
            if (c.ssn == ssn) {
                return true;
            }
        }
        return false;
    }

    public void addCustomer(Customer c) {
        al.add(c);
    }

    public void addCreditCard(Customer c, BasicCreditCard cc) {
        c.addCreditCard(cc);
    }

    public Customer getCustomer(String username) throws InvalidCustomerException {
        for (Customer c: al) {
            if (c.username.equals(username)) {
                return c;
            }
        }
        return null;
    }

    public Customer getCustomerBySSN(int ssn) throws InvalidCustomerException {
        for (Customer c : al) {
            if (c.ssn == ssn) {
                return c;
            }
        }
        return null;
    }

    public BasicCreditCard getCreditCard(int cardNum) {
        for (Customer c : al) {
            for (BasicCreditCard b : c.creditCards) {
                if (b.creditCardNumber == cardNum) {
                    return b;
                }
            }
        }
        return null;
    }
}
