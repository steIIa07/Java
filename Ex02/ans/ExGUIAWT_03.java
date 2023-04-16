import java.awt.*;
import java.awt.event.*;

public class ExGUIAWT_03 extends ExGUIAWT_02 implements MouseListener
{
    public ExGUIAWT_03(String title)
    {
        super(title);
        this.canvas.addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e)
    {
        int x = e.getX();
        int y = e.getY();
        this.center = new Point(x, y);
        this.canvas.repaint();
    }

    public void mouseEntered(MouseEvent e)
    {
        // do nothing
    }

    public void mouseExited(MouseEvent e)
    {
        // do nothing
    }

    public void mousePressed(MouseEvent e)
    {
        // do nothing
    }

    public void mouseReleased(MouseEvent e)
    {
        // do nothing
    }

    public static void main(String[] args)
    {
        ExGUIAWT_03 window = new ExGUIAWT_03("ExGUIAWT_03");
        window.setVisible(true);
    }
}
