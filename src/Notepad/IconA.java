package Notepad;

import javax.swing.*;
import java.awt.*;


class IconA implements Icon {

    private Color color;
    private int w = 20;

    IconA(Color c) {
        color = c;

    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(color);
        w = ((JComponent) c).getHeight() / 2;
        int p = w / 4, d = w / 2;
        g.fillOval(x + p, y + p, d, d);
    }

    public int getIconWidth() {
        return w;
    }

    public int getIconHeight() {
        return w;
    }

}
