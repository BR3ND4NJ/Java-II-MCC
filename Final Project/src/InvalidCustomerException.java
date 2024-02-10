import java.util.ArrayList;

class InvalidCustomerException extends Exception {
    public InvalidCustomerException(String duplicateUsername) {
        super(String.format("Username \"%s\" already exists. Try another one.", duplicateUsername));
    }

    public InvalidCustomerException(String user, String invalidPassword) {
        super("Password doesn't follow guidelines.");
    }

    public InvalidCustomerException(String user, ArrayList<Float> invalidMoneyList) {
        super(String.format("", user, invalidMoneyList));
    }
}
