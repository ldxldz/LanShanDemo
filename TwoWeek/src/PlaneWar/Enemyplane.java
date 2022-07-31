package PlaneWar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Enemyplane implements Entity{
    int x;
    int y=600;
    Random rand=new Random();
    int a=rand.nextInt(2);//敌机速度判定
    Image image=new ImageIcon("E:\\IdeaProjects\\LanShanDemo\\TwoWeek\\src\\PlaneWar\\敌对小飞机.png").getImage();
    public Enemyplane() {
        Random randy=new Random();
        this.x=randy.nextInt(340)+80;
    }

    public void move() {
        if(a==0){
            y+=2;
        }else if(a==1){
            y+=4;
        }
    }

    public void draw(Graphics g) {
        g.drawImage(image, x, y, 90, 90, null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    ArrayList<Entity> list;

    public void hit(int i) {
        list.remove(i);
    }
}

