import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AddNewCustomer extends JFrame {
    String title = "Add New Customer";
    JTextField fname, lname, ssn1, ssn2, ssn3, username, password, confirmPassword;
    JButton enter;
    Accounts a;

    public AddNewCustomer(Accounts a) {
        this.a = a;
        setTitle(title);
        setSize(300, 220);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        createPanel();
        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void createPanel() {
        setLayout(new BorderLayout());

        JLabel l1 = new JLabel("First Name:");
        JLabel l2 = new JLabel("Last Name:");
        JLabel l3 = new JLabel("Social Security Number:");
        JLabel l4 = new JLabel("Username:");
        JLabel l5 = new JLabel("Password:");
        JLabel l6 = new JLabel("Confirm Password:");
        JLabel l7 = new JLabel("-");
        JLabel l8 = new JLabel("-");

        fname = new JTextField(15);
        lname = new JTextField(15);
        ssn1 = new JTextField(3);
        ssn2 = new JTextField(2);
        ssn3 = new JTextField(4);
        username = new JTextField(20);
        password = new JPasswordField(20);
        confirmPassword = new JPasswordField(20);

        enter = new JButton("Submit");
        enter.addActionListener(new ButtonListener());

        Box VB = Box.createVerticalBox();
        Box FN = Box.createHorizontalBox();
        Box LN = Box.createHorizontalBox();
        Box SSN = Box.createHorizontalBox();
        Box UN = Box.createHorizontalBox();
        Box P = Box.createHorizontalBox();
        Box CP = Box.createHorizontalBox();

        FN.add(l1);
        FN.add(fname);

        LN.add(l2);
        LN.add(lname);

        SSN.add(l3);
        SSN.add(ssn1);
        SSN.add(l7);
        SSN.add(ssn2);
        SSN.add(l8);
        SSN.add(ssn3);

        UN.add(l4);
        UN.add(username);

        P.add(l5);
        P.add(password);

        CP.add(l6);
        CP.add(confirmPassword);

        VB.add(FN);
        VB.add(LN);
        VB.add(SSN);
        VB.add(UN);
        VB.add(P);
        VB.add(CP);

        add(VB, BorderLayout.CENTER);
        add(enter, BorderLayout.SOUTH);
    }


    private class ButtonListener implements ActionListener {
        public boolean validPassword(String p) {
            char c;
            boolean capital = false;
            boolean lower = false;
            boolean digit = false;

            for (int i = 0; i < p.length(); i++) {
                c = p.charAt(i);
                if (Character.isUpperCase(c)) {
                    capital = true;
                }
                else if (Character.isLowerCase(c)) {
                    lower = true;
                }
                else if (Character.isDigit(c)) {
                    digit = true;
                }
                if (capital && lower && digit) {
                    return true;
                }
            }
            return false;
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Submit")) {
                try {
                    if (password.getText().contains(" ")) {
                        password.setBackground(Color.RED);
                        throw new Exception("Password cannot contain any spaces");
                    }
                    else if (password.getText().length() < 8 || password.getText().length() > 10) {
                        password.setBackground(Color.RED);
                        throw new Exception("Improper password length. Make it 8-10 characters");
                    }
                    else if (!validPassword(password.getText())) {
                        password.setBackground(Color.RED);
                        throw new Exception("Password does not contain all types of characters required. Must " +
                                "contain an UPPERCASE CHARACTER, a lowercase character, and a digit.");
                    }
                    else if (!password.getText().equals(confirmPassword.getText())){
                        password.setBackground(Color.RED);
                        confirmPassword.setBackground(Color.RED);
                        throw new Exception("Passwords are not identical. Please re-enter passwords");
                    }
                    else if (a.getCustomer(username.getText()) != null) {
                        username.setBackground(Color.RED);
                        throw new Exception("Username taken. Enter another username.");
                    }
                    else {
                        a.al.add(new Customer(fname.getText(), lname.getText(), Integer.parseInt(ssn1.getText() +
                                ssn2.getText() + ssn3.getText()), username.getText(), password.getText()));
                        JOptionPane.showMessageDialog(null, "Account Created!");
                        fname.setText("");
                        lname.setText("");
                        ssn1.setText("");
                        ssn2.setText("");
                        ssn3.setText("");
                        username.setText("");
                        password.setText("");
                        confirmPassword.setText("");
                        username.setBackground(Color.white);
                        password.setBackground(Color.white);
                        confirmPassword.setBackground(Color.white);
                    }
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }
    }
}