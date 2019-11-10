package sample;

public class MachineGunTower extends  Tower {
    public MachineGunTower(double x, double y) {
        super(new image("file:images\\1.png"), x, y, new Bullet(new image("file:images\\bullet.png"),100,20,72*2));
    }
}
