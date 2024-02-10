import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MainScreen extends JFrame {
    String title = "MCC's Credit Card Storage System";
    JRadioButton r1, r2, r3, r4, r5;
    JButton b1;
    Accounts a;


    public MainScreen(Accounts a) {
        this.a = a;
        setTitle(title);
        setSize(500, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createPanel();
        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void createPanel() {
        setLayout(new BorderLayout());

        JLabel welcome = new JLabel("Welcome to MCC's Credit Card Company. " +
                "Please choose form the following options:");

        r1 = new JRadioButton("1. Upload Customer Records from Database File");
        r2 = new JRadioButton("2. Add New Customer");
        r3 = new JRadioButton("3. Add New Credit Card");
        r4 = new JRadioButton("4. View Information");
        r5 = new JRadioButton("5. Download Statistics");

        ButtonGroup r = new ButtonGroup();

        r.add(r1);
        r.add(r2);
        r.add(r3);
        r.add(r4);
        r.add(r5);

        b1 = new JButton("Next");
        b1.addActionListener(new ButtonListener());

        Box VB = Box.createVerticalBox();

        VB.add(r1);
        VB.add(r2);
        VB.add(r3);
        VB.add(r4);
        VB.add(r5);

        add(welcome, BorderLayout.NORTH);
        add(VB, BorderLayout.CENTER);
        add(b1, BorderLayout.SOUTH);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Next")) {
                try {
                    if (r1.isSelected()) {
                        CustomerRecords cr = new CustomerRecords(a);
                    }
                    else if (r2.isSelected()) {
                        AddNewCustomer nc = new AddNewCustomer(a);
                    }
                    else if (r3.isSelected()) {
                        AddNewCreditCard ncc = new AddNewCreditCard(a);
                    }
                    else if (r4.isSelected()) {
                        ViewInformation vi = new ViewInformation(a);
                    }
                    else if (r5.isSelected()) {
                        DownloadStatistics ds = new DownloadStatistics(a);
                    }
                }
                catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, "Choose " +
                            "an option");
                }
            }
        }
    }
}