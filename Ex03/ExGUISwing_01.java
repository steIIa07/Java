import javax.swing.*;
import java.awt.*;

public class ExGUISwing_01 extends JFrame
{
    
    protected JButton button1, button2, button3, button4, button5, button6;

    ExGUISwing_01(String title)
    {
        super(title);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        button1 = new JButton("button 1", null);
        button2 = new JButton("button 2", null);
        button3 = new JButton("button 3", null);
        button4 = new JButton("button 4", null);
        button5 = new JButton("button 5", null);
        button6 = new JButton("button 6", null);

        JLabel label = new JLabel("label", null, ABORT); 
        label.setSize(200, 50);
        label.setLocation(100, 100);
        label.setFont(new Font("Serif", Font.BOLD, 16));
        label.setForeground(Color.darkGray);

        JPanel panel = new JPanel();
        panel.setSize(220, 120);
        panel.setLocation(90, 70);
        panel.setBorder(BorderFactory.createBevelBorder(1));

        /*
        add(label, panel, ABORT);
        panel.add(label);
        */

        button1.setSize(80, 30);
        button1.setLocation(20, 200);
        button2.setSize(80, 30);
        button2.setLocation(110, 200);
        button3.setSize(80, 30);
        button3.setLocation(200, 200);
        button4.setSize(80, 30);
        button4.setLocation(290, 200);
        button5.setSize(80, 30);
        button5.setLocation(20, 240);
        button6.setSize(80, 30);
        button6.setLocation(110, 240);

        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);
        add(panel);
        panel.add(label);
    }

    public static void main(String[] argv)
    {
        new ExGUISwing_01("Ex#2: Step 2").setVisible(true);
    }
}
