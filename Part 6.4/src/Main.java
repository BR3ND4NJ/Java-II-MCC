import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class conversionWindow extends JFrame {
    String title = "Distance Conversion";
    String miles;
    String km;
    JTextField t1, t2;
    JCheckBox c1;
    JRadioButton r1, r2;
    String Button1 = "Convert to Miles", Button2 = "Convert to KM";

    public conversionWindow () {
        setTitle(title);
        setSize(400, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createPanel();
        this.setVisible(true);
    }

    public void createPanel() {
        setLayout(new GridLayout(5, 2));

        JPanel p = new JPanel();

        JLabel none = new JLabel();

        JLabel l1 = new JLabel("Distance");
        t1 = new JTextField(15);

        r1 = new JRadioButton("Miles");
        r2 = new JRadioButton("KM");
        ButtonGroup rGroup = new ButtonGroup();
        rGroup.add(r1);
        rGroup.add(r2);

        JLabel l2 = new JLabel("Converted Distance");
        t2 = new JTextField(15);

        JButton b1 = new JButton(Button1);

        JButton b2 = new JButton(Button2);

        p.setBackground(Color.CYAN);
        b1.setForeground(Color.blue);
        b2.setForeground(Color.blue);

        b1.addActionListener(new SharedBH());
        b2.addActionListener(new SharedBH());

        c1 = new JCheckBox("Allow same unit conversion");

        add(l1);
        add(t1);
        add(r1);
        add(r2);
        add(l2);
        add(t2);
        add(b1);
        add(b2);
        add(none);
        add(c1);

        //add(p);
    }


    private class SharedBH implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals(Button1)) {
                try {
                    if (r1.isSelected()) {
                        if (c1.isSelected()) {
                            float num = Float.parseFloat(t1.getText());
                            t2.setText(String.valueOf(num));
                        }
                        else {
                            JOptionPane.showMessageDialog(null,
                                    "Same Unit Conversion Not Allowed");
                        }
                    }
                    else if (r2.isSelected()) {
                        float num = Float.parseFloat(t1.getText());
                        t2.setText(String.valueOf(num * .62));
                    }
                }
                catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, "Enter a numerical value");
                }
            }
            else if (e.getActionCommand().equals(Button2)) {
                try {
                    if (r2.isSelected()) {
                        if (c1.isSelected()) {
                            float num = Float.parseFloat(t1.getText());
                            t2.setText(String.valueOf(num));
                        }
                        else {
                            JOptionPane.showMessageDialog(null,
                                    "Same Unit Conversion Not Allowed");
                        }
                    }
                    else if (r1.isSelected()){
                        float num = Float.parseFloat(t1.getText());
                        t2.setText(String.valueOf(num * 1.6));
                    }
                }
                catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, "Enter a numerical value");
                }
            }

        }
    }
}


public class Main {
    public static void main(String[] args) {
        conversionWindow cw = new conversionWindow();
    }
}