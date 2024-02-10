import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class CustomerRecords extends JFrame {
    String title = "Upload Customer Records";
    JTextField t1;
    JButton b1;
    Accounts a;

    public CustomerRecords(Accounts a) {
        this.a = a;
        setTitle(title);
        setSize(350, 80);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        createPanel();
        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void createPanel() {
        JPanel p = new JPanel();

        JLabel l1 = new JLabel("Name of File:");

        t1 = new JTextField(12);

        b1 = new JButton("Upload");
        b1.addActionListener(new ButtonListener());

        Box HB = Box.createHorizontalBox();

        HB.add(l1);
        HB.add(t1);
        HB.add(b1);

        p.add(HB);

        add(p);
    }


    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equals("Upload")) {
                try {
                    StringBuilder errors = new StringBuilder();
                    File file = new File(t1.getText());
                    Scanner sn = new Scanner(file);

                    while (sn.hasNext()) {
                        try {
                            String line = sn.nextLine();
                            String[] splices = line.split(", ");

                            if (splices.length != 10 && splices.length != 12) {
                                throw new Exception(String.format("Line \"%s\" is missing information", line));
                            } else if (splices.length == 10) {
                                if (Float.parseFloat(splices[7]) < 0) {
                                    throw new Exception(String.format("Line \"%s\" is not a valid spending limit",
                                            splices[7]));
                                } else if (Float.parseFloat(splices[8]) < 0 || Float.parseFloat(splices[8]) > 1) {
                                    throw new Exception(String.format("Line \"%s\" is not a valid interest rate",
                                            splices[8]));
                                } else if (Float.parseFloat(splices[9]) < 0) {
                                    throw new Exception(String.format("Line \"%s\" is not a valid starting balance",
                                            splices[9]));
                                } else if (a.CustomerExist(Integer.parseInt(splices[2].substring(0, 3) +
                                        splices[2].substring(4, 6) + splices[2].substring(7, 11)))) {
                                    BasicCreditCard b = new BasicCreditCard(Integer.parseInt(splices[5]),
                                            splices[6], Float.parseFloat(splices[7]), Float.parseFloat(splices[8]),
                                            Float.parseFloat(splices[9]));
                                    a.getCustomerBySSN(Integer.parseInt(splices[2].substring(0, 3) +
                                            splices[2].substring(4, 6) + splices[2].substring(7, 11))).addCreditCard(b);
                                } else {
                                    Customer c = new Customer(splices[1], splices[0], Integer.parseInt(splices[2].substring(0, 3) +
                                            splices[2].substring(4, 6) + splices[2].substring(7, 11)), splices[3], splices[4]);
                                    BasicCreditCard b = new BasicCreditCard(Integer.parseInt(splices[5]),
                                            splices[6], Float.parseFloat(splices[7]), Float.parseFloat(splices[8]),
                                            Float.parseFloat(splices[9]));
                                    c.addCreditCard(b);
                                    a.addCustomer(c);
                                }
                            } else if (splices.length == 12) {
                                if (Float.parseFloat(splices[7]) < 0) {
                                    throw new Exception(String.format("Line \"%s\" is not a valid spending limit",
                                            splices[7]));
                                } else if (Float.parseFloat(splices[8]) < 0 || Float.parseFloat(splices[8]) > 1) {
                                    throw new Exception(String.format("Line \"%s\" is not a valid interest rate",
                                            splices[8]));
                                } else if (Float.parseFloat(splices[10]) < 0 || Float.parseFloat(splices[10]) > 1) {
                                    throw new Exception(String.format("Line \"%s\" is not a valid interest rate",
                                            splices[10]));
                                } else if (Float.parseFloat(splices[11]) < 0) {
                                    throw new Exception(String.format("Line \"%s\" is not a valid starting balance",
                                            splices[11]));
                                } else if (a.CustomerExist(Integer.parseInt(splices[2].substring(0, 3) +
                                        splices[2].substring(4, 6) + splices[2].substring(7, 11)))) {
                                    BenefitCreditCard b = new BenefitCreditCard(Integer.parseInt(splices[5]),
                                            splices[6], Float.parseFloat(splices[7]), Float.parseFloat(splices[8]),
                                            Float.parseFloat(splices[9]), Float.parseFloat(splices[10]),
                                            Float.parseFloat(splices[11]));
                                    a.getCustomerBySSN(Integer.parseInt(splices[2].substring(0, 3) +
                                            splices[2].substring(4, 6) + splices[2].substring(7, 11))).addCreditCard(b);
                                } else {
                                    Customer c = new Customer(splices[1], splices[0],
                                            Integer.parseInt(splices[2].substring(0, 3) +
                                                    splices[2].substring(4, 6) + splices[2].substring(7, 11)),
                                            splices[3], splices[4]);
                                    BenefitCreditCard b = new BenefitCreditCard(Integer.parseInt(splices[5]),
                                            splices[6], Float.parseFloat(splices[7]), Float.parseFloat(splices[8]),
                                            Float.parseFloat(splices[9]), Float.parseFloat(splices[10]),
                                            Float.parseFloat(splices[11]));
                                    c.addCreditCard(b);
                                    a.addCustomer(c);
                                }
                            }
                        }
                        catch (Exception ex) {
                            errors.append(ex.getMessage() + "\n");
                        }
                    }
                    if (errors.length() == 0) {
                        JOptionPane.showMessageDialog(null, "Upload Successful!");
                        t1.setText("");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, String.format("Error reading file.\n%s",
                                errors.toString()));
                    }
                }
                catch (IOException ioe) {
                    JOptionPane.showMessageDialog(null, "File Not Found");
                }
            }
        }
    }
}