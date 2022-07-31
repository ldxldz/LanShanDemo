package PlaneWar;

import java.util.ArrayList;

public class Checkforcrash extends Thread{
    private ArrayList<Entity> listmybullet;
    private ArrayList<Entity> listenemy;
    private Myplane mp;
    private Enemyplane cp;
    public Checkforcrash(ArrayList<Entity> listenemy,ArrayList<Entity> listmybullet, Myplane mp,Enemyplane cp) {
        this.listenemy=listenemy;
        this.listmybullet=listmybullet;
        this.mp=mp;
        this.cp=cp;
    }

    public void run() {
        while (true) {
            for (int i = listmybullet.size() - 1; i > 0; i--) {
                Entity temA = listmybullet.get(i);
                for (int j = 0; j < listenemy.size(); j++) {
                    Entity temB = listenemy.get(j);
                    if (Tools.enemymycrash(temB, mp)) {
                        cp.hit(j);
                        mp.hit(j);
                        temA.hit(i);
                    }
                    if (Tools.bulletenemycrash(temA, temB)) {
                        temA.hit(i);
                        cp.hit(j);
                        temB.hit(j);
                    }
                }
            }
        }
    }
}