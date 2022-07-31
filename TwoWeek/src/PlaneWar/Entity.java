package PlaneWar;

import java.awt.*;

public interface Entity {
    public void move();

    public void draw(Graphics g);

    public int getX();

    public int getY();

    public void hit(int i);
}