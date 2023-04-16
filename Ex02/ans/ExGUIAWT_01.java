import java.awt.*;

public class ExGUIAWT_01 extends Frame 
{
    protected int radius = 100;
    protected Point center = new Point(200, 100);
    protected Canvas canvas;

    public ExGUIAWT_01(String title)
    {
        super(title);
        canvas = new Canvas()
        {
            public void paint(Graphics g)
            {
                g.setColor(Color.blue);
                g.drawRect(10, 0, 350, 200);
                g.setColor(Color.red);
		g.drawOval(center.x - radius, center.y - radius, 2 * radius, 2 * radius);
		g.setColor(Color.black);
		g.drawString("The circle:", 150, 90);
	        g.drawString("Center: (" + center.x + ", " + center.y + ")", 170, 110);
                g.drawString("Radius: " + radius, 170, 130);
            }
        };
        setSize(400, 300);
        add(canvas, BorderLayout.CENTER);
    }

    public static void main(String[] args)
    {
        ExGUIAWT_01 window = new ExGUIAWT_01("ExGUIAWT_01");
        window.setVisible(true);
    }
}
