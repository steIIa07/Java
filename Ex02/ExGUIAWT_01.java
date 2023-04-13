import java.awt.*;

public class ExGUIAWT_01 extends Frame 
{
    protected int radius = 50;
    protected Point center = new Point(150, 150);
    protected Canvas canvas;

    public ExGUIAWT_01(String title)
    {
        super(title);
        canvas = new Canvas()
        {
            public void paint(Graphics g)
            {
                g.setColor(Color.blue);
                g.fillRect(50, 50, 200, 100);
                g.fillOval(center.x - radius, center.y - radius, 2 * radius, 2 * radius);
                g.setColor(Color.black);
                g.drawString("Radius: " + radius, 50, 200);
                g.drawString("Center: (" + center.x + ", " + center.y + ")", 50, 220);
            }
        };
        setSize(400, 300);
        add(canvas, BorderLayout.CENTER);
    }

    public static void main(String[] args)
    {
        ExGUIAWT_01 window = new ExGUIAWT_01("Window Title");
        window.setVisible(true);
    }
}
