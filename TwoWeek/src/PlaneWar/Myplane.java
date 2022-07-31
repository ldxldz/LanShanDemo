package PlaneWar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Myplane implements Entity{
    int x=250;
    int y=1850;
    int speed=10;
    int code;//用于KeyListener的检测
    Image image=new ImageIcon("E:\\IdeaProjects\\LanShanDemo\\TwoWeek\\src\\PlaneWar\\飞机.png").getImage();
    public void move() {
        if(code==KeyEvent.VK_UP){
            y -=speed;
        }
        if(code==KeyEvent.VK_DOWN){
            y+=speed;
        }
        if(code==KeyEvent.VK_LEFT){
            x-=speed;
        }
        if(code==KeyEvent.VK_RIGHT){
            x+=speed;
        }
    }

    public void draw(Graphics g) {
        g.drawImage(image, x-44, y, null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void hit(int i) {
        image = new ImageIcon("爆炸.png").getImage();
    }
}

