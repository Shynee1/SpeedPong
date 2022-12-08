package Objects;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ball {
    public double x, y, size;

    private Color color;
    public Ball(double x, double y, double size, Color color){
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;

    }

    public void draw(Graphics2D g2d){
        g2d.setColor(color);
        g2d.fill(new Ellipse2D.Double(x, y, size, size));
    }

}
