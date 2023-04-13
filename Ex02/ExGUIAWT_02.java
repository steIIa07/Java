import java.awt.*;
import java.awt.event.*;

public class ExGUIAWT_02 extends ExGUIAWT_01 implements ActionListener {
  private Button button1;
  private Button button2;

  public ExGUIAWT_02(String title) {
    super(title);
    button1 = new Button("Radius 10");
    button2 = new Button("Radius 100");
    button1.addActionListener(this);
    button2.addActionListener(this);
    Panel buttonPanel = new Panel();
    buttonPanel.add(button1);
    buttonPanel.add(button2);
    this.add(buttonPanel, BorderLayout.SOUTH);
  }

  public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    if (source == button1) {
      radius -= 10;
    } else if (source == button2) {
      radius += 10;
    }
    canvas.repaint();
  }
}
