package PlaneWar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Frame implements KeyListener {
    ArrayList<Entity> listenemy =new ArrayList<Entity>();
    ArrayList<Entity> listmybullet =new ArrayList<Entity>();

    Myplane mp=new Myplane();
    Enemyplane cp = new Enemyplane();
    Background bg=new Background();

    public void UI(){
        JFrame frame=new JFrame();
        frame.setSize(500, 1000);

        frame.setVisible(true);
        Graphics g=frame.getGraphics();

        EnemyplaneMove em=new EnemyplaneMove(listenemy);
        em.start();

        MyBulletMove bm=new MyBulletMove(listmybullet, mp);
        bm.start();

        Checkforcrash cm = new Checkforcrash(listenemy,listmybullet, mp,cp);
        cm.start();

        frame.addKeyListener(this);

        while(true){

            BufferedImage bufferImage = new BufferedImage(frame.getWidth(), 2 * frame.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics bufferedG=bufferImage.getGraphics();
            //在所有元素没有画完前,不显示
            bg.draw(bufferedG);
            bg.move();

            //找到所有的敌机
            for(int i=0;i<listenemy.size();i++){
                Entity entity=listenemy.get(i);

                entity.draw(bufferedG);
                entity.move();
            }
            //找到所有我机子弹
            for(int i=0;i<listmybullet.size();i++){
                Entity entity=listmybullet.get(i);

                entity.draw(bufferedG);
                entity.move();
            }

            mp.draw(bufferedG);
            g.drawImage(bufferImage, 0, -1000, null);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
            }
        }


    }

    public static void main(String[] args) {
        new Frame().UI();
    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        //获取到按下的按钮后传给我机的move()
        mp.code=code;
        mp.move();
    }

    public void keyTyped(KeyEvent e) {}

    public void keyReleased(KeyEvent e) {}
}