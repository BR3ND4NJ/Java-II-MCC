import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ViewInformation extends JFrame {
    String title = "View Information";
    JTextField t1;
    JButton b1;
    Accounts a;

    public ViewInformation(Accounts a) {
        this.a = a;
        setTitle(title);
        setSize(400, 80);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        createPanel();
        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void createPanel() {
        JPanel p = new JPanel();

        JLabel l1 = new JLabel("SSN or Credit Card:");

        t1 = new JTextField(12);

        b1 = new JButton("View Information");
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
            if (e.getActionCommand().equals("View Information")) {
                try {
                    if (t1.getText().length() == 9) {
                        if (a.getCustomerBySSN(Integer.parseInt(t1.getText())) != null) {
                            JOptionPane.showMessageDialog(null,
                                    a.getCustomerBySSN(Integer.parseInt(t1.getText())).toString());
                        }
                        else {
                            throw new Exception("Customer doesn't exist");
                        }
                    }
                    else if (t1.getText().length() == 6) {
                        if (a.getCreditCard(Integer.parseInt(t1.getText())) != null) {
                            JOptionPane.showMessageDialog(null,
                                    a.getCreditCard(Integer.parseInt(t1.getText())).toString());
                        }
                        else {
                            throw new Exception("Card doesn't exist");
                        }
                    }
                    else {
                        throw new Exception("Please enter valid ssn or credit card number!");
                    }
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }
    }
}