import javax.swing.*;
import java.awt.*;
import javax.swing.border.BevelBorder;

public class ExGUISwing_01 extends JFrame
{
    
    protected JButton buttonPW, buttonAM, buttonFM, buttonCD, buttonUP, buttonDown;
    protected JPanel panel;
    protected BevelBorder border;
    protected JLabel label;
    
    ExGUISwing_01(String title)
    {
        super(title);
        setSize(370, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        buttonPW = new JButton("PW");
	buttonPW.setSize(70, 30);
        buttonPW.setLocation(5, 5);
	
        buttonAM = new JButton("AM");
	buttonAM.setSize(70, 30);
        buttonAM.setLocation(5, 40);
	
        buttonFM = new JButton("FM");
	buttonFM.setSize(70, 30);
        buttonFM.setLocation(5, 75);
	
        buttonCD = new JButton("CD");
        buttonCD.setSize(70, 30);
        buttonCD.setLocation(280,5);

        buttonUP = new JButton("UP");
	buttonUP.setSize(70, 30);
        buttonUP.setLocation(280, 40);

        buttonDown = new JButton("Down");
	buttonDown.setSize(70, 30);
        buttonDown.setLocation(280, 75);
	
        panel = new JPanel(null);
	border = new BevelBorder(BevelBorder.LOWERED);
        panel.setBorder(border);
        panel.setSize(200, 110);
        panel.setLocation(77, 0);

        label = new JLabel("Power off"); 
        label.setSize(180, 80);
        label.setLocation(30, 15);
        label.setFont(new Font("Gothic", Font.BOLD, 30));
        label.setForeground(Color.green.darker().darker());
       
        add(buttonPW);
        add(buttonAM);
        add(buttonFM);
        add(buttonCD);
        add(buttonUP);
        add(buttonDown);
        add(panel);
        panel.add(label);
    }

    public static void main(String[] argv)
    {
        new ExGUISwing_01("Car Audio").setVisible(true);
    }
}
