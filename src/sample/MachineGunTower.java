package sample;

public class MachineGunTower extends  Tower {
    public MachineGunTower( int x, int y) {
        super(new image("file:images\\MGTower.png"), x, y, new Bullet(new image("file:images\\bullet2.png"),100,120,100));
    }
}
