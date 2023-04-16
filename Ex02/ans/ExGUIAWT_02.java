import java.awt.*;
import java.awt.event.*;

public class ExGUIAWT_02 extends ExGUIAWT_01 implements ActionListener
{
  private Button inc_Button;
  private Button dec_Button;

  public ExGUIAWT_02(String title)
    {
	super(title);
	inc_Button = new Button("Dectease r(r >= 10)");
	dec_Button = new Button("Increase r(r <= 100)");
	inc_Button.addActionListener(this);
	dec_Button.addActionListener(this);
	Panel buttonPanel = new Panel();
	buttonPanel.add(inc_Button);
	buttonPanel.add(dec_Button);
	this.add(buttonPanel, BorderLayout.SOUTH);
  }

  public void actionPerformed(ActionEvent e)
    {
	Object source = e.getSource();
	if (source == inc_Button && radius > 10)
	    {
		radius -= 1;
	    }
	else if (source == dec_Button && radius < 100)
	    {
		radius += 1;
	    }
	canvas.repaint();
    }

    public static void main(String[] args)
    {
        ExGUIAWT_02 window = new ExGUIAWT_02("ExGUIAWT_02");
        window.setVisible(true);
    }
}
