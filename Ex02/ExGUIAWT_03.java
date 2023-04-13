import java.awt.*;
import java.awt.event.*;

public class ExGUIAWT_03 extends ExGUIAWT_02 implements MouseListener {

    public ExGUIAWT_03(String title) {
        super(title);
        this.canvas.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        this.center = new Point(x, y);
        this.canvas.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // do nothing
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // do nothing
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // do nothing
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // do nothing
    }
}
