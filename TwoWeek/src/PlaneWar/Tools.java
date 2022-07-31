package PlaneWar;

public class Tools {
    // 敌机我机碰撞
    public static boolean enemymycrash(Entity e, Myplane mp) {
        if (Math.abs((e.getX() + 45) - (mp.getX() - 1)) < 40 && Math.abs((e.getY() + 45) - (mp.getY() + 55)) < 40) {
            return true;
        } else {
            return false;
        }
    }

    // 敌机子弹相撞
    public static boolean bulletenemycrash(Entity ea, Entity eb) {
        if ((ea instanceof Enemyplane) && (eb instanceof Bullet)) {
            if (Math.abs((ea.getX() + 45) - (eb.getX() + 10)) < 20 && Math.abs((ea.getY() + 45) - eb.getY()) < 20) {
                return true;
            }
        } else if ((ea instanceof Bullet) && (eb instanceof Enemyplane)) {
            if (Math.abs((ea.getX() + 10) - (eb.getX() + 45)) < 20 && Math.abs(ea.getY() - (eb.getY() + 45)) < 20) {
                return true;
            }
        }
        return false;
    }
}