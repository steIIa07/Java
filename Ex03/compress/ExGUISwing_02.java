import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExGUISwing_02 extends ExGUISwing_01 implements ActionListener {
    
    private JLabel modeLabel;
    private int track = 1;
    private int indexAM = 0;
    private int indexFM = 0;
    private int[] am = {594, 954, 1134, 1242};
    private float[] fm = {76.1f, 80.0f, 81.3f, 82.5f};

    ExGUISwing_02(String title)
    {
        super(title);
        
        modeLabel = new JLabel("");
        modeLabel.setSize(30, 20);
        modeLabel.setLocation(10, 10);
        modeLabel.setFont(new Font("Gothic", Font.BOLD, 12));
        modeLabel.setForeground(Color.black);
        panel.add(modeLabel);
        
        buttonPW.addActionListener(this);
        buttonAM.addActionListener(this);
        buttonFM.addActionListener(this);
        buttonCD.addActionListener(this);
        buttonUP.addActionListener(this);
        buttonDown.addActionListener(this);        

        buttonPW.setVisible(false);
        buttonUP.setVisible(false);
        buttonDown.setVisible(false);
        // setEnabled?
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        Object source = e.getSource();
        
        if(source == buttonAM)
        {
            if(indexAM == 0)
            {
                buttonUP.setVisible(true); 
                buttonDown.setVisible(false);
            }
            else if(indexAM == am.length - 1)
            {
                buttonUP.setVisible(false); 
                buttonDown.setVisible(true);
            }
            else
            {
                buttonUP.setVisible(true); 
                buttonDown.setVisible(true);    
            }
            buttonPW.setVisible(true);
            label.setText(am[indexAM] + " kHz");
            modeLabel.setText("AM");
        }
        else if(source == buttonFM)
        {
            if(indexFM == 0)
            {
                buttonUP.setVisible(true); 
                buttonDown.setVisible(false);
            }
            else if(indexFM == fm.length - 1)
            {
                buttonUP.setVisible(false); 
                buttonDown.setVisible(true);
            }
            else
            {
                buttonUP.setVisible(true); 
                buttonDown.setVisible(true);    
            }
            buttonPW.setVisible(true);
            label.setText(fm[indexFM] + " MHz");
            modeLabel.setText("FM");
        }
        else if(source == buttonCD)
        {
            if(track == 1)
            {
                buttonUP.setVisible(true); 
                buttonDown.setVisible(false);
            }
            else if(track == 20)
            {
                buttonUP.setVisible(false); 
                buttonDown.setVisible(true);
            }
            else
            {
                buttonUP.setVisible(true); 
                buttonDown.setVisible(true);    
            }
            buttonPW.setVisible(true);
            label.setText("Track " + track + "/20");
            modeLabel.setText("CD");
        }
        else if(source == buttonPW)
        {
            buttonPW.setVisible(false);
            buttonUP.setVisible(false);
            buttonDown.setVisible(false);
            label.setText("Power off");
            modeLabel.setText("");
        }
        else if(source == buttonUP)
        {
            if(modeLabel.getText() == "AM")
            {
                label.setText(am[++indexAM] + " kHz");
                if(indexAM == am.length - 1)
                {
                    buttonUP.setVisible(false);
                }
                if(!buttonDown.isVisible())
                {
                    buttonDown.setVisible(true);
                }
            }
            else if(modeLabel.getText() == "FM")
            {
                label.setText(fm[++indexFM] + " MHz");
                if(indexFM == fm.length - 1)
                {
                    buttonUP.setVisible(false);
                }
                if(!buttonDown.isVisible())
                {
                    buttonDown.setVisible(true);
                }
            }
            else if(modeLabel.getText() == "CD")
            {
                label.setText("Track " + ++track + "/20");
                if(track == 20)
                {
                    buttonUP.setVisible(false);
                }
                    if(!buttonDown.isVisible())
                {
                    buttonDown.setVisible(true);
                }
            }
        }
        else if(source == buttonDown)
        {
            if(modeLabel.getText() == "AM")
            {
                label.setText(am[--indexAM] + " kHz");
                if(indexAM == 0)
                {
                    buttonDown.setVisible(false);
                }
            if(!buttonUP.isVisible())
                {
                    buttonUP.setVisible(true);
                }
            }
            else if(modeLabel.getText() == "FM")
            {
                label.setText(fm[--indexFM] + " MHz");
                if(indexFM == 0)
                {
                    buttonDown.setVisible(false);
                }
                if(!buttonUP.isVisible())
                {
                    buttonUP.setVisible(true);
                }   
            }
            else if(modeLabel.getText() == "CD")
            {
                label.setText("Track " + --track + "/20");
                if(track == 1)
                {
                    buttonDown.setVisible(false);
                }
                if(!buttonUP.isVisible())
                {
                    buttonUP.setVisible(true);
                }
            }
        }      
    }
    public static void main(String[] argv) 
    {
        new ExGUISwing_02("Car Audio").setVisible(true);
    }
}