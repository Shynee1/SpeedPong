package Utils;

import java.awt.*;

public class Text {
    public String text;
    public Font font;
    public Color color;
    public double x, y;
    public double width, height;

    public Text(String text, Font font, Color color, double x, double y){
        this.text = text;
        this.font = font;
        this.color = color;
        this.x = x;
        this.y = y;
        this.width = font.getSize()*text.length();
        this.height = font.getSize();
    }

    public void draw(Graphics g2d){
        g2d.setFont(font);
        g2d.setColor(color);

        g2d.drawString(text, (int) x, (int) y);
    }
}
