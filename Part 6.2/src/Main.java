import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class conversionWindow extends JFrame {
    String title = "Distance Conversion";
    String miles;
    String km;
    JTextField t1, t2;
    String Button1 = "Convert to Miles", Button2 = "Convert to KM";

    public conversionWindow () {
        setTitle(title);
        setSize(550, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createPanel();
        this.setVisible(true);
    }

    public void createPanel() {
        JPanel p = new JPanel();

        JLabel l1 = new JLabel("Distance");
        t1 = new JTextField(15);

        JLabel l2 = new JLabel("Converted Distance");
        t2 = new JTextField(15);

        JButton b1 = new JButton(Button1);

        JButton b2 = new JButton(Button2);

        p.setBackground(Color.CYAN);
        b1.setForeground(Color.blue);
        b2.setForeground(Color.blue);

        b1.addActionListener(new SharedBH());
        b2.addActionListener(new SharedBH());

        p.add(l1);
        p.add(t1);
        p.add(l2);
        p.add(t2);
        p.add(b1);
        p.add(b2);
        add(p);
    }


    private class SharedBH implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals(Button1)) {
                try {
                    float num = Float.parseFloat(t1.getText());
                    t2.setText(String.valueOf(num * .62));
                }
                catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, "Enter a numerical value");
                }
            }
            else if (e.getActionCommand().equals(Button2)) {
                try {
                    float num = Float.parseFloat(t1.getText());
                    t2.setText(String.valueOf(num * 1.6));
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