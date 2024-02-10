import java.awt.*;
import javax.swing.*;


class conversionWindow extends JFrame {
    String title = "Distance Conversion";
    String miles;
    String km;

    public conversionWindow () {
        setTitle(title);
        setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createPanel();
        this.setVisible(true);
    }

    public void createPanel() {
        JPanel p = new JPanel();

        JLabel l1 = new JLabel("Distance");
        JTextField t1 = new JTextField(15);

        JLabel l2 = new JLabel("Converted Distance");
        JTextField t2 = new JTextField(15);

        JButton b1 = new JButton("Convert to KM");

        JButton b2 = new JButton("Convert to Miles");

        p.setBackground(Color.CYAN);
        b1.setForeground(Color.blue);
        b2.setForeground(Color.blue);

        p.add(l1);
        p.add(t1);
        p.add(l2);
        p.add(t2);
        p.add(b1);
        p.add(b2);
        add(p);
    }
}


public class Main {
    public static void main(String[] args) {
        conversionWindow cw = new conversionWindow();
    }
}