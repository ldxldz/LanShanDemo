package PlaneWar;



import java.util.ArrayList;

public class EnemyplaneMove extends Thread {
    private ArrayList<Entity> listenemy;
    public EnemyplaneMove (ArrayList<Entity> listenemy) {
        this.listenemy=listenemy;
    }

    public void run(){
        while(true){
            Enemyplane ep=new Enemyplane();
            listenemy.add(ep);
            ep.list=listenemy;

            try {
                Thread.sleep(1000);//敌机出现的间隔
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
}