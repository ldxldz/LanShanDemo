package PlaneWar;

import javax.swing.*;
import java.awt.*;

public class Background implements Entity {
    Image image = new ImageIcon("E:\\IdeaProjects\\LanShanDemo\\TwoWeek\\src\\PlaneWar\\背景.png").getImage();
    int x,y;
    public void move() {
        y += 2;
    }

    public void draw(Graphics g) {
        if (y - image.getHeight(null) >= 0) {
            y = 0;
        }
        g.drawImage(image, x, y, null);
        g.drawImage(image, x, y + image.getHeight(null), null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void hit(int i) {}
}