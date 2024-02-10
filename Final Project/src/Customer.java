import java.util.ArrayList;

class Customer implements SearchInterface, Comparable<Customer> {
    String fname;
    String lname;
    int ssn;
    String username;
    String password;
    ArrayList<BasicCreditCard> creditCards;

    public Customer(String fname, String lname, int ssn, String username, String password) throws InvalidCustomerException {
        this.fname = fname;
        this.lname = lname;
        this.ssn = ssn;
        this.username = username;
        this.password = password;
        creditCards = new ArrayList<BasicCreditCard>();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (BasicCreditCard b : creditCards) {
            sb.append(b.toString() + "\n");
        }
        String s = String.format("FIRST NAME: %s, LAST NAME: %s, SSN: %s, USERNAME: %s, \nCREDIT CARDS:\n%s",
                fname, lname, ssn, username, sb.toString());
        return s;
    }

    public int getId() {
        return ssn;
    }

    public String getViewString() {
        return this.toString();
    }

    public boolean isValidPassword(String p) {
        return false;
    }

    public float getTotalAmountOwed() {
        float amount = 0;
        for (BasicCreditCard b : creditCards) {
            amount += b.getAmountOwed();
        }
        return amount;
    }

    public String getLastName() {
        return lname;
    }

    public void addCreditCard(BasicCreditCard b) {
        creditCards.add(b);
    }

    public void addCreditCard(BenefitCreditCard b) {
        creditCards.add(b);
    }


    public int compareTo(Customer o) {
        return this.getLastName().compareToIgnoreCase(o.getLastName());
    }
}
