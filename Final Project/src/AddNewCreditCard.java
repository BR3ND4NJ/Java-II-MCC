import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class AddNewCreditCard extends JFrame {
    String title = "Add New Credit Card";
    JTextField username, cardLimit, interest;
    JRadioButton r1, r2, r3;
    JButton b1;
    JLabel cardNum;
    Accounts a;
    Random r;

    public AddNewCreditCard(Accounts a) {
        this.a = a;
        r = new Random();
        setTitle(title);
        setSize(300, 180);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        createPanel();
        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void createPanel() {
        setLayout(new BorderLayout());

        cardNum = new JLabel(String.valueOf(BasicCreditCard.getNextAvailableCreditCardNum()));
        cardNum.setHorizontalAlignment(JLabel.CENTER);

        JLabel l1 = new JLabel("Username:");
        JLabel l2 = new JLabel("Card Type:");
        JLabel l3 = new JLabel("Card Limit:");
        JLabel l4 = new JLabel("Interest:");

        username = new JTextField(20);
        cardLimit = new JTextField(20);
        interest = new JTextField(generateInterestRate());
        interest.setEditable(false);

        r1 = new JRadioButton("Free");
        r2 = new JRadioButton("Rewards");
        r3 = new JRadioButton("Platinum");
        ButtonGroup r = new ButtonGroup();
        r.add(r1);
        r.add(r2);
        r.add(r3);

        b1 = new JButton("Add Card");
        b1.addActionListener(new ButtonListener());

        Box UN = Box.createHorizontalBox();
        Box CT = Box.createHorizontalBox();
        Box CL = Box.createHorizontalBox();
        Box IN = Box.createHorizontalBox();

        Box VB = Box.createVerticalBox();

        UN.add(l1);
        UN.add(username);

        CT.add(l2);
        CT.add(r1);
        CT.add(r2);
        CT.add(r3);

        CL.add(l3);
        CL.add(cardLimit);

        IN.add(l4);
        IN.add(interest);

        VB.add(UN);
        VB.add(CT);
        VB.add(CL);
        VB.add(IN);

        add(cardNum, BorderLayout.NORTH);
        add(VB, BorderLayout.CENTER);
        add(b1, BorderLayout.SOUTH);
    }


    public String generateInterestRate() {
        return String.format("%.2f", r.nextFloat((float) 0.01, (float) 0.09));
    }


    private class ButtonListener implements ActionListener {
        public float generateRewardPercent() {
            return r.nextFloat((float) 0.01, (float) 0.05);
        }

        public int generateAnnualFee() {
            return r.nextInt(50, 100);
        }


        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Add Card")) {
                try {
                    if (a.getCustomer(username.getText()) == null) {
                        username.setBackground(Color.RED);
                        throw new Exception("Username is not in system. Create account first.");
                    }

                    if (r1.isSelected()) {
                        a.getCustomer(username.getText()).addCreditCard(new BasicCreditCard(
                                BasicCreditCard.getNextAvailableCreditCardNum(), "Free",
                                Float.parseFloat(cardLimit.getText()), Float.parseFloat(interest.getText()), 0));
                    }
                    else if (r2.isSelected()) {
                        a.getCustomer(username.getText()).addCreditCard(new BenefitCreditCard(
                                BasicCreditCard.getNextAvailableCreditCardNum(), "Rewards",
                                Float.parseFloat(cardLimit.getText()), Float.parseFloat(interest.getText()), 0,
                                generateAnnualFee(), generateRewardPercent()));
                    }
                    else if (r3.isSelected()) {
                        a.getCustomer(username.getText()).addCreditCard(new BenefitCreditCard(
                                BasicCreditCard.getNextAvailableCreditCardNum(), "Platinum",
                                Float.parseFloat(cardLimit.getText()), Float.parseFloat(interest.getText()), 0,
                                        generateAnnualFee(), generateRewardPercent()));
                    }
                    else {
                        throw new Exception("Select what type of card you want");
                    }

                    JOptionPane.showMessageDialog(null, "Credit Card Added Successfully!");
                    cardNum.setText(String.valueOf(BasicCreditCard.getNextAvailableCreditCardNum()));
                    username.setBackground(Color.white);
                    username.setText("");
                    cardLimit.setText("");
                    interest.setText(generateInterestRate());
                    r1.setSelected(false);
                    r2.setSelected(false);
                    r3.setSelected(false);
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }
    }
}