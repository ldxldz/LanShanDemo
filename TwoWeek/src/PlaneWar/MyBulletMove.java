package PlaneWar;



import java.util.ArrayList;

public class MyBulletMove extends Thread{
    private Myplane mp;
    private ArrayList<Entity> listmybullet;
    public MyBulletMove (ArrayList<Entity> listmybullet, Myplane mp){
        this.listmybullet=listmybullet;
        this.mp=mp;
    }
    public void run(){
        while(true){
            Bullet upbullet=new Bullet();
            upbullet.m=0;//向上飞
            upbullet.x=mp.x;//upbullet.x=mp.x-11-mp.a
            upbullet.y=mp.y;
            upbullet.list=listmybullet;
            listmybullet.add(upbullet);

            try{
                Thread.sleep(400);//子弹发射的间隔
            }catch(Exception e){
            }
        }
    }
}