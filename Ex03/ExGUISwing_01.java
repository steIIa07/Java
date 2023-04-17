import javax.swing.*;
import java.awt.*;
import javax.swing.border.BevelBorder;

public class ExGUISwing_01 extends JFrame
{
    
    protected JButton button1, button2, button3, button4, button5, button6;
    protected JPanel panel;
    protected BevelBorder border;
    protected JLabel label;
    
    ExGUISwing_01(String title)
    {
        super(title);
        setSize(370, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        button1 = new JButton("PW");
	button1.setSize(50, 20);
        button1.setLocation(10, 5);
	
        button2 = new JButton("AM");
	button2.setSize(50, 20);
        button2.setLocation(10, 45);
	
        button3 = new JButton("FM");
	button3.setSize(50, 20);
        button3.setLocation(10, 85);
	
        button4 = new JButton("CD");
        button4.setSize(50, 20);
        button4.setLocation(310,5);

        button5 = new JButton("UP");
	button5.setSize(50, 20);
        button5.setLocation(310, 45);

        button6 = new JButton("Down");
	button6.setSize(50, 20);
        button6.setLocation(310, 85);
	
        panel = new JPanel(null);
	//border = new BevelBorder(BevelBorder.LOWERED);
        panel.setSize(230, 110);
        panel.setLocation(70, 0);
        panel.setBorder(BorderFactory.createBevelBorder(1));

        label = new JLabel("Power off"); 
        label.setSize(180, 80);
        label.setLocation(40, 15);
        label.setFont(new Font("Gothic", Font.BOLD, 30));
        label.setForeground(Color.green.darker().darker());
       
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
        new ExGUISwing_01("Car Audio").setVisible(true);
    }
}
