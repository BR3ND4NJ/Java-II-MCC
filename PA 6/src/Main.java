import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class Window extends JFrame {
    String title = "";
    JRadioButton r1, r2, r3;
    JTextField t1;
    String Button = "Calculate", Exit = "Exit";

    public Window() {
        setTitle(title);
        setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createPanel();
        this.setVisible(true);
    }

    public void createPanel() {
        JPanel p = new JPanel();

        r1 = new JRadioButton("Daytime (6am to 5:59pm)");
        r2 = new JRadioButton("Evening (6pm to 11:59pm)");
        r3 = new JRadioButton("Off-peak (12am to 5:59 am)");
        ButtonGroup rGroup = new ButtonGroup();
        rGroup.add(r1);
        rGroup.add(r2);
        rGroup.add(r3);

        t1 = new JTextField(12);

        JButton b1 = new JButton(Button);
        JButton b2 = new JButton(Exit);
        b1.addActionListener(new buttonChecker());
        b2.addActionListener(new buttonChecker());

        p.add(r1);
        p.add(r2);
        p.add(r3);
        p.add(t1);
        p.add(b1);
        p.add(b2);

        add(p);
    }

    private class buttonChecker implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals(Button)) {
                try {
                    float num = Float.parseFloat(t1.getText());
                    if (r1.isSelected()) {
                        JOptionPane.showMessageDialog(null,
                                String.format("The cost of the call is $%,.2f", num * .07));
                    }
                    if (r2.isSelected()) {
                        JOptionPane.showMessageDialog(null,
                                String.format("The cost of the call is $%,.2f", num * .12));
                    }
                    if (r3.isSelected()) {
                        JOptionPane.showMessageDialog(null,
                                String.format("The cost of the call is $%,.2f", num * .05));
                    }
                }
                catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, "Enter a numeric value");
                }
            }
            if (e.getActionCommand().equals(Exit)) {
                System.exit(0);
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Window w = new Window();
    }
}