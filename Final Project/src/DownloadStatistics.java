import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;

class DownloadStatistics extends JFrame {
    String title = "Download Statistics";
    JTextField t1;
    JButton b1;
    Accounts a;

    public DownloadStatistics(Accounts a) {
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

        JLabel l1 = new JLabel("Location to Download:");

        t1 = new JTextField(12);

        b1 = new JButton("Download");
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
            if (e.getActionCommand().equals("Download")) {
                try {
                    File file = new File(t1.getText());
                    PrintWriter pw = new PrintWriter(file);

                    pw.println("------------------SORTED BY LAST NAME------------------");
                    pw.println();
                    Collections.sort(a.al, Comparator.comparing(Customer::getLastName));

                    for (Customer c : a.al) {
                        pw.println(c.toString());
                    }

                    pw.println();
                    pw.println("------------------SORTED BY AMOUNT OWED------------------");
                    pw.println();
                    Collections.sort(a.al, Comparator.comparing(Customer::getTotalAmountOwed));

                    for (Customer c : a.al) {
                        pw.println(c.toString());
                    }

                    pw.close();

                    JOptionPane.showMessageDialog(null, "Download Successful!");
                }
                catch (IOException ioe) {
                    JOptionPane.showMessageDialog(null, "File can't be created here.");
                }
            }
        }
    }
}