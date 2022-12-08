package Objects;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rect {
    public double x, y, width, height;
    public Color color;

    public Rect(double x, double y, double width, double height, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void draw(Graphics2D g2d){
        g2d.setColor(color);
        g2d.fill(new Rectangle2D.Double(x, y, width, height));
    }


}
